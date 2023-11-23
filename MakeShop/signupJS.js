let memberId = document.querySelector("#userId")
let memberPw = document.querySelector("#userPw")
let memberEmail = document.querySelector("#userEmail")
let memberName = document.querySelector("#userName")
let memberAds = document.querySelector("#userAds")
let memberDetailAds = document.querySelector("#userDetailAds")
let logEl = document.querySelector("#log")

document.querySelector("#lastBtn").addEventListener("click", () => {
    const newMem = document.forms[0]
    // 일단 Submit 이벤트 막아주기
    newMem.addEventListener("submit", (e) => {
        e.preventDefault()
    })
    // 입력하지 않은 곳은 required 처리

    // 비밀번호 정규표현식 사용
    const regex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$]).{8,16}$/

    if(regex.test(memberPw.value) !== true){
        displayMessage("알파벳, 숫자, 특수문자(!@#$)을 조합해주세요")
        document.forms[0].userPw.focus()
    }
    
    // 알림문 지워주기
    logEl.style.display = "none"

    if(regex.test(memberPw.value)){
        // 고객데이터를 JSON 배열로 저장
        // let member = [memberId.value, memberPw.value, memberEmail.value, memberName.value, memberAds.value + ", " + memberDetailAds]
        // let jsonMember = JSON.stringify(member)
        // localStorage.setItem(memberId.value, jsonMember)
    }
    let member = [memberId.value, memberPw.value, memberEmail.value, memberName.value, memberAds.value + ", " + memberDetailAds.value]

    console.log(member)

})


// 비밀번호 표현식 다를 경우 메시지 출력
function displayMessage(message){
    logEl.style.display = "block"
    logEl.textContent = message
}

document.querySelector("#adsBtn").addEventListener("click", () => {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
            }

            memberAds.value = `${addr} (${data.zonecode})`
            memberDetailAds.focus();
        }
    }).open();
})


