package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;

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
        System.out.print(MAINMENU_HINT+"\n");
    }

    public void showWrongChoiceHint() {
        System.out.print(WRONG_CHOICE_HINT +"\n");
    }

    public void showCheckoutResult(boolean checkout) {
        if(checkout)
            System.out.print(CHECKOUT_BOOK_SUCCESSFUL+"\n");
        else
            System.out.print(CHECKOUT_BOOK_UNSUCCESSFUL+"\n");
    }

    public void showReturnResult(boolean returnBook) {
        if(returnBook)
            System.out.print(RETURN_BOOK_SUCCESSFUL+"\n");
        else
            System.out.print(RETURN_BOOK_UNSUCCESSFUL+"\n");
    }
}
