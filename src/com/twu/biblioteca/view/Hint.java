package com.twu.biblioteca.view;

public class Hint {
    public static final String WECLOME_HINT="====================Welcome To Biblioteca System====================";
    public static final String SEPARATE="--------------------------------------------------------------------\n";
    public static final String MAINMENU_HINT=SEPARATE+"0.Login in\n1.Show book list\n2.Checkout book\n3.Return book\n" +
            "4.Show movie list\n5.Checkout movie\n6.Return movie\n7.Quit\nPlease input your choice£¨0¡«7)£º\n"+SEPARATE;
    public static final String WRONG_CHOICE_HINT="Your input is wrong!\nPlease select a valid option!£¨1¡«4£©£º";

    public static final String BOOK_FORMAT="%-8d%-64s%-32s%-16s";
    public static final String BOOKLIST_HEAD =String.format("%-8s%-64s%-32s%-16s","Id","Title","Author","PublishYear");

    public static final String INPUT_BOOKID_HINT="Please input the book id:";
    public static final String CHECKOUT_BOOK_SUCCESSFUL="Thank you! Enjoy the book.";
    public static final String CHECKOUT_BOOK_UNSUCCESSFUL="That book is not available.";
    public static final String RETURN_BOOK_SUCCESSFUL="Thank you for returning the book.";
    public static final String RETURN_BOOK_UNSUCCESSFUL="That is not a valid book to return.";

    public static final String MOVIE_FORMAT="%-8d%-64s%-16s%-32s-8s";
    public static final String MOVIELIST_HEAD =String.format("%-8s%-64s%-16s%-32s-8s","Id","Name","Year","Director","Rating");

    public static final String INPUT_MOVIEID_HINT="Please input the movie id:";
    public static final String CHECKOUT_MOVIE_SUCCESSFUL="Thank you! Enjoy the movie.";
    public static final String CHECKOUT_MOVIE_UNSUCCESSFUL="That movie is not available.";
    public static final String RETURN_MOVIE_SUCCESSFUL="Thank you for returning the movie.";
    public static final String RETURN_MOVIE_UNSUCCESSFUL="That is not a valid movie to return.";

    public static final String INPUT_LIBRARYNUMBER_HINT="Please input your library number:";
    public static final String INPUT_PASSWORD_HINT="Please input your password:";
    public static final String LOGIN_SUCCESSFUL="Login in successfully!\n"+SEPARATE+"1.See your user information\n" +
            "2.Return to mainmenu\n"+SEPARATE;
    public static final String LOGIN_UNSUCCESSFUL="Your library number and password are invalid.Please input again!\n";

    public static final String PLEASE_LOGIN="You haven't login in.Please login in first!\n";

    public static final String USER_FORMAT="%-8s%-16s%-16s%";
    public static final String USER_HEAD =String.format(USER_FORMAT,"Name","Email address","Phone number");
}
