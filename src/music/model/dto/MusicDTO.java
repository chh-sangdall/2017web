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
//ParentDTO를 상속받는 MusicDTO다. 음악 데이터에 대한 정보가 담겨야 하므로 음악 제목,
//아티스트 명, 장르와 성별까지 모든 정보를 받을 수 있게 구현되어 있다.
public class MusicDTO extends ParentDTO{
    private String musicTitle;
    private String artist;
    
    public MusicDTO(){
        super();
    }
    public MusicDTO(String musicTitle, String artist, String genre, 
            String gender){
        super(genre, gender);
        this.musicTitle = musicTitle;
        this.artist = artist;
    }
    @Override
    public String getMusicTitle(){
        return musicTitle;
    }
    @Override
    public void setMusicTitle(String musicTitle){
        this.musicTitle = musicTitle;
    }
    @Override
    public String getArtist(){
        return artist;
    }
    @Override
    public void setArtist(String artist){
        this.artist = artist;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("###음악 정보### 제목 : ");
        builder.append(musicTitle);
        builder.append(", 아티스트 : ");
        builder.append(artist);
        builder.append(", 장르 : ");
        builder.append(genre);
        builder.append(", 성별 : ");
        builder.append(gender);
        return builder.toString();
    }
}
