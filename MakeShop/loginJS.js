let loginId = document.querySelector("#userId")
let loginPw = document.querySelector("#userPw")

document.querySelector("#loginBtn").addEventListener("click", () => {
    let member = JSON.parse(localStorage.getItem(loginId.value));
    if(member !== null && member.at(1) === loginPw.value){
        let currentMem = JSON.stringify([loginId.value, loginPw.value])
        sessionStorage.setItem("currentMember", currentMem)
        location.href = "loginMain.html"
    }else{
        loginMsg("아이디 혹은 비밀번호를 확인해주세요.")
    }
})

function loginMsg(message){
    document.querySelector("#loginMessage").style.display = "block"
    document.querySelector("#loginMessage").textContent = message
    document.querySelector("#loginMessage").style.marginBottom = "15px"
}

document.querySelector("#openPopup").addEventListener("click", () => {
    window.open("findPw.html", "popup", "width=600, height=200")
})
