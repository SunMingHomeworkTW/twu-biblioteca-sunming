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
    public void should_view_print_book_list() throws Exception {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1001,"Head First Java","Kathy Sierra, Bert Bates","2005-2",true));
        list.add(new Book(1002,"Thinking in Java","Bruce Eckel","2006-2",true));
        list.add(new Book(1003,"Refactoring: Improving the Design of Existing Code","Martin Fowler","1999",true));
        list.add(new Book(1004,"C++ Primer Plus","Stephen Prata","2011-10",true));

        String expectedResult=list.stream().map(Book::toString).collect(Collectors.joining("\n"));

        bibliotecaView.showBookList();
        assertEquals(expectedResult,systemOut());
    }
}