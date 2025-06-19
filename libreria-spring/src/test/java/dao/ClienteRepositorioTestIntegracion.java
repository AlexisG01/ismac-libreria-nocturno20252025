package com.distribuida.dao;

import com.distribuida.dao.ClienteRepositorio;
import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class ClienteRepositorioTestIntegracion {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Test
    public void findAll(){
        List<Cliente> clientes = clienteRepositorio.findAll();
        assertNotNull(clientes);
        assertTrue(clientes.size() > 0);
        for (Cliente item : clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Cliente> cliente = clienteRepositorio.findById(1);
        assertTrue(cliente.isPresent(), "El cliente con id = 39 deberia existir");
        System.out.println(cliente.toString());
    }
    @Test
    public void  save(){
        Cliente cliente = new Cliente(0,"1728580224","Juan","Perez","Tumbaco","0993099554","ejemplo@ejemplo.com");
        Cliente clienteGuardado = clienteRepositorio.save(cliente);
        assertNotNull(clienteGuardado.getIdCliente(),"El cliente guardado debe tener un id");
        assertEquals("1728580224", clienteGuardado.getCedula());
        assertEquals("Juan", clienteGuardado.getNombre());
    }

    @Test
    public void update(){
        Optional<Cliente> clienteExistente = clienteRepositorio.findById(40);
        assertTrue(clienteExistente.isPresent());

        clienteExistente.orElse(null).setCedula("1728580224");
        clienteExistente.orElse(null).setNombre("Juan");
        clienteExistente.orElse(null).setApellido("Perez");
        clienteExistente.orElse(null).setDireccion("Pifo");
        clienteExistente.orElse(null).setTelefono("0999999999");
        clienteExistente.orElse(null).setCorreo("ejemplo@ejemplo.com");

        Cliente clienteActualizado = clienteRepositorio.save(clienteExistente.orElse(null));

        assertEquals("Juan2", clienteActualizado.getNombre());
        assertEquals("Perez2", clienteActualizado.getApellido());

    }

    @Test
    public void delete(){
        if(clienteRepositorio.existsById(39)){
            clienteRepositorio.deleteById(39);
        }
        assertFalse(clienteRepositorio.existsById(40),"El id = 40 deberia haberse eliminado");
    }
}


