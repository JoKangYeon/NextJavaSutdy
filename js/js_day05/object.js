const person = {
    name : {
        firstName:"Gildong",
            lastName:"Hong",
    },
    likes:["apple", "samsung"],
        printHello: function(){
        return "Hello";
    }
}

console.log(person["name"]['firstName'])
console.log(person["likes"][1])
console.log(person.likes[1])
console.log(person.printHello())