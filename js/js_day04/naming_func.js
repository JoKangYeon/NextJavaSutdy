// 1. 전통적인 방식
/*function gugudan(){
    for (let i = 1; i <= 9; i++) {
        console.log(`3 * ${i} = ${3 * i}`)
    }
}
gugudan() // => 메소드 호출*/

// 2. 함수 표현식
/*const gugudan = function () {
    for (let i = 1; i <= 9; i++) {
        console.log(`5 * ${i} = ${5 * i}`)
    }
}
gugudan()*/

// 3. 화살표 함수로 함수 정의(람다 표현식)
const gugudan = (dan=2) => {
    for (let i = 1; i <= 9; i++) {
        console.log(`${dan} * ${i} = ${dan * i}`)
    }

}
gugudan()


