package com.distribuida.principal;

import com.distribuida.entities.Libro;
import com.distribuida.entities.Categoria;
import com.distribuida.entities.Autor;

public class LibroPrincipal {
    public static void main(String[] Args){

        Categoria categoria = new Categoria(1,"Ciencia Ficcion","Mitos");
        Autor autor = new Autor(1,"Alexis","Guanopatin","Ecuador","Pifo","0993095547","alexis1234@gmail.com");
        Libro libro = new Libro(1,"Otros Mundos","Planeta Junior",400,"Primera Edicion","Esp","Ficcion","Pasta blanda","001-01-001",15,"azul","Libro de bolsillo","8.99");

        libro.setCategoria(categoria);
        libro.setAutor(autor);

        System.out.println(libro);

    }
}
