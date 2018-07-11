package com.twu.biblioteca.view;

public class Hint {
    public static final String WECLOME_HINT="====================Welcome To Biblioteca System====================";
    public static final String MAINMENU_HINT="1.Show book list\n2.Checkout Book\n3.Return Book\n4.Exit\nPlease input your choice£¨1¡«4)£º";
    public static final String WRONG_CHOICE_HINT="Your input is wrong!Please select a valid option!£¨1¡«4£©£º";


    public static final String BOOK_FORMAT="%-8d%-64s%-32s%-16s";
    public static final String BOOKLIST_HEAD =String.format("%-8s%-64s%-32s%-16s","Id","Title","Author","PublishYear");

    public static final String CHECKOUT_BOOK_SUCCESSFUL="Thank you! Enjoy the book.";
    public static final String CHECKOUT_BOOK_UNSUCCESSFUL="That book is not available.";
    public static final String RETURN_BOOK_SUCCESSFUL="Thank you for returning the book.";
    public static final String RETURN_BOOK_UNSUCCESSFUL="That is not a valid book to return.";

}
