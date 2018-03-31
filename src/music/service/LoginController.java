/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.service;

/**
 *
 * @author choi9
 */
import music.view.RunningEndView;
import music.model.LoginService;
public class LoginController {
    public static void startLogin(){
        //RunningStartView로부터 LoginService를 연결하는 클래스.
        //LoginService.Login()메서드가 끝이 나면 자동으로 RunningEndView 클래스의
        //logout 메서드와 연결되어서 프로그램을 종료한다.
        RunningEndView.logout(LoginService.Login());//LoginService 클래스로 이동
        //최종적으로 RunningEndView 클래스로 이동
    }
}
