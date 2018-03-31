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
//장르와 성별만으로 구성되는 KindsDTO는 InterfaceDTO를 implements하여 내용들을 구현
//하고 Override하는것으로 마무리된다.
public class KindsDTO implements InterfaceDTO{
    protected String genre;
    protected String gender;
    
    public KindsDTO(){
    }
    public KindsDTO(String genre, String gender){
        this.genre = genre;
        this.gender = gender;
    }
    @Override
    public String getGenre(){
        return genre;
    }
    @Override
    public void setGenre(String genre){
        this.genre = genre;
    }
    @Override
    public String getGender(){
        return gender;
    }
    @Override
    public void setGender(String gender){
        this.gender = gender;
    }
    
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("성향 정보 장르 : ");
        builder.append(genre);
        builder.append(", 성별 : ");
        builder.append(gender);
        return builder.toString();
    }
}
