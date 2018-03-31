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
import java.util.ArrayList;
import music.model.dto.MusicDTO;
import music.model.dto.KindsDTO;

public class RunningEndView {
    //음악 데이터가 담긴 리스트의 내용을 보여주는 메서드이다. 본 프로젝트에서는
    //추천곡 리스트를 보여주는 데에 쓰인다.
    public static void musicTableView(ArrayList<MusicDTO> dto){
        System.out.println("#################################################");
        for(int i = 0; i < dto.size(); i++){
            System.out.println(dto.get(i).toString());
        }
        System.out.println("#################################################");
    }
    
    //음악 데이터를 제대로 불러왔는지 확인하여 메세지를 출력하고 list를 반환하는 메서드다.
    public static ArrayList<MusicDTO> getMusicData(ArrayList<MusicDTO> list){	
            System.out.println("데이터 읽기에 성공했습니다.");
            return list;//다시 MusicController 클래스로 이동
    }
    
    //분석을 마친 후 메세지를 출력하고 사용자의 성향을 반환하는 메서드다.
    public static KindsDTO startAnalysis(KindsDTO dto){
        System.out.println("분석 서비스를 완료하였습니다.");
        return dto;//다시 MusicController 클래스로 이동
    }
    
    //큐레이션을 시작하고 추천곡 리스트를 반환하는 메서드다.
    public static ArrayList<MusicDTO> startCuration(ArrayList<MusicDTO> dto){
        System.out.println("추천 서비스를 완료하였습니다.");
        return dto;//다시 MusicController 클래스로 이동
    }
    
    //저장을 끝내고 그 여부에 따라 메세지를 출력하는 메서드다.
    public static void saveResult(boolean result){
        if(result){
            System.out.println("저장을 완료하였습니다.");
        }
        //void 타입이기 때문에 출력을 마치고 저장업무가 여기서 종료된다.
    }
    
    //로그아웃 처리 메세지를 출력하는 메서드다.
    public static void logout(int out) {
        System.out.println("로그 아웃 처리 됐습니다.");
        //여기서 프로그램이 끝난다.
    }
    
    //에러가 났을때 개발자가 입력한 메세지를 보여주는 메서드다.
    public static void showError(String message){
        System.out.println(message);		
    }
}
