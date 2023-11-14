var text = 'outside'

function printScope(){
    console.log(text)
    var text = 'inside'
}
printScope()