/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.model;

/**
 *
 * @author choi9
 */
import java.util.Scanner;

public class Login {
    //실질적으로 로그인 업무를  처리하는 클래스
    static String id;
    private static Scanner input;
    public static String getId(){
        input = new Scanner(System.in);
        //스캐너를 통해 아이디를 받아온다. 이때 한글 입력시 출력창에서 id가 깨지는
        //현상이 있어서 영문으로 기재해달라는 요청사항을 기재하였다.
        System.out.println("----------------------");
        System.out.println("--------로그인---------");
        System.out.print("아이디를 입력하십시오(영문) : ");
        id = input.nextLine();
        //id가 공백일 경우 사용자를 구분하려는 본래의 의도가 흐려지므로
        //공백에 대한 메세지를 띄우고 다시 id를 받는다.
        while(id.length() == 0){
            System.out.println("아이디가 공백일 경우 데이터를 남길 수 없습니다.");
            System.out.print("아이디를 입력하십시오(영문) : ");
            id = input.nextLine();
        }
        //id를 반환한다.
        return id;
    }
}
