function getArrayMaxNumber(arr){
    // 배열의 최대값이 리턴되도록
    let a = arr[0]
    for (let i = 0; i < arr.length; i++) {
        if(arr[i] > a){
            a = arr[i]
        }
    } return a

}

const max = getArrayMaxNumber([10,50,30])
console.log(max)

function getArrayMinNumber(arr){
    // 배열의 최솟값이 리턴되도록
    let a = arr[0]
    for (let i = 1; i < arr.length; i++) {
        if(arr[i] < a){
            a = arr[i]
        }
    } return a
}
const min = getArrayMinNumber([10,50,30])
console.log(min)