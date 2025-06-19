package dao;

import com.distribuida.dao.ClienteRepositorio;
import com.distribuida.dao.FacturaRepositorio;
import com.distribuida.model.Cliente;
import com.distribuida.model.Factura;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class FacturaRepositorioTestIntegracion{
        @Autowired
        private FacturaRepositorio facutraRepositorio;

        @Autowired
        private ClienteRepositorio clienteRepositorio;

        @Test
        public void findAll(){

            List<Factura> facturas = facutraRepositorio.findAll();
            assertNotNull(facturas);
            assertTrue(facturas.size() > 0);
            for(Factura item : facturas){
                System.out.println(item.toString());
            }
        }
        @Test
        public void findOne(){
            Optional<Factura> facturaExistente = facutraRepositorio.findById(1);
            assertNotNull(facturaExistente.isPresent());
            assertEquals("FAC-0001",facturaExistente.orElse(null).getNumFactura());
            System.out.println(facturaExistente.toString());
        }
        @Test
        public void save(){
            Optional<Cliente> cliente = clienteRepositorio.findById(1);
            Factura factura = new Factura(0, "FAC-00099", new Date(),100.0,15.00,115.00,cliente.orElse(null));
            Factura facturaguardada = facutraRepositorio.save(factura);
            assertNotNull(facturaguardada);
            assertEquals("FAC-00099", facturaguardada.getNumFactura());
            assertEquals(115.0, facturaguardada.getTotal());
        }

        @Test
        public void update(){
            Optional<Factura> factura = facutraRepositorio.findById(86);
            Optional<Cliente> cliente = clienteRepositorio.findById(2);
            factura.orElse(null).setNumFactura("FAC-00100");
            factura.orElse(null).setFecha(new Date());
            factura.orElse(null).setTotalNeto(200.00);
            factura.orElse(null).setIva(30.00);
            factura.orElse(null).setTotal(230.00);
            factura.orElse(null).setCliente(cliente.orElse(null));

            Factura facturaActualizada = facutraRepositorio.save(factura.orElse(null));

            assertNotNull(facturaActualizada);
            assertEquals("FAC-00100", facturaActualizada.getNumFactura());
            assertEquals(230.0, facturaActualizada.getTotal());

        }
        @Test
        public void delete(){
            if(facutraRepositorio.existsById(86)) {
                facutraRepositorio.deleteById(86);

            }
            assertFalse(facutraRepositorio.existsById(87));
        }

}

