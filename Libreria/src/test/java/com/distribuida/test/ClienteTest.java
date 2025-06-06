package com.distribuida.test;

import com.distribuida.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

private Cliente cliente;

@BeforeEach
public void setUp(){
    cliente = new Cliente(1,"1728580224","Alexis","Guanopatin","Pifo","0993095547","alexis1234@gmail.com");

}

@Test
public void testClienteConstructorAndSetters(){
    assertAll("Validar datos Cliente",
            () -> assertEquals(1, cliente.getInCliente()),
            () -> assertEquals("1728580224", cliente.getCedula()),
            () -> assertEquals("Alexis", cliente.getNombre()),
            () -> assertEquals("Guanopatin", cliente.getApellido()),
            () -> assertEquals("Pifo", cliente.getDireccion()),
            () -> assertEquals("0993095547", cliente.getTelefono()),
            () -> assertEquals("alexis1234@gmail.com", cliente.getCorreo())
            );
}

@Test
public void testClienteSetters(){
    cliente = new Cliente();

    cliente.setInCliente(2);
    cliente.setCedula("1728580223");
    cliente.setNombre("Alex2");
    cliente.setApellido("Guamani2");
    cliente.setDireccion("Tumbaco");
    cliente.setTelefono("0993095546");
    cliente.setCorreo("alex123@gmail.com");

    assertAll( "Validar datos Cliente",
        ()-> assertEquals(2,cliente.getInCliente()),
        ()-> assertEquals("Alex2",cliente.getNombre()),
        ()-> assertEquals("Guamani2",cliente.getApellido()),
        ()-> assertEquals("Tumbaco",cliente.getDireccion()),
        ()-> assertEquals("0993095546",cliente.getTelefono()),
        ()-> assertEquals("alex123@gmail.com",cliente.getCorreo())
     );
}

    @Test
public void testToString(){

    String str = cliente.toString();
    assertAll( "Validar datos de Cliente",
            ()-> assertTrue(str.contains("1")),
            ()-> assertTrue(str.contains("1728580224")),
            ()-> assertTrue(str.contains("Alexis")),
            ()-> assertTrue(str.contains("Guanopatin")),
            ()-> assertTrue(str.contains("Pifo")),
            ()-> assertTrue(str.contains("0993095547")),
            ()-> assertTrue(str.contains("alexis1234@gmail.com"))
    );
}
}
