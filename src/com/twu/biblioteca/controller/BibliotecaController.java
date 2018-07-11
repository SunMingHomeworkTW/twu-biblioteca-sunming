package com.twu.biblioteca.controller;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.view.BibliotecaView;

import java.util.Scanner;

public class BibliotecaController {
    private InputReader inputReader;
    private BibliotecaView bibliotecaView;
    private BookRepository bookRepository;

    public BibliotecaController(InputReader inputReader) {
        this.inputReader=inputReader;
        bibliotecaView=new BibliotecaView();
        bookRepository=new BookRepository();
    }

    public void run(){
        bibliotecaView.showWelcomeMessage();
        bibliotecaView.showMainMenu();
        boolean isContinue=true;
        while (isContinue){
            switch (inputReader.read()){
                case "1":
                    bibliotecaView.showBookList(bookRepository.getBookList());
                    break;
                case "2":

                case "3":

                case "4":
                    isContinue=false;
                    break;
                default:
                    bibliotecaView.showWrongChoiceHint();
                    break;

            }
        }
    }


}
