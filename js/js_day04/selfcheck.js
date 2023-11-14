let calCircle = function (a) {
    return a*a*3.14
}

console.log(calCircle(15))

function getArrayMaxNumber(arr){
    // 배열의 최대값이 리턴되도록
    let a = arr[0]
    for (let i = 0; i < arr.length; i++) {
        if(arr[i] > a){
            a = arr[i]
        }
    } return a
}

console.log(getArrayMaxNumber([18, 123,232, 333, 13]))

function checkBMI(a, b) {
    let result = a / (b/100)**2
    if(result >= 26){
        return '비만'
    }else if(24 <= result && 26 > result){
        return '과체중'
    }else if(18.5 <= result && 24 > result){
        return '정상'
    }else if(18.5 >= result){
        return '저체중'
    }
}

console.log(checkBMI(75, 177))