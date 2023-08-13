package com.ohgiraffers.section01;

import java.util.List;

public interface MovieMapper {


    List<MovieDTO> selectAllMovie();

    List<MovieDTO> searchMovie(SearchMovie searchMovie);
    
    MovieDTO selectMovieByCode(int code);

    int insertMovie(MovieDTO movie);

    int updateMovie(MovieDTO movie);

    int deleteMenu(int code);
}


