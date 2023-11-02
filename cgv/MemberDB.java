package cgv;

import java.util.ArrayList;

public class MemberDB {
    private ArrayList<Member> memberDB = new ArrayList<>();      /* 회원 목록 */

    private MemberDB() {
        memberDB.add(new Member("조강연", "testtest1", "qwe123!@", "대전 둔산", "01012345678"));
        memberDB.add(new Member("조강연2", "testtest2", "qwe123!#", "대전 유천", "0106666666"));
    }
    private static MemberDB instance = new MemberDB();

    public static MemberDB getInstance() {
        return instance;
    }

    public ArrayList<Member> getMemberDB() {
        return memberDB;
    }

    // ID 중복확인 메소드
    public boolean dpCheck(String a){
        boolean check = false;
        for(int i = 0; i < memberDB.size(); i++){
            if(memberDB.get(i).getId().equals(a)){
                break;
            }else{
                check = true;
                break;
            }
        }
        return check;
    }

    // 로그인 검증 메소드
    public boolean login(String a, String b){
        boolean check = true;
        for(int i = 0; i < memberDB.size(); i++){
            if(memberDB.get(i).getId().equals(a) && (memberDB.get(i).getPw().equals(b))){
                break;
            }else{
                check = false;
                break;
            }
        }
        return check;
    }

    // 아이디 찾기 메소드
    public void searchId(String a){
        int check = 0;
        for (Member member : memberDB) {
            if (member.getPhone().equals(a)) {
                System.out.println("회원님의 ID는: " + member.getId() + "입니다.");
                check++;
                break;
            }
        }
        if(check == 0){
            System.out.println("미가입 고객입니다.");
        }
    }

    // 비밀번호 찾기 메소드
    public void searchPw(String a){
        int check = 0;
        for(int i = 0; i < memberDB.size(); i++){
            if(memberDB.get(i).getId().equals(a)){
                System.out.println("회원님의 비밀번호는: " + memberDB.get(i).getPw() + "입니다.");
                check++;
                break;
            }
        }if(check == 0){
            System.out.println("아이디를 확인해주세요.");
        }
    }

    // 회원가입 시 멤버추가 메소드
    public void addMember(Member member){
        memberDB.add(member);
    }

    // 회원목록 보기 메소드
    public void showMember(){
        for(int i = 0; i < memberDB.size(); i++){
            System.out.println(memberDB.get(i));
        }
    }
}
