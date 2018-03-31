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
import java.util.ArrayList;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.model.MusicService;
import music.view.RunningEndView;

public class MusicController {
    //데이터 읽기 기능을 가진 메서드이다. MusicService 클래스의 getMusicData 메서드로
    //연결되고 그 결과를 musicList에 저장한 뒤 musicList가 null이 아니라면
    //RunningEndView 클래스를 통해 MusicDTO들의 ArrayList를 반환하고 null이면 null을 반환한다.
    public static ArrayList<MusicDTO> getMusicData (String fileAdd){
        ArrayList<MusicDTO> musicList;
        musicList = MusicService.getMusicData(fileAdd);//MusicService로 이동
        if(!(musicList == null)){
            //MusicService의 주석을 본 후 RunningEndView로 이동
            return RunningEndView.getMusicData(musicList);//제대로 결과물이 왔을 때 RunningEndView에서
            //메세지를 출력하고 list를 반환한다.
        }else{
            return null;//결과물이 null일 경우 메세지 출력 없이 null을 반환한다.
        }
        //다시 RunningView로 이동
    }
    
    //MusicService의 startAnalysis 메서드를 통해 성향을 분석하는 메서드다.
    public static KindsDTO startAnalysis(ArrayList<MusicDTO> musicList){
        //MusicService의 주석을 본 후 RunningEndView로 이동
        return RunningEndView.startAnalysis(MusicService.startAnalysis(musicList));//메세지를 출력하고
        //성향을 반환한다.
        //다시 RunningView로 이동
    }
    
    public static ArrayList<MusicDTO> startCuration(ArrayList<MusicDTO> musicList, KindsDTO kindsList){
        //MusicService의 주석을 본 후 RunningEndView로 이동
        return RunningEndView.startCuration(MusicService.startCuration(musicList, kindsList));//메세지를 출력하고
        //성향을 반환한다.
        //다시 RunningView로 이동
    }
    

}
