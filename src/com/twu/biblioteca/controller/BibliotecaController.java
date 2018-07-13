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
        showWelcome();
        boolean isContinue = true;
        boolean isLogin = false;
        while (isContinue) {
            switch (inputReader.read()) {
                case "0":
                    isLogin = validateLogin();
                    break;
                case "1":
                    showBookList();
                    break;
                case "2":
                    checkoutBook(isLogin);
                    break;
                case "3":
                    returnBook(isLogin);
                    break;
                case "4":
                    showMovieList();
                    break;
                case "5":
                    checkoutMovie(isLogin);
                    break;
                case "6":
                    returnMovie(isLogin);
                    break;
                case "7":
                    isContinue = false;
                    break;
                default:
                    wrongChoice();
                    break;
            }
        }
    }

    private void showWelcome() {
        bibliotecaView.showWelcomeMessage();
        bibliotecaView.showMainMenu();
    }

    private boolean validateLogin() {
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
                validateLogin();
            else
                bibliotecaView.showMainMenu();
            return false;
        }
    }

    private void showBookList() {
        bibliotecaView.showBookList(bookRepository.getBookList());
        bibliotecaView.showMainMenu();
    }

    private void checkoutBook(boolean isLogin) {
        if (isLogin) {
            bibliotecaView.showInputBookId();
            bibliotecaView.showCheckoutBookResult(bookRepository.checkout(Long.parseLong(inputReader.read())));
            bibliotecaView.showMainMenu();
        } else {
            bibliotecaView.showPleaseLogin();
            bibliotecaView.showMainMenu();
        }
    }

    private void returnBook(boolean isLogin) {
        if (isLogin) {
            bibliotecaView.showInputBookId();
            bibliotecaView.showReturnBookResult(bookRepository.returnBook(Long.parseLong(inputReader.read())));
            bibliotecaView.showMainMenu();
        } else {
            bibliotecaView.showPleaseLogin();
            bibliotecaView.showMainMenu();
        }
    }

    private void showMovieList() {
        bibliotecaView.showMovieList(movieRepository.getMovieList());
        bibliotecaView.showMainMenu();
    }

    private void checkoutMovie(boolean isLogin) {
        if (isLogin) {
            bibliotecaView.showInputMovieId();
            bibliotecaView.showCheckoutMovieResult(movieRepository.checkout(Long.parseLong(inputReader.read())));
            bibliotecaView.showMainMenu();
        } else {
            bibliotecaView.showPleaseLogin();
            bibliotecaView.showMainMenu();
        }
    }

    private void returnMovie(boolean isLogin) {
        if (isLogin) {
            bibliotecaView.showInputMovieId();
            bibliotecaView.showReturnMovieResult(movieRepository.returnMovie(Long.parseLong(inputReader.read())));
            bibliotecaView.showMainMenu();
        } else {
            bibliotecaView.showPleaseLogin();
            bibliotecaView.showMainMenu();
        }
    }

    private void wrongChoice() {
        bibliotecaView.showWrongChoiceHint();
        bibliotecaView.showMainMenu();
    }
}
