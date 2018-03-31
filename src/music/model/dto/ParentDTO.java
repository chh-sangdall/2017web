/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.model.dto;

/**
 *
 * @author choi9
 */
//MusicDTO에 추가적으로 필요한 음악 제목 및 아티스트명에 관한 추상 메서드들이 적혀있는
//추상 클래스이다. KindsDTO에서 구현해놓은 기능을 가져오기 위해 상속을 하고, super
//키워드를 사용하기 위해 생성자 부분을 기술하였다.
public abstract class ParentDTO extends KindsDTO{
    public ParentDTO(){
    }
    public ParentDTO(String genre, String gender){
        this.genre = genre;
        this.gender = gender;
    }
    
    public abstract String getMusicTitle();
    public abstract void setMusicTitle(String musicTitle);
    public abstract String getArtist();
    public abstract void setArtist(String artist);
}
