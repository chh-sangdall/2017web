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
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.view.RunningEndView;

public class Save {
    //실질적으로 저장업무를 하는 메서드다.
    public static boolean saveResult(String id, String fileAdd, KindsDTO kindsList, ArrayList<MusicDTO> musicList){
        //boolean의 초기값은 true이며 예외상황에서만 false로 바꿔준다.
        boolean result = true;
        //시간 정보를 파일 하단에 기재하기 위한 작업이다.
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        try{
            //버퍼드라이터를 통해 fileAdd 위치에 텍스트 파일을 저장한다.
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileAdd));
            bw.write(id + "님의 음악 성향");
            bw.newLine();
            bw.write(kindsList.toString());
            bw.newLine();
            bw.write(id + "님의 추천곡 리스트");
            bw.newLine();
            for(int i = 0; i < musicList.size(); i++){
                bw.write(musicList.get(i).toString());
                bw.newLine();
            }
            bw.write(dayTime.format(new Date(time)));
            bw.close();
            //음악 성향과 추천곡, 현재시간을 저장하고 버퍼드라이터를 닫는다.
        }catch(IOException e){
            e.printStackTrace();
            RunningEndView.showError("저장 에러 발생");
            result = false;
        }
        //정상적으로 실행시 true를 반환한다.
        return result;//다시 SaveService로 이동
    }
}