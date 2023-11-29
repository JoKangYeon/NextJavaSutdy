// let selectedList = JSON.parse(localStorage.getItem("shoppingList"))
//
//
//
//
//
//
//
//
//
// function getTotal(){
//     // 선택된 상품들 토탈 가격
//     let totalPrice = 0;
//     for (let i = 0; i < selectedList.length; i++) {
//         if(document.querySelector(`#${selectedList[i].prodName}1`).value === true){
//             // 숫자이외에 다 제거해주기
//             let price = parseInt(selectedList[i].prodPrice.replace(/[^0-9]/g, ""))
//             console.log(price)
//             totalPrice += price;
//         }
//     }
//     document.querySelector(".priceBox").textContent = 'Total Price: ' + totalPrice;
// }
