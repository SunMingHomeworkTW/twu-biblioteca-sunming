package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.view.Hint.*;
import static org.junit.Assert.*;

public class BibliotecaViewTest {
    private ByteArrayOutputStream outStream=new ByteArrayOutputStream();
    private  BibliotecaView bibliotecaView;

    @Before
    public void before(){
        bibliotecaView=new BibliotecaView();
        System.setOut(new PrintStream(outStream));
    }

    public String systemOut(){
        return outStream.toString();
    }

    @Test
    public void should_view_print_the_welcome_info() throws Exception {
        bibliotecaView.showWelcomeMessage();
        assertTrue(systemOut().startsWith(WECLOME_HINT));
    }

    @Test
    public void should_view_print_book_list_that_is_in_stock() throws Exception {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1001,"Head First Java","Kathy Sierra, Bert Bates","2005",true));
        list.add(new Book(1002,"Thinking in Java","Bruce Eckel","2006",true));
        list.add(new Book(1003,"Refactoring: Improving the Design of Existing Code","Martin Fowler","1999",true));
        list.add(new Book(1004,"C++ Primer Plus","Stephen Prata","2011",true));

        String expectedResult=list.stream().filter(book -> book.isInStock()).map(Book::toString).collect(Collectors.joining("\n"));

        bibliotecaView.showBookList(list);
        assertTrue(systemOut().contains(expectedResult));
    }

    @Test
    public void should_not_view_print_book_list_that_is_not_in_stock() throws Exception {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1001,"Head First Java","Kathy Sierra, Bert Bates","2005",true));
        list.add(new Book(1002,"Thinking in Java","Bruce Eckel","2006",true));
        list.add(new Book(1003,"Refactoring: Improving the Design of Existing Code","Martin Fowler","1999",true));
        list.add(new Book(1004,"C++ Primer Plus","Stephen Prata","2011",false));

        String notExpectedResult="C++ Primer Plus";
        bibliotecaView.showBookList(list);
        assertFalse(systemOut().contains(notExpectedResult));
    }

    @Test
    public void should_print_main_menu() throws Exception {
        bibliotecaView.showMainMenu();
        assertTrue(systemOut().startsWith(MAINMENU_HINT));
    }
}