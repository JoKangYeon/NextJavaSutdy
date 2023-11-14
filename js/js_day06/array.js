const arr = [10, 20, 30, 40, 13, 88 ]
arr.push(50)
console.log(arr)


let sum = 0
// 1. C언어 방식
for (let i = 0; i < arr.length; i++) {
    sum += arr[i]
}

// 2. 향상된 loop문
for(const  index in arr){
    sum += arr[index]
}

// 3. 자바의 StreamAPI 방식
arr.forEach(function (item) {
    sum += item
})

arr2 = arr.filter((value) => value < 50)
arr3 = arr.filter((value) => value < 50).map(value => value + 100)

console.log(arr2)
console.log(arr3)

let findNumber = arr.find(value => value < 20)
console.log(findNumber)
arr4 = arr.join(', ')
arr5 = arr4.split(', ')
console.log(arr5)