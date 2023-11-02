package cgv;

import java.util.Scanner;

public class CgvMain {

    public static void main(String[] args) {

        /* 기능 */
        // 010-1234-5678 형식 실패



        CgvFood foodMenu = CgvFood.getInstance();
        CgvDrink drinkMenu = CgvDrink.getInstance();
        MemberDB memberDB = MemberDB.getInstance();
        Scanner scan = new Scanner(System.in);

   /*     foodMenu.showFoodList();
        drinkMenu.showDrinkList();*/

        // 회원가입 ~ 로그인까지
        outer:
        while(true){
            System.out.println("안녕하세요 CGV입니다.");
            System.out.println("무엇을 도와드릴까요?");
            System.out.println("1. 회원가입 | 2. 로그인 | 3. ID찾기 | 4. 비밀번호찾기 | 5. 종료");
            System.out.print(">>> ");
            int command = Integer.parseInt(scan.nextLine());
            if(command == 1){
                while(true){
                    System.out.println("이름을 입력해주세요.");
                    System.out.print(">>> ");
                    String a = scan.nextLine();
                    System.out.println("사용하실 ID를 입력해주세요.");
                    System.out.println("ID는 8자이상 12자이하, 숫자, 알파벳만 사용가능");
                    System.out.print(">>> ");
                    String b = scan.nextLine();
                    if(cgvMethod.checkId(b) && memberDB.dpCheck(b)){    // 형식&&중복 모두 통과
                    }else if(cgvMethod.checkId(b) && !memberDB.dpCheck(b)){ // 형식은 맞는데 ID가 중복된 경우
                        System.out.println("중복된 ID입니다.");
                        continue;
                    }else{   // ID는 중복안되는데 형식이 틀린경우
                        System.out.println("잘못된 형식입니다.");
                        continue;
                    }
                    System.out.println("사용하실 비밀번호를 입력해주세요.");
                    System.out.println("비밀번호는 8자이상 16이하, 숫자, 알파벳, 특수문자 !,@,# 중 최소 1개를 포함해야함.");
                    System.out.print(">>> ");
                    String c = scan.nextLine();
                    if(cgvMethod.checkPw(c)){   // 비밀번호 형식 통과
                    }else{
                        System.out.println("잘못입력했습니다.");
                        continue;
                    }
                    System.out.println("주소를 입력해주세요.");
                    System.out.print(">>> ");
                    String d = scan.nextLine();
                    System.out.println("휴대폰 번호 10자리 혹은 11자리를 입력해주세요.");
                    System.out.println("반드시 010으로시작 -사용x 형식으로 작성");
                    System.out.print(">>> ");
                    String e = scan.nextLine();
                    if(cgvMethod.checkPhone(e)){    // 번호 형식 통과한 경우
                        System.out.println("축하합니다! 가입에 성공하셨습니다!");
                        memberDB.addMember(new Member(a,b,c,d,e));
//                        memberDB.showMember();  // 잘 들어갔는지 확인
                        break;
                    }else{  // 번호 형식 틀린 경우
                        System.out.println("전화번호 형식을 확인해주세요.");
                    }
                }
            }else if(command == 2){
                while(true){
                    System.out.println("ID를 입력해주세요.");
                    System.out.print(">>> ");
                    String id = scan.nextLine();
                    System.out.println("비밀번호를 입력해주세요.");
                    System.out.print(">>> ");
                    String pw = scan.nextLine();
                    if(memberDB.login(id, pw)){
                        System.out.println("로그인에 성공하였습니다.");
                        break outer;
                    }else if(!memberDB.dpCheck(id)){    // 비밀번호만 틀린 경우
                        System.out.println("비밀번호를 확인해주세요");
                    }else{  // 둘 중 뭔가 틀린 경우
                        System.out.println("ID 또는 비밀번호가 잘못되었습니다.");
                    }

                }
            }else if(command == 3){
                System.out.println("가입 당시 휴대폰번호를 입력해주세요");
                System.out.print(">>> ");
                String phone = scan.nextLine();
                memberDB.searchId(phone);
            }else if(command == 4){
                System.out.println("가입하신 ID를 입력해주세요");
                System.out.print(">>> ");
                String inputId = scan.nextLine();
                memberDB.searchPw(inputId);
            }else if(command == 5){
                break outer;
            }

        }























    }
}
