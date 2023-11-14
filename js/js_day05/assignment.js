// prompt로 두명의 사용자로부터 가위, 바위, 보를 입력받아
// 누가 이겼는지 결과를 출력하는 프로그램을 작성하시오
// 출력결과
// 철수: 가위
// 영희: 보
// 결과: 철수 승!!

const rsp = ['가위', '바위', '보']

let player1 = prompt('철수', rsp[(parseInt(Math.random() * 3))])
let player2 = prompt('영희', rsp[(parseInt(Math.random() * 3))] )

if(player1 === player2 ){
    alert(`철수: ${player1} 영희: ${player2} 비겼다 !`)
}else if((player1 === '가위' && player2 === '보')
    || (player1 === '바위' && player2 === '가위')
    || (player1 === '보' && player2 === '바위')){
    alert(`철수: ${player1} 영희: ${player2} 철수승리!`)
}else{
    alert(`철수: ${player1} 영희: ${player2} 영희승리!`)
}
