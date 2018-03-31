/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.model;

import java.util.ArrayList;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.model.Save;

/**
 *
 * @author choi9
 */
public class SaveService {
    //Save 클래스의 saveResult 메서드를 통해 결과물을 저장하는 메서드이다.
    public static boolean saveResult(String id, String fileAdd, KindsDTO kindsList, ArrayList<MusicDTO> musicList){
        return Save.saveResult(id, fileAdd, kindsList, musicList);//Save 클래스로 이동
        //제대로 저장되었는지 성공여부를 boolean 타입으로 반환한다.
        //다시 SaveController 클래스로 이동
    }
}
