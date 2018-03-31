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
import java.util.Scanner;
import java.io.*;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.view.RunningEndView;
//음악에 관련된 업무를 실질적으로 처리하는 model이다.
public class MusicDAO {
    //음악 데이터를 읽어오는 메서드
    public static ArrayList<MusicDTO> getMusicData (String fileAdd){
        //BufferedReader와 스캐너를 사용하여 최종적으로 list를 반환하는 메서드
        BufferedReader br = null;
        Scanner input = new Scanner(System.in);
        ArrayList<MusicDTO> list = new ArrayList<MusicDTO>();
        String line;
        try {
            //버퍼드 리더 내에 파일 리더를 넣어서 파일을 읽어온다.
            br = new BufferedReader((new FileReader(fileAdd)));
            String[] data = null;
            while ((line = br.readLine()) != null) {
                //UTF-8, csv형식의 파일이기 때문에 쉼표를 통해 스플릿하여 data 어레이에 저장한다.
                data = line.split(",");
                //저장된 배열의 데이터들을 MusicDTO 형식에 집어넣어서 list에 추가한다.
                list.add(new MusicDTO(data[0], data[1], data[2], data[3]));
            }
            //파일에 데이터가 있을 경우, 리스트의 첫번째 음악을 보여주고 해당 데이터가 맞는지 다시한번 확인한다.
            //그 후 사용자의 입력에 따라 메뉴로 돌아갈지 혹은 그대로 진행할지 결정된다.
            if(data != null){
                System.out.println("해당 파일이 음악 파일이 맞는지 확인하는 절차입니다.");
                System.out.println(list.get(0).toString());
                System.out.println("해당 파일이 맞다면 아무것도 입력하지 마시고 엔터를 눌러주세요.");
                if(!input.nextLine().isEmpty()){
                    System.out.println("메뉴로 돌아갑니다.");
                    //해당 파일이 아니라면 list를 null처리한다.
                    list = null;
                }
            }else{
                //파일을 읽는데 성공했지만, 빈 파일이라면 메세지를 출력하고 null처리한다.
                System.out.println("파일 내부에 데이터가 없습니다.");
                list = null;
            }
        //파일 읽는 것에 대한 예외처리를 한 후에, list를 null처리한다.
        }catch(FileNotFoundException e){
            RunningEndView.showError("파일이 존재하지 않습니다.");
            list = null;
        }catch(IOException e){
            RunningEndView.showError("입력 오류");
            list = null;
        }catch(Exception e){
        }finally{
            //최종적으로 finally 구문에서 버퍼드 리더를 닫는다.
            if(br != null){
                try{
                    br.close();
                }catch (IOException e){
                    RunningEndView.showError("BufferedReader 오류");
                }
            }
        }
        //최종적으로 정상적으로 실행이 되었다면 음악 데이터를, 그렇지 않다면 null을 반환한다.
        return list;//다시 MusicService 클래스로 이동
    }
    
    //추천곡 리스트를 반환하는 메서드이다.
    public static ArrayList<MusicDTO> curation(ArrayList<MusicDTO> musicList, 
            KindsDTO kindsList){
        //resultList를 만들어서 filter 메서드를 통해 사용자 성향의 장르, 성별로
        //음악 데이터에서 추천곡을 선별한 후 반환한다.
        ArrayList<MusicDTO> resultList = new ArrayList<MusicDTO>();
        resultList = filter(musicList, kindsList);//아래의 필터 메서드로 이동
        //최종적으로 추천곡 리스트를 반환
        return resultList;//다시 MusicService 클래스로 이동
    }
    
    //첫번째로 장르를 이용하여 필터링하는 메서드이다.
    public static ArrayList<MusicDTO> filterByGenre(String genre, ArrayList<MusicDTO> musicList){
        ArrayList<MusicDTO> filterByGenreList = new ArrayList<MusicDTO>();
        //전체 음악 리스트에서 사용자 성향의 장르를 가진 것들을 새로운 리스트에 추가하고 반환한다.
        for(int i = 0; i < musicList.size(); i++){
            if(musicList.get(i).getGenre().equals(genre)){
                filterByGenreList.add(musicList.get(i));
            }
        }
        return filterByGenreList;
    }
    
    //두번째로 성별을 이용하여 필터링하는 메서드이다.
    public static ArrayList<MusicDTO> filterByGender(String gender, ArrayList<MusicDTO> filterByGenreList){
        //한번 필터링한 리스트를 가져와서 사용자 성향의 성별인 음악을 제거하고 다시 반환한다.
        ArrayList<MusicDTO> filterByGenderList = new ArrayList<MusicDTO>();
        for(int i = 0; i < filterByGenreList.size(); i++){
            if(filterByGenreList.get(i).getGender().equals(gender)){
                filterByGenderList.add(filterByGenreList.get(i));
            }
        }
        return filterByGenderList;
    }
    
    //사용자의 성향과 전체 음악 데이터를 받아서 추천곡의 ArrayList를 반환하는 메서드이다.
    public static ArrayList<MusicDTO> filter(ArrayList<MusicDTO> musicList, 
            KindsDTO kindsList){
        //두번 필터링을 해서 최종 리스트를 반환해야 하므로 두개의 리스트를 선언한다.
        ArrayList<MusicDTO> resultList;
        ArrayList<MusicDTO> filterByGenreList; 
        //먼저 filterByGenre 메서드를 통해 사용자 성향의 장르인 음악을 뽑아온다.
        //장르부터 거르는 이유는 F, M, MIX로 구성된 성별에 비해 가지수가 더 많기 때문이다.
        filterByGenreList = filterByGenre(kindsList.getGenre(), musicList);//위의 filterByGenre 메서드로 이동
        //그 후 뽑아온 리스트에서 사용자 성향의 성별인 음악을 선별하여 저장한다.
        resultList = filterByGender(kindsList.getGender(), filterByGenreList);//위의 filterByGender 메서드로 이동
        //저장된 리스트를 반환한다.
        return resultList;
    }
}
