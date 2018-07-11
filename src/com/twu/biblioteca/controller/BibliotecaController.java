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
                    bibliotecaView.showMainMenu();
                    break;
                case "2":
                    bibliotecaView.showInputBookId();
                    bibliotecaView.showCheckoutResult(bookRepository.checkout(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "3":
                    bibliotecaView.showInputBookId();
                    bibliotecaView.showReturnResult(bookRepository.returnBook(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "4":
                    isContinue=false;
                    break;
                default:
                    bibliotecaView.showWrongChoiceHint();
                    bibliotecaView.showMainMenu();
                    break;

            }
        }
    }


}
