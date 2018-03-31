/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.service;

import java.util.ArrayList;
import music.model.MusicService;
import music.model.SaveService;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.view.RunningEndView;

/**
 *
 * @author choi9
 */
public class SaveController {
        //SaveService 클래스의 saveResult 메서드를 통해 결과물을 저장하고 성공여부를
        //RunningEndView의 saveResult 메서드를 통해 출력하는 메서드이다.
        public static void saveResult(String id, String fileAdd, KindsDTO kindsList, ArrayList<MusicDTO> musicList){
        RunningEndView.saveResult(SaveService.saveResult(id, fileAdd, kindsList, musicList));//SaveService 클래스로 이동
        //RunningEndView 클래스로 이동
    }
}
