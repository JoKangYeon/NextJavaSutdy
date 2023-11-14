// Date의 getTime(): 1970년 1월 1일 0시 0분 0초 000밀리초를 기준으로 지난 밀리초

const date = new Date()
document.write(`${date} <br>`)
document.write(`${date.toLocaleDateString()} <br>`)
document.write(`${date.getFullYear()}년 ${date.getMonth() + 1} ${date.getDate()}일
${date.getDay()}요일 ${date.getHours()}시 ${date.getMinutes()}분 ${date.getSeconds()}초 <br>`)
document.write(parseInt(date.getTime() / (1000 * 60 * 60 * 24)) + '일 경과')

const date1 = new Date(200,11,23)
document.write(date)
