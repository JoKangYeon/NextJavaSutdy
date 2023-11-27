document.querySelector("#backBtn").addEventListener("click", () => {
    location.href = "loginMain.html"
})

document.querySelector("#changeBtn").addEventListener("click", () => {
    alert("완료되었습니다.")
    location.href = "loginMain.html"
})


let currentKey = JSON.parse(sessionStorage.getItem("currentMember"))[0]
let currentUser = JSON.parse(localStorage.getItem(currentKey))
// console.log(currentKey)
// console.log(currentUser)
document.querySelector("#currentName").value = currentUser.at(3)
document.querySelector("#currentId").textContent = currentUser.at(0)
document.querySelector("#currentEmail").value = currentUser.at(2)
document.querySelector("#currentAddress").textContent = currentUser.at(4)

function changeName(){
    document.querySelector("#currentName").readOnly = false;
}

function changeEmail(){
    document.querySelector("#currentEmail").readOnly = false;
}

function changePw(){
    window.open("changePw.html", "popup", "width=600, height=200")

}
