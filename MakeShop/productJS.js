let currentProduct = JSON.parse(sessionStorage.getItem("clickedProd"))
document.querySelector("#prodImg").src = currentProduct[0]
document.querySelector("#productName").textContent = currentProduct[1]
document.querySelector("#productPrice").textContent = currentProduct[2]




function addList() {

    const myList = JSON.parse(localStorage.getItem("shoppingList")) || []

    let imgUrl = currentProduct[0]
    let prodName = currentProduct[1]
    let prodPrice = currentProduct[2]

    myList.push( {"imgUrl": imgUrl, "prodName": prodName, "prodPrice": prodPrice} )

    localStorage.setItem("shoppingList", JSON.stringify(myList))


    alert("쇼핑백에 상품이 담겼습니다.")
    // location.href = "shoppingBag.html"
}

function setCart() {
    const main = document.getElementById("midInBox")
    let userList = JSON.parse(localStorage.getItem("shoppingList"))
    for (let i = 0; i < userList.length; i++) {


        let divBox = document.createElement("div")
        divBox.style.display = "flex"
        divBox.style.flexDirection = "column"
        divBox.style.width = "30%"
        divBox.style.padding = "3px"
        divBox.style.height = "65%"
        divBox.style.marginRight = "50px"
        let firstBox = document.createElement("div")
        firstBox.style.width = "100%"
        firstBox.style.height = "80%"
        let imgBox = document.createElement("img")
        imgBox.style.width = "100%"
        imgBox.style.height = "100%"

        imgBox.src = userList[i].imgUrl

        firstBox.append(imgBox)

        let secondBox = document.createElement("div")
        secondBox.style.width = "100%"
        secondBox.style.height = "10%"
        secondBox.style.textAlign = "center"
        secondBox.textContent = userList[i].prodName + " / " + userList[i].prodPrice
        let thirdBox = document.createElement("div")
        thirdBox.style.width = "100%"
        thirdBox.style.height = "10%"
        thirdBox.style.textAlign = "center"
        let inputBox = document.createElement("input")
        let labelBox = document.createElement("label")
        thirdBox.append(inputBox)
        thirdBox.append(labelBox)
        inputBox.type = "checkbox"
        inputBox.class = "checkYN"
        inputBox.checked = true
        inputBox.style.width = "15px"
        inputBox.style.height = "15px"
        inputBox.id = userList[i].prodName
        inputBox.name = userList[i].prodName
        labelBox.textContent = "구매목록 넣기"
        labelBox.style.fontSize = "20px"
        labelBox.htmlFor = userList[i].prodName


        divBox.append(firstBox, secondBox, thirdBox)

        main.append(divBox)
    }



}
