//Viết chương trình nhận vào một số bất kỳ, kiểm tra xem số đó có phải là số nguyên tố hay không, có phải là số hoàn hảo hay không
const readline = require("readline");

function soNT(n){
    if (n<2) return false;
    for (let i=2; i<=Math.sqrt(n); i++){
        if (n%i===0) return false;
    }
    return true;
}
let num = Number(prompt("Nhập vào một số bất kỳ: "));
if (soNT(num)){
    console.log(num + " là số nguyên tố");
} else {
    console.log(num + " không phải là số nguyên tố");
}
function soHT(n){
    if (n<1) return false;
    let sum = 0;
    for (let i=1; i<=n/2; i++){
        if (n%i===0) sum += i;
    }
    if (sum === n) return true;
    return false;
}
if (soHT(num)){
    console.log(num + " là số hoàn hảo");
} else {
    console.log(num + " không phải là số hoàn hảo");
}