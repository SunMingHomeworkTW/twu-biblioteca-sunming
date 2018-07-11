package com.twu.biblioteca.controller;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.repository.BookRepository;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.view.Hint.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BibliotecaControllerTest {
    private ByteArrayOutputStream outStream=new ByteArrayOutputStream();
    private InputReader inputReader;
    private BibliotecaController bibliotecaController;

    @Before
    public void before(){
        inputReader=mock(InputReader.class);
        bibliotecaController=new BibliotecaController(inputReader);
        System.setOut(new PrintStream(outStream));
    }

    public String systemOut(){
        return outStream.toString();
    }

    @Test
    public void should_print_welcome_message_and_mainmenu_when_run() throws Exception {
        when(inputReader.read()).thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().startsWith(WECLOME_HINT + "\n" + MAINMENU_HINT));
    }

    @Test
    public void should_print_wrong_choice_hint_when_input_is_invalid() throws Exception {
        when(inputReader.read()).thenReturn("9").thenReturn("4");;
        bibliotecaController.run();
        assertTrue(systemOut().contains(WRONG_CHOICE_HINT));
    }

    @Test
    public void should_print_book_list_when_input_is_1() throws Exception {
        List<Book> list = new ArrayList<>();
        list.add(new Book(1001,"Head First Java","Kathy Sierra, Bert Bates","2005",true));
        list.add(new Book(1002,"Thinking in Java","Bruce Eckel","2006",true));
        list.add(new Book(1003,"Refactoring: Improving the Design of Existing Code","Martin Fowler","1999",true));
        list.add(new Book(1004,"C++ Primer Plus","Stephen Prata","2011",true));

        String expectedResult=list.stream().filter(book -> book.isInStock()).map(Book::toString).collect(Collectors.joining("\n"));
        when(inputReader.read()).thenReturn("1").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(expectedResult));
    }

    @Test
    public void should_print_checkout_successful_hint_when_input_is_2_and_id_is_avaliable() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("1001").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(CHECKOUT_BOOK_SUCCESSFUL));
    }

    @Test
    public void book_that_has_been_checkout_should_not_appear_in_the_list() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("1001").thenReturn("1").thenReturn("4");
        bibliotecaController.run();
        assertFalse(systemOut().contains("Head First Java"));
    }

    @Test
    public void should_print_checkout_unsuccessful_hint_when_input_is_2_and_id_is_not_avaliable() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("10008").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(CHECKOUT_BOOK_UNSUCCESSFUL));
    }

    @Test
    public void should_print_checkout_unsuccessful_hint_when_input_is_2_and_id_is_has_been_checkout() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("1001").thenReturn("2").thenReturn("1001").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(CHECKOUT_BOOK_UNSUCCESSFUL));
    }

    @Test
    public void should_print_return_successful_hint_when_input_is_3_and_id_is_avaliable() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("1001").thenReturn("3").thenReturn("1001").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(RETURN_BOOK_SUCCESSFUL));
    }

    @Test
    public void book_that_has_been_RETURNED_should_appear_in_the_list() throws Exception {
        when(inputReader.read()).thenReturn("2").thenReturn("1001").thenReturn("3").thenReturn("1001").thenReturn("1").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains("Head First Java"));
    }

    @Test
    public void should_print_return_unsuccessful_hint_when_input_is_3_and_id_is_not_avaliable() throws Exception {
        when(inputReader.read()).thenReturn("3").thenReturn("10008").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(RETURN_BOOK_UNSUCCESSFUL));
    }

    @Test
    public void should_print_return_unsuccessful_hint_when_input_is_3_and_id_is_in_stock() throws Exception {
        when(inputReader.read()).thenReturn("3").thenReturn("1001").thenReturn("4");
        bibliotecaController.run();
        assertTrue(systemOut().contains(RETURN_BOOK_UNSUCCESSFUL));
    }
}