/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;

/**
 *
 * @author choi9
 */
//사용자의 성향을 분석하는 클래스다.
public class KindsDAO {
    public static KindsDTO analysis(ArrayList<MusicDTO> list){
        //스캐너를 통해 받은 번호로 성향을 파악하기 위해서 String과 MusicDTO를 선언했다.
        Scanner input = new Scanner(System.in);
        String choice;
        MusicDTO choiced = new MusicDTO();
        //likeList는 사용자가 선택한 음악들을 추출하여 모아두는 리스트이다.
        ArrayList<KindsDTO> likeList = new ArrayList<KindsDTO>();
        //한번에 5개의 곡이 나오게 하기 위해 array를 선언하였다.
        int[] array = new int[5];
        //총 10개의 곡을 선택할 때 까지 반복한다.
        while(likeList.size() < 10){
            System.out.println("다음 곡들 중 마음에 드는 한 곡을 선택해 주세요."
                    + " 10곡을 선택하면 분석이 시작됩니다.");
            //전체 음악 데이터 중 랜덤으로 5개의 음악을 출력한다.
            for(int i = 0; i < 5; i++){
                array[i] = (int)((list.size()) * Math.random());
                System.out.println((i + 1) + ". 아티스트명 : " + list.get(array[i]).getArtist() +
                        ", 제목 : " + list.get(array[i]).getMusicTitle());
            }
            System.out.print("곡을 선택하세요.(1~5, 마음에 드는게 없다면 any key) : ");
            choice = input.nextLine();
            //스캐너를 통해 입력한 값을 choice로 받고 그 값을 비교하여 likeList에 추가
            //할 것인지 아니면 다음 곡 목록을 출력할 것인지 결정한다.
            if(choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4") || choice.equals("5")){
                choiced = list.get(array[Integer.parseInt(choice) - 1]);
                //선택된 곡의 장르와 성별을 KindsDTO 형식으로 바꿔서 likeList에 저장한다.
                likeList.add(new KindsDTO(choiced.getGenre(), choiced.getGender()));
                //선택된 곡은 기존의 전체 음악 데이터에서 삭제한다.(중복 선택이 안되도록)
                list.remove(array[Integer.parseInt(choice) - 1]);
            }else{
                //아무거나 눌렀을 경우 이번 선택을 스킵하고 다시 while문으로 돌아간다.
                System.out.println("SKIP!");
                continue;
            }
        }
        System.out.println("선택을 마치셨습니다. 고생하셨어요! 분석을 시작합니다.");
        //countDupGenre, countDupGender 메서드들을 통해 사용자가 가장 많이 선택한 
        //장르와 성별을 뽑아서 KindsDTO 형식으로 반환한다.
        return new KindsDTO(countDupGenre(likeList), countDupGender(likeList));//아래 메서드들로 이동
        //(메서드 설명을 본 뒤) 따라서 가장 선호하는 장르와 성별을 찾아서 KindsDTO
        //형식으로 반환한다.
        //MusicService로 이동
    }
    
    //사용자가 선택한 곡의 장르들 중 가장 많은 하나의 장르를 계산하여 반환한다.
    public static String countDupGenre(ArrayList<KindsDTO> list){
        //resultList는 장르를 카운트하기 전에 사용자가 선택한 장르들을 중복을 제거하여
        //가지고 있는 리스트이다.
        ArrayList<String> resultList = new ArrayList<String>();
        //count는 resultList와 크기가 같은 배열로서 각각의 index는 resultList에 
        //저장되어 있는 장르의 순서와 같다.
        int[] count;
        //사용자가 선택한 음악들을 하나씩 보면서 그 음악의 장르가 현재 resultList에
        //없으면 resultList에 그 장르를 추가하는 과정이다.
        for(int i = 0; i < list.size(); i++){
            if(!resultList.contains(list.get(i).getGenre())){
                resultList.add(list.get(i).getGenre());
            }
        }
        //resultList가 완성되었으므로 count 배열도 완성시킨다.
        count = new int[resultList.size()];
        //resultList에 저장되어있는 순서(i)대로 장르를 꺼내서 사용자가 선택한 음악
        //리스트의 곡과 장르가 같다면 count[i]를 ++해주는 과정이다.
        for(int i = 0; i < resultList.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getGenre().equals(resultList.get(i))){
                    count[i]++;
                }
            }
        }
        //결국 count[i]의 값은 result에서 i번째 순서로 나오는 장르의 곡을 사용자가
        //몇번 선택했는지에 대한 결과물이다. 따라서 count에서 최고값을 가지는 index가
        //몇번인지 알기 위해 calculateMax 메서드를 사용한다.
        return resultList.get(calculateMax(count));//아래 calculateMax 메서드로 이동
        //결국 사용자가 가장 선호하는 장르를 반환한다.
    }
    
    public static String countDupGender(ArrayList<KindsDTO> list){
        //resultList는 성별을 카운트하기 전에 사용자가 선택한 성별들을 중복을 제거하여
        //가지고 있는 리스트이다.
        ArrayList<String> resultList = new ArrayList<String>();
        //count는 resultList와 크기가 같은 배열로서 각각의 index는 resultList에 
        //저장되어 있는 장르의 순서와 같다.
        int[] count;
        for(int i = 0; i < list.size(); i++){
            if(!resultList.contains(list.get(i).getGender())){
                resultList.add(list.get(i).getGender());
            }
        }
        count = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            for(int j = 0; j < list.size(); j++){
                if(list.get(j).getGender().equals(resultList.get(i))){
                    count[i]++;
                }
            }
        }
        //결국 count[i]의 값은 result에서 i번째 순서로 나오는 성별의 곡을 사용자가
        //몇번 선택했는지에 대한 결과물이다. 따라서 count에서 최고값을 가지는 index가
        //몇번인지 알기 위해 calculateMax 메서드를 사용한다.
        return resultList.get(calculateMax(count));//아래 calculateMax 메서드로 이동
        //결국 사용자가 가장 선호하는 성별을 반환한다.
    }
    
    //정수형 배열이 들어왔을 때 최대값과 그때의 index를 찾아서 index만 반환하는 메서드이다.
    public static int calculateMax(int[] list){
        int max = list[0];
        int num = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] > max){
                max = list[i];
                num = i;
            }
        }
        //여기서 num은 배열의 최대값을 가지는 index이다.
        return num;
    }
}
