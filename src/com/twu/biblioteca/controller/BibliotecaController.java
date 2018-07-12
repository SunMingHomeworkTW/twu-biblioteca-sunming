package com.twu.biblioteca.controller;

import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaController {
    private InputReader inputReader;
    private BibliotecaView bibliotecaView;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;

    public BibliotecaController(InputReader inputReader) {
        this.inputReader=inputReader;
        bibliotecaView=new BibliotecaView();
        bookRepository=new BookRepository();
        movieRepository=new MovieRepository();
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
                    bibliotecaView.showCheckoutBookResult(bookRepository.checkout(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "3":
                    bibliotecaView.showInputBookId();
                    bibliotecaView.showReturnBookResult(bookRepository.returnBook(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "4":
                    bibliotecaView.showMovieList(movieRepository.getMovieList());
                    bibliotecaView.showMainMenu();
                    break;
                case "5":
                    bibliotecaView.showInputMovieId();
                    bibliotecaView.showCheckoutMovieResult(movieRepository.checkout(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "6":
                    bibliotecaView.showInputMovieId();
                    bibliotecaView.showReturnMovieResult(movieRepository.returnMovie(Long.parseLong(inputReader.read())));
                    bibliotecaView.showMainMenu();
                    break;
                case "7":
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
