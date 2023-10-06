package submit06;

public class Submit06 {

    public static void main(String[] args) {

        String[] nameList = {"이정재", "김혜수", "이병헌", "송중기", "유아인", "류준열", "공유", "마동석", "이종석",
                "황정민", "박소담", "이선균", "이성민", "최민식", "이동휘", "권상우", "소지섭", "공효진", "조정석", "허성태", "이하늬"};

        int count = 0; // 이씨 성인 배우 수
        for (int i = 0; i < nameList.length; i++){
            for (int k = 0; k < 1; k++) {
                if ((nameList[i].substring(k, k + 1).equals("이"))){
                    count += 1;
                }
            }
        }
        System.out.println("이씨 성을 가진 배우가 층 " + count + "명 있습니다.");
























    }
}
