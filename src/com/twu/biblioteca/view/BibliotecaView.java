package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;

import java.util.List;

import static com.twu.biblioteca.view.Hint.*;

public class BibliotecaView {

    public void showWelcomeMessage() {
        System.out.println(WECLOME_HINT);
    }

    public void showBookList(List<Book> bookList) {
        System.out.println(BOOKLIST_HEAD);
        bookList.stream().filter(book -> book.isInStock()).map(Book::toString).forEach(book->System.out.println(book));
    }
}
