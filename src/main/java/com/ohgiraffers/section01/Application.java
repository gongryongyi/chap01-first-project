package com.ohgiraffers.section01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieController movieController = new MovieController();
        do {
            System.out.println("======= 영화 관리 ========");
            System.out.println("1. 영화 전체 조회");
            System.out.println("2. 영화 코드로 영화 조회");
            System.out.println("3. 신규 영화 추가");
            System.out.println("4. 영화 수정");
            System.out.println("5. 영화 삭제");
            System.out.println("9. 프로그램 종료하기");
            System.out.print("영화 관리 번호 입력 : ");
            int no = sc.nextInt();

            switch (no){
                case 1 : inputSelectMovie(); break;
                case 2 : movieController.selectMovieByCode(inputMovieCode()); break;
                case 3 : movieController.registMovie(addMovie()); break;
                case 4 : movieController.modifyMovie(modifyMovie()); break;
                case 5 : movieController.deleteMovie(inputMovieCode());
                case 9 :
                    System.out.println("프로그램을 종료합니다."); return;
                default:
                    System.out.println("잘못 된 번호를 선택하였습니다.");
            }
        }while(true);
    }




    private static void inputSelectMovie() {
        Scanner sc = new Scanner(System.in);
        MovieController movieController = new MovieController();
        do {
            System.out.println("======== 조회 선택 =========");
            System.out.println("1. 영화 전체 조회");
            System.out.println("2. 상영 여부로 조회(상영 / 비상영)");
            System.out.println("9. 이전 메뉴로");
            System.out.print("번호를 입력하세요 : ");
            int  no = sc.nextInt();

            switch (no){
                case 1 : movieController.selectAllMovie(); break;
                case 2 : movieController.selectSessionMovie(inputMovie()); break;
                case 9 : return;
                default:
                    System.out.println("잘못 된 번호를 선택하였습니다.");
            }
        }while (true);
    }

    private static SearchMovie inputMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.print("1. 상영 여부를 입력해주세요(상영 / 비상영) : ");
        String value = sc.nextLine();

        return new SearchMovie("condition", value);
    }

    private static Map<String, String> inputMovieCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("영화 코드를 입력하세요: ");
        String code = sc.nextLine();

        Map<String, String> prameter = new HashMap<>();
        prameter.put("code", code);

        return prameter;

    }

    private static Map<String, String> addMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.print("영화 제목을 입력하세요 : " );
        String name = sc.nextLine();
        System.out.print("상영관을 입력하세요 : " );
        String theather = sc.nextLine();
        System.out.print("카테고리 코드를 입력하세요 : " );
        String categoryCode = sc.nextLine();
        System.out.print("상영 여부를 입력해주세요 : ");
        String releaseStatus = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("theather", theather);
        parameter.put("categoryCode", categoryCode);
        parameter.put("releaseStatus", releaseStatus);

        return parameter;
    }
    private static Map<String, String> modifyMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 영화 코드를 입력하세요 : " );
        String code = sc.nextLine();
        System.out.print("수정할 영화 이름을 입력하세요 : " );
        String name = sc.nextLine();
        System.out.print("수정할 상영관을 입력하세요 : " );
        String theather = sc.nextLine();
        System.out.print("수정할 카테고리 코드를 입력하세요 : " );
        String categoryCode = sc.nextLine();
        System.out.print("상영 여부를 입력하세요 : ");
        String releaseStatus = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("theather", theather);
        parameter.put("categoryCode", categoryCode);
        parameter.put("releaseStatus", releaseStatus);

        return parameter;
    }
}
