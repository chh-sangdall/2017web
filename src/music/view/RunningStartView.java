/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.view;

/**
 *
 * @author choi9
 */
import music.service.LoginController;
public class RunningStartView {
    public static void main(String[] args){
        //프로그램의 첫부분, LoginController 클래스와 연결된다.(LoginController 클래스로 이동)
        LoginController.startLogin();
    }
}
