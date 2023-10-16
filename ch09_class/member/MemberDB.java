package ch09_class.member;

import java.util.ArrayList;

public class MemberDB {

    private ArrayList<Member> memList;  /* Member를 보관하는 리스트 */

    public MemberDB() {
        memList = new ArrayList<>();
        memList.add(new Member("admin", "admin", "관리자"));
        // 가데이터, 더미데이터
        memList.add(new Member("a001", "a001", "테스터"));
        memList.add(new Member("b001", "b001", "테스터2"));
    }

    public ArrayList<Member> getMemList() {
        return memList;
    }
}
