package com.distribuida.test;

import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
}
private Cliente;
@BeforeEach
public void setUp(){
    Cliente = new Cliente(1,"1728580224","Alexis","Guanopatin","Pifo","0993095547","alexis1234@gmail.com");

}

@Test
public void testClienteConstructorAndSetters(){
    assertAll("Validar datos Cliente"),
    () -> asserEquals(1, cliente.getIdCliente()),
            () -> asserEquals(1, cliente.getIdCliente()),
            () -> assertEquals("1728580224", cliente.getCedula()),
            () -> assertEquals("Alexis", cliente.getNombre()),
            () -> assertEquals("Guanopatin", cliente.getApellido()),
            () -> assertEquals("Pifo", cliente.getDireccion()),
            () -> assertEquals("0993095547", cliente.getTelefono());
}

@Test
public void testClienteSetters(){
    cliente = new Cliente();

    Cliente.setIdCliente(2);
    Cliente.setCedula("1728580223");
    Cliente.setNombre("Alex"();
    Cliente.setApellido("Guamani");
    Cliente.setDireccion("Tumbaco");
    Cliente.setTelefono("0993095546");
    Cliente.setCorreo("alex123@gmail.com");

}