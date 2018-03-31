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
//가장 상위의 인터페이스. KindsDTO, MusicDTO 모두 가지고있는 장르와 성별에 대한
//추상 메서드들이 적혀있다.
public interface InterfaceDTO {
    public String getGenre();
    public void setGenre(String genre);
    public String getGender();
    public void setGender(String gender);
}
