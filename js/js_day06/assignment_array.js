/* 문제 1. 사람 이름을 계속 입력받아 배열에 저장하고
   그 저장된 이름을 출력하는 프로그램을 작성하시오.
   (단, 입력의 마지막은 null(취소버튼)이나 ""(공백문자)를
   입력했을 때로 한다
*/
let array =[]
while (true){
    let inputName = prompt("이름을 입력해주세요")
    array.push(inputName)
    if(inputName === "" || inputName === null){
        array.pop()
        break;
    }
}
// console.log(array)
array.forEach(value => document.write(value + '<br>'))

/*
 문제 2. 서로 중복되지 않은 정수 5개를 입력받아
 출력하는 프로그램을 작성하시오.
 프롬포트로 입력받기
 예제
 숫자 입력하세요. => 5
 숫자 입력하세요. => 10
 숫자 입력하세요. => 10 => 다시 입력하세요(alert)
*/
let numArray = []
while(true){
    let inputNum = prompt("숫자를 입력해주세요")
    if(numArray.includes(inputNum)){
        alert('다시 입력해주세요')
    }else{
        parseInt(inputNum)
        numArray.push(inputNum)
    }
    if(numArray.length === 5){
        break
    }
}
document.write(numArray.sort(function (a, b){
    return b - a
}))
