function convertDate(milliSecond) {
    const days = ['일', '월', '화', '수', '목', '금', '토']
    const data = new Date(milliSecond);

    let year = data.getFullYear()
    let month = data.getMonth() + 1
    let date = data.getDate()
    let day = days[data.getDay()]

    return `${year}.${month}.${date}. (${day})`;
}

// =======================================================================

/*const date = new Date("2020-1-1");
const today = new Date()
let diffDate = today.getTime() - date.getTime()
document.write(parseInt(diffDate / (1000 * 60 * 60 * 24)))*/

// =======================================================================

/*const todayDate = new Date();
let future = 1000 * 60 * 60 * 24 * 500
let result = (todayDate.getTime() + future)
let resultDate = new Date(result)
document.write(`${resultDate.toLocaleDateString()} <br>`)


document.write(convertDate(result))*/

// =======================================================================

const date = new Date("2023-12-25");
let a = 1000 * 60 * 60 * 24 * 99   // 100일의 밀리초 -> 사귀기시작한날포함해야해서 -1
let result = (date.getTime() - a)  // 크리스마스 100일전 밀리초
document.write(`${convertDate(result)} <br>`)
const date2024 = new Date("2024-12-25");
let b = 1000 * 60 * 60 * 24 * 299   // 300일의 밀리초
let result2024 = (date2024.getTime() - b)   // 크리스마스 300일전 밀리초
document.write(`${convertDate(result2024)} <br>`)
