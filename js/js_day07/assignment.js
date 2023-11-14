// 인공지능컴퓨터와 가위바위보
// 사용자는 입력

/*const rsp = ['가위', '바위', '보']

let player = prompt('가위 / 바위 / 보 중 1개를 입력해주세요')

let ai = rsp[(parseInt(Math.random() * 3))]

if(player === ai ){
    alert(`User: ${player} ai: ${ai} // 비겼다 !`)
}else if((player === '가위' && ai === '보')
    || (player === '바위' && ai === '가위')
    || (player === '보' && ai === '바위')){
    alert(`User: ${player} ai: ${ai} // 유저승리!`)
}else{
    alert(`User: ${player} ai: ${ai}  //  컴퓨터승리!`)
}*/


//==============================================================================================

// 2.로또번호 6개 중복x

// let lottoNum = []
// for (let i = 1; i <= 45; i++) {
//     lottoNum.push(i)
// }
// document.write(`${lottoNum} <br>`)

/*let lottoList = []
for (let i = 0; i < 6; i++) {
    let a = parseInt(Math.random() * 45)
    let lotto = lottoNum[a]
    if(lotto > lottoNum.length){
        i--;
    }else{
        lottoList.push(lotto)
        lottoNum.splice(a, 1)
    }
}
document.write(lottoList.sort(function (a, b){
    return a - b
}))*/

// for (let i = 0; i < 6; i++) {
//     let a = parseInt(Math.random() * 45)
//     for (let j = 0; j < i; j++) {
//         if(lottoNum[j] !== a) {
//             let temp = lottoNum[a - 1]
//             lottoNum[a - 1] = lottoNum[i]
//             lottoNum[i] = temp
//         }
//     }
// }
// document.write(lottoNum)


// for(let i = 0; i < lottoNum.length; i++){
//     let randNum = parseInt(Math.random() * 45)
//     let temp = lottoNum[i]
//     lottoNum[i] = lottoNum[randNum]
//     lottoNum[randNum] = temp
// }
//
// const lottoNumber = []
// for (let i = 0; i < 6; i++) {
//     lottoNumber[i] = lottoNum[i]
//
// }
// document.write(lottoNumber)


//==============================================================================================

/*
let lottoList = []
for (let i = 0; i < 6; i++) {
    lotto = parseInt(Math.random() * 45 + 1)
    for (let j = 0; j < i+1; j++) {
        if(lottoList[j] == lotto){
            i--
        }else{
            lottoList.push(lotto)
            break;
        }

    }
}
document.write(lottoList.sort(function (a, b){
    return a - b
}))*/
