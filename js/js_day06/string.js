const email = 'test!@naver.com'

if(email.includes("@")){
    console.log('올바른 이메일 형식입니다.')
} else if(!email.indexOf('@')){
    console.log('올바른 이메일 형식이 아닙니다')
}

console.log(email.split('!'))
