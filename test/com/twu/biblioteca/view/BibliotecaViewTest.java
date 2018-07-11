package com.twu.biblioteca.view;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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

}