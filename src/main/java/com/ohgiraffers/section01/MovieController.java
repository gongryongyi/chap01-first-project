package com.ohgiraffers.section01;

import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.ohgiraffers.section01.Template.getSqlSession;

public class MovieController {
    private MovieMapper movieMapper;
    private final MovieService movieService = new MovieService();
    public void selectAllMovie() {
        List<MovieDTO> movieList = movieService.selectAllMovie();

        if (movieList != null){
            movieList.forEach(System.out::println);
        }else{
            System.out.println("메뉴 목록 조회에 실패하였습니다.");
        }

    }
    public void selectSessionMovie(SearchMovie searchMovie) {
        List<MovieDTO> movieList = movieService.searchMovie(searchMovie);

        if(movieList != null && movieList.size() > 0) {
            movieList.forEach(System.out::println);
        } else {
            System.out.println("검색 결과가 존재하지 않습니다.");
        }

    }


    public void selectMovieByCode(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code")); //string 을 int로 변경

        MovieDTO movie = movieService.selectMovieByCode(code);

        if (movie != null){
            System.out.println(movie);
        }else {
            System.out.println("메뉴 조회에 실패하였습니다.");

        }
    }




    public void registMovie(Map<String, String> parameter) {
        String name = parameter.get("name");
        String theather = parameter.get("theather");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        String releaseStatus = parameter.get("releaseStatus");

        MovieDTO movie = new MovieDTO();
        movie.setName(name);
        movie.setTheather(theather);
        movie.setCategoryCode(categoryCode);
        movie.setReleaseStatus(releaseStatus);

        if (movieService.registMovie(movie)){
            System.out.println("신규 영화 등록이 완료 되었습니다");
        }else {
            System.out.println("영화 등록에 실패하였습니다");

        }
    }

    public void modifyMovie(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));
        String name = parameter.get("name");
        String theather = parameter.get("theather");
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));
        String releaseStatus = parameter.get("releaseStatus");


        MovieDTO movie = new MovieDTO();
        movie.setCode(code);
        movie.setName(name);
        movie.setTheather(theather);
        movie.setCategoryCode(categoryCode);
        movie.setReleaseStatus(releaseStatus);

        if (movieService.modifyMovie(movie)){
            System.out.println("영화 수정이 완료 되었습니다");
        }else {
            System.out.println("영화 수정에 실패하였습니다");
        }
    }

    public void deleteMovie(Map<String, String> parameter) {
        int code = Integer.parseInt(parameter.get("code"));


        if (movieService.deleteMenu(code)){
            System.out.println("영화 삭제가 완료 되었습니다");
        }else {
            System.out.println();
            System.out.println("영화 삭제에 실패하였습니다");
        }
    }
}
