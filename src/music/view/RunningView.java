/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.view;

/**
 *
 * @author choi9
 */
import java.util.Scanner;
import java.util.ArrayList;
import music.service.MusicController;
import music.model.dto.KindsDTO;
import music.model.dto.MusicDTO;
import music.service.SaveController;

public class RunningView {
    //스캐너 입력을 통해 메뉴 선택과 주소 입력 등을 관리한다.
    static String option;
    private static Scanner input;
    
    //아이디를 받아와서 프로그램을 시작
    public static void StartView(String id){
        input = new Scanner(System.in);
        //i는 메뉴 진행에 관한 변수로서 1번 메뉴 부분에서 설명하겠다.
        int i = 0;
        //str이라는 사용자 지정 주소를 저장하기 위한 String을 선언
        String str;
        //default 데이터 주소 및 저장 파일 주소를 지정
        String fileAdd1 = "./musicdb.csv";
        String fileAdd2 = "./result.txt";
        //각각 데이터를 읽고, 성향을 분석하고, 추천곡을 받을 데이터셋
        ArrayList<MusicDTO> musicList = new ArrayList<MusicDTO>();
        KindsDTO kindsResult = new KindsDTO();
        ArrayList<MusicDTO> curationResult = new ArrayList<MusicDTO>();
        
        while(true){
            System.out.println("-----------------------------------");
            System.out.println("--------서비스를 선택하세요---------");
            //서비스를 시작. 총 세개의 메뉴가 있으며 1번을 진행하지 않으면 2번 진입이
            //불가능하다. 저장할 결과물이 없기 때문.
            System.out.println("1. 성향 분석 2. 결과물 저장 3. 로그아웃");
            System.out.println("메뉴를 선택하세요. : ");
            option = input.nextLine();
            //option 변수에 스캐너를 통해 입력받은 값을 if문을 통해 비교하여 메뉴로 진입
            if(option.equals("1")) {
                //i가 0인지 2번 메뉴 진입시 확인하여서 0이면 1번 메뉴를 실행하기 전 이므로
                //데이터가 없다고 판단하여 다시 메뉴로 돌려보낸다. 하단에서 ++를 통해
                //프로그램을 진행했다는 증거를 남긴다.
                i = 0;
                System.out.println("프로그램을 시작합니다.");
                System.out.print("데이터가 저장되어 있는 절대경로를 적어주세요." + 
                        "(그대로 Enter를 누르면 default 파일 선택) : ");
                //주소를 입력하면 str에 사용자 지정 위치가 입력된다.
                str = input.nextLine();
                //str에 값이 들어왔다면 사용자가 주소를 입력한 것으로 간주하여서
                //str을 통해 데이터 읽기를 진행한다.
                if(!str.isEmpty()){
                    //MusicController 클래스의 getMusicData의 argument로 주소값을
                    //입력하고 그 결과물을 musicList에 저장한다. 이때 musicList는
                    //MusicDTO들의 ArrayList이다.
                    musicList = MusicController.getMusicData(str);
                //그러나 str에 아무 값도 입력되지 않았다면 메세지를 띄우고
                //기존 위치인 fileAdd1을 통해 프로그램을 진행한다.
                }else{
                    System.out.println("default 파일을 불러옵니다.");
                    musicList = MusicController.getMusicData(fileAdd1);//MusicController 클래스로 이동
                }
                //받아온 음악 리스트가 null이라면 다시 메뉴로 돌아간다.
                if(musicList == null){
                    continue;
                }

                //성향 분석을 시작한다.
                System.out.println("성향 분석을 시작합니다.");
                //musicController 클래스의 startAnalysis 메서드를 통해 얻은 성향을 저장한다.
                kindsResult = MusicController.startAnalysis(musicList);//musicController 클래스로 이동
                System.out.println(id + "님이 가장 선호하는 음악의 특징은 다음과 같습니다.");
                //선호하는 장르와 성별을 출력
                System.out.println(kindsResult.toString());
                
                //추천 서비스를 시작한다.
                //MusicController 클래스의 startCuration 메서드를 통해 얻은 추천곡 리스트를 저장한다.
                curationResult = MusicController.startCuration(musicList, kindsResult);//musicController 클래스로 이동
                System.out.println(id + "님의 추천곡은 다음과 같습니다.");
                //RunningEndView 클래스로 이동
                RunningEndView.musicTableView(curationResult);
                //i를 ++함으로서 2번 메뉴 실행시 1번 메뉴가 실행이 되었다는 것을 알려줌
                i++;
                //메뉴로 돌아간다.
                continue;
            }else if(option.equals("2")) {
                //결과물이 없으면 저장할 수 없으므로 i를 통해 1번 메뉴 실행여부를 확인
                if(i == 0){
                    System.out.println("1번 메뉴를 먼저 실행하셔야 합니다.");
                    continue;
                }
                System.out.println("결과물을 프로젝트 폴더에 저장합니다.(파일명 : result)");

                //SaveController 클래스의 saveResult 메서드를 통해 결과물들을 저장한다.
                SaveController.saveResult(id, fileAdd2, kindsResult, curationResult);//SaveController 클래스로 이동
                //저장을 마치고 다시 메뉴로 돌아간다.
                continue;
            }else if(option.equals("3")) {
                System.out.println(id + "님, 프로그램을 종료합니다.");
                //while문을 탈출한다.
                break;//다시 LoginService 클래스로 이동
            }else{
                //잘못된 메뉴 선택에 대한 예외처리
                System.out.println("잘못된 선택입니다.");
                continue;
            }
        }
    }
}
