package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.User;
import com.twu.biblioteca.repository.BookRepository;
import com.twu.biblioteca.repository.MovieRepository;
import com.twu.biblioteca.repository.UserRepository;
import com.twu.biblioteca.view.BibliotecaView;

public class BibliotecaController {
    private InputReader inputReader;
    private BibliotecaView bibliotecaView;
    private BookRepository bookRepository;
    private MovieRepository movieRepository;
    private UserRepository userRepository;

    public BibliotecaController(InputReader inputReader) {
        this.inputReader = inputReader;
        bibliotecaView = new BibliotecaView();
        bookRepository = new BookRepository();
        movieRepository = new MovieRepository();
        userRepository = new UserRepository();
    }

    public void run() {
        bibliotecaView.showWelcomeMessage();
        bibliotecaView.showMainMenu();
        boolean isContinue = true;
        boolean isLogin = false;
        while (isContinue) {
            switch (inputReader.read()) {
                case "0":
                    isLogin = validateLogin(inputReader);
                    break;
                case "1":
                    bibliotecaView.showBookList(bookRepository.getBookList());
                    bibliotecaView.showMainMenu();
                    break;
                case "2":
                    if (isLogin) {
                        bibliotecaView.showInputBookId();
                        bibliotecaView.showCheckoutBookResult(bookRepository.checkout(Long.parseLong(inputReader.read())));
                        bibliotecaView.showMainMenu();
                    } else {
                        bibliotecaView.showPleaseLogin();
                        bibliotecaView.showMainMenu();
                    }
                    break;
                case "3":
                    if (isLogin) {
                        bibliotecaView.showInputBookId();
                        bibliotecaView.showReturnBookResult(bookRepository.returnBook(Long.parseLong(inputReader.read())));
                        bibliotecaView.showMainMenu();
                    } else {
                        bibliotecaView.showPleaseLogin();
                        bibliotecaView.showMainMenu();
                    }
                    break;
                case "4":
                    bibliotecaView.showMovieList(movieRepository.getMovieList());
                    bibliotecaView.showMainMenu();
                    break;
                case "5":
                    if (isLogin) {
                        bibliotecaView.showInputMovieId();
                        bibliotecaView.showCheckoutMovieResult(movieRepository.checkout(Long.parseLong(inputReader.read())));
                        bibliotecaView.showMainMenu();
                    } else {
                        bibliotecaView.showPleaseLogin();
                        bibliotecaView.showMainMenu();
                    }
                    break;
                case "6":
                    if (isLogin) {
                        bibliotecaView.showInputMovieId();
                        bibliotecaView.showReturnMovieResult(movieRepository.returnMovie(Long.parseLong(inputReader.read())));
                        bibliotecaView.showMainMenu();
                    } else {
                        bibliotecaView.showPleaseLogin();
                        bibliotecaView.showMainMenu();
                    }
                    break;
                case "7":
                    isContinue = false;
                    break;
                default:
                    bibliotecaView.showWrongChoiceHint();
                    bibliotecaView.showMainMenu();
                    break;
            }
        }
    }

    private boolean validateLogin(InputReader inputReader) {
        bibliotecaView.showInputLibraryNumber();
        String libraryNumber = inputReader.read();
        bibliotecaView.showInputPassword();
        String password = inputReader.read();
        User user = userRepository.isValid(libraryNumber, password);
        if (user != null) {
            bibliotecaView.showLoginSuccessfully();
            if (inputReader.read().equals("1")) {
                bibliotecaView.showUserInformation(user);
            }
            bibliotecaView.showMainMenu();
            return true;
        } else {
            bibliotecaView.showLoginUnsuccessfully();
            if(inputReader.read().equals("Y"))
                validateLogin(inputReader);
            else
                bibliotecaView.showMainMenu();
            return false;
        }
    }


}
