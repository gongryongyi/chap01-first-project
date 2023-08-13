package com.ohgiraffers.section01;

import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.Template.getSqlSession;

public class MovieService {
    private MovieMapper movieMapper;
    public List<MovieDTO> selectAllMovie() {
        SqlSession sqlSession = getSqlSession();

        movieMapper = sqlSession.getMapper(MovieMapper.class);
        List<MovieDTO> movieList = movieMapper.selectAllMovie();
        sqlSession.close();
        return movieList;
    }

    public List<MovieDTO> searchMovie(SearchMovie searchMovie) {
        SqlSession sqlSession = getSqlSession();

        movieMapper = sqlSession.getMapper(MovieMapper.class);
        List<MovieDTO> movieList = movieMapper.searchMovie(searchMovie);

        sqlSession.close();
        return movieList;
    }


    public MovieDTO selectMovieByCode(int code) {
        SqlSession sqlSession = getSqlSession();

        movieMapper = sqlSession.getMapper(MovieMapper.class);
        MovieDTO movie = movieMapper.selectMovieByCode(code);

        sqlSession.close();
        return movie;
    }


    public boolean registMovie(MovieDTO movie) {
        SqlSession sqlSession = getSqlSession();
        movieMapper = sqlSession.getMapper(MovieMapper.class);

        int result = movieMapper.insertMovie(movie);

        if (result > 0){
            sqlSession.commit();

        }else
            sqlSession.rollback();

        sqlSession.close();

        return result > 0;
    }

    public boolean modifyMovie(MovieDTO movie) {
        SqlSession sqlSession = getSqlSession();
        movieMapper = sqlSession.getMapper(MovieMapper.class);

        int result = movieMapper.updateMovie(movie);

        if (result > 0){
            sqlSession.commit();

        }else
            sqlSession.rollback();

        sqlSession.close();

        return result > 0;
    }

    public boolean deleteMenu(int code) {
        SqlSession sqlSession = getSqlSession();
        movieMapper = sqlSession.getMapper(MovieMapper.class);

        int result = movieMapper.deleteMenu(code);

        if (result > 0){
            sqlSession.commit();

        }else
            sqlSession.rollback();

        sqlSession.close();

        return result > 0;
    }
}
