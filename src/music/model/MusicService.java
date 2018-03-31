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
import java.util.ArrayList;
import music.model.MusicDAO;
import music.model.KindsDAO;
import music.model.dto.MusicDTO;
import music.model.dto.KindsDTO;

public class MusicService {
    //음악 데이터를 읽어오는 메서드이다. MusicDAO로 연결된다.
    public static ArrayList<MusicDTO> getMusicData(String fileAdd){
        return MusicDAO.getMusicData(fileAdd);//MusicDAO 클래스로 이동
        //MusicDAO 클래스의 주석을 본 후에 MusicController 클래스로 이동
    }
    
    //분석을 시작하는 메서드이다. KindsDAO로 연결된다.
    public static KindsDTO startAnalysis(ArrayList<MusicDTO> musicList){
        return KindsDAO.analysis(musicList);//KindsDAO 클래스로 이동
        //KindsDAO 클래스의 주석을 본 후에 MusicController 클래스로 이동
    }
    
    //추천곡을 뽑아오는 메서드이다. MusicDAO로 연결된다.
    public static ArrayList<MusicDTO> startCuration(ArrayList<MusicDTO> musicList, KindsDTO kindsList){
        return MusicDAO.curation(musicList, kindsList);//MusicDAO 클래스로 이동
        //MusicDAO 클래스의 주석을 본 후에 MusicController 클래스로 이동
    }
}
