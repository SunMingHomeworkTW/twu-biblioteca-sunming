package com.twu.biblioteca.repository;

import com.twu.biblioteca.entity.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MovieRepository {
    List<Movie> movieList;

    public MovieRepository() {
        movieList=new ArrayList<>();
        movieList.add(new Movie(1001,"Titanic","1997","James Cameron ","9",true));
        movieList.add(new Movie(1002,"Big Hero 6","2014","Don Hall","8",true));
        movieList.add(new Movie(1003,"Iron Man","2008","Jon Favreau","8",true));
        movieList.add(new Movie(1004,"Captain America: The First Avenger ","2011"," Joe Johnston","7",true));
    }

    public List<Movie> getMovieList() {
        return movieList.stream().filter(movie -> movie.isInStock()).collect(Collectors.toList());
    }


}
