package com.twu.biblioteca;

import com.twu.biblioteca.controller.BibliotecaController;
import com.twu.biblioteca.controller.InputReader;
import com.twu.biblioteca.repository.BookRepository;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaController bibliotecaController=new BibliotecaController(new InputReader());
        bibliotecaController.run();
    }
}
