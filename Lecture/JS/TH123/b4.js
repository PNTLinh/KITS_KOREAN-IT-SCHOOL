//Viết chương trình cho phép kiểm tra một địa chỉ email có hợp lệ hay không
const readline = require("readline");
let email= String(prompt("Nhập vào một số bất kỳ: "));

const reg = /\S+@\S+/;

if (!reg.test(email)){
    console.log(email + " không hợp lệ");
}else{
    console.log(email + " hợp lệ");
}