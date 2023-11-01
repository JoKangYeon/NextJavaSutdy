package cgv;
import java.util.regex.Pattern;

public class cgvMethod {
    /* cgv 관련 메소드 */

    // ID 조건 확인 메소드
    public static boolean checkId(String a){
        String regex = "^[a-zA-Z0-9]{8,12}$";
        return a.matches(regex);
    }

    // 비밀번호 조건 확인 메소드
    public static boolean checkPw(String a){
        String regex = "^(?=.*[!@#])[A-Za-z\\d!@#]{8,16}$";
        return a.matches(regex);
    }

    // 전화번호 조건 확인 메소드
    public static boolean checkPhone(String a){
//        String regex = "^(\\d{10}|\\d{11}|\\d{3}-\\d{3}-\\d{4}|\\d{3}-\\d{4}-\\d{4})$";
//        String regex = 	"^\\\\d{3}-\\\\d{3,4}-\\\\d{4}$";
        String regex = 	"^010[0-9]{7,8}$";
        return a.matches(regex);
    }

















}
