package com.twu.biblioteca.controller;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.view.BibliotecaView;

import java.util.Scanner;

public class BibliotecaController {
    private BibliotecaView bibliotecaView;
    private BookRepository bookRepository;

    public BibliotecaController() {
        bibliotecaView=new BibliotecaView();
        bookRepository=new BookRepository();
    }

    public void run(){
        bibliotecaView.showWelcomeMessage();
        boolean isContinue=true;
        Scanner sc=new Scanner(System.in);
        while (isContinue){
            switch (sc.next()){
                case "1":
                    bibliotecaView.showBookList(bookRepository.getBookList());
                    break;
                case "2":
            }
        }
    }


}
