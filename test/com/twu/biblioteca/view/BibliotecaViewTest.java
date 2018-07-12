package com.twu.biblioteca.view;

import com.twu.biblioteca.entity.Book;
import com.twu.biblioteca.entity.Movie;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.twu.biblioteca.view.Hint.*;
import static org.junit.Assert.*;

public class BibliotecaViewTest {
    private ByteArrayOutputStream outStream = new ByteArrayOutputStream();
    private BibliotecaView bibliotecaView;

    @Before
    public void before() {
        bibliotecaView = new BibliotecaView();
        System.setOut(new PrintStream(outStream));
    }

    public String systemOut() {
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
        list.add(new Book(1001, "Head First Java", "Kathy Sierra, Bert Bates", "2005", true));
        list.add(new Book(1002, "Thinking in Java", "Bruce Eckel", "2006", true));
        list.add(new Book(1003, "Refactoring: Improving the Design of Existing Code", "Martin Fowler", "1999", true));
        list.add(new Book(1004, "C++ Primer Plus", "Stephen Prata", "2011", true));

        String expectedResult = list.stream().map(Book::toString).collect(Collectors.joining("\n"));

        bibliotecaView.showBookList(list);
        assertTrue(systemOut().contains(expectedResult));
    }


    @Test
    public void should_print_main_menu() throws Exception {
        bibliotecaView.showMainMenu();
        assertTrue(systemOut().startsWith(MAINMENU_HINT));
    }

    @Test
    public void should_print_wrong_choice_hint() throws Exception {
        bibliotecaView.showWrongChoiceHint();
        assertTrue(systemOut().startsWith(WRONG_CHOICE_HINT));
    }

    @Test
    public void should_view_print_movie_list() throws Exception {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie(1001, "Titanic", "1997", "James Cameron ", "9", true));
        list.add(new Movie(1002, "Big Hero 6", "2014", "Don Hall", "8", true));
        list.add(new Movie(1003, "Iron Man", "2008", "Jon Favreau", "8", true));
        list.add(new Movie(1004, "Captain America: The First Avenger ", "2011", " Joe Johnston", "7", true));

        String expectedResult = list.stream().map(Movie::toString).collect(Collectors.joining("\n"));

        bibliotecaView.showMovieList(list);
        assertTrue(systemOut().contains(expectedResult));
    }
}