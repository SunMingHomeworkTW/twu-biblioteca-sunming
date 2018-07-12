package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import com.twu.biblioteca.entity.User;

import java.util.List;

import static com.twu.biblioteca.view.Hint.*;

public class BibliotecaView {

    public void showWelcomeMessage() {
        System.out.print(WECLOME_HINT+"\n");
    }

    public void showBookList(List<Book> bookList) {
        System.out.println(BOOKLIST_HEAD);
        bookList.stream().map(Book::toString).forEach(book->System.out.print(book+"\n"));
    }

    public void showMainMenu() {
        System.out.print(MAINMENU_HINT);
    }

    public void showWrongChoiceHint() {
        System.out.print(WRONG_CHOICE_HINT +"\n");
    }

    public void showInputBookId(){
        System.out.print(INPUT_BOOKID_HINT+"\n");
    }

    public void showCheckoutBookResult(boolean checkout) {
        if(checkout)
            System.out.print(CHECKOUT_BOOK_SUCCESSFUL+"\n");
        else
            System.out.print(CHECKOUT_BOOK_UNSUCCESSFUL+"\n");
    }

    public void showReturnBookResult(boolean returnBook) {
        if(returnBook)
            System.out.print(RETURN_BOOK_SUCCESSFUL+"\n");
        else
            System.out.print(RETURN_BOOK_UNSUCCESSFUL+"\n");
    }

    public void showMovieList(List<Movie> movieListist) {
        System.out.println(MOVIELIST_HEAD);
        movieListist.stream().map(Movie::toString).forEach(movie->System.out.print(movie+"\n"));
    }

    public void showInputMovieId(){
        System.out.print(INPUT_MOVIEID_HINT+"\n");
    }

    public void showCheckoutMovieResult(boolean checkout) {
        if(checkout)
            System.out.print(CHECKOUT_MOVIE_SUCCESSFUL+"\n");
        else
            System.out.print(CHECKOUT_MOVIE_UNSUCCESSFUL+"\n");
    }

    public void showReturnMovieResult(boolean returnMovie) {
        if(returnMovie)
            System.out.print(RETURN_MOVIE_SUCCESSFUL+"\n");
        else
            System.out.print(RETURN_MOVIE_UNSUCCESSFUL+"\n");
    }

    public void showInputLibraryNumber() {
        System.out.print(INPUT_LIBRARYNUMBER_HINT+"\n");
    }

    public void showInputPassword() {
        System.out.print(INPUT_PASSWORD_HINT+"\n");
    }

    public void showLoginSuccessfully(){
        System.out.print(LOGIN_SUCCESSFUL);
    }

    public void showLoginUnsuccessfully(){
        System.out.print(LOGIN_UNSUCCESSFUL);
    }

    public void showPleaseLogin() {
        System.out.print(PLEASE_LOGIN);
    }

    public void showUserInformation(User user) {
        System.out.print(USER_HEAD+"\n"+user.toString()+"\n");
    }
}
