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
import music.view.RunningView;
public class LoginService {
    public static int Login() {
        //LoginService 클래스는 Login 클래스를 통해 id가 제대로 들어왔는지 확인하고
        //RunningEndView 클래스에게 int값을 반환하는 목적을 가진다.
        String id;
        int out = 0;
        //로그인 클래스로부터 id를 받아와서 저장한다.
        id = Login.getId();//Login 클래스로 이동
        System.out.println(id + "님, 환영합니다.");
        //프로그램의 중추인 RunningView 클래스의 startView 메서드에 id를 보낸다.
        //이후 본격적으로 프로그램이 시작된다.
        RunningView.StartView(id);//RunningView 클래스로 이동
        return out;//다시 LoginController 클래스로 이동
    }
}
