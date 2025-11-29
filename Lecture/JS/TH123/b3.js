//Viết chương trình đảo ngược các chữ trên thành 
const str = "Hello World from OpenAI";
function daoNguocChuoi(s) {
    return s.split(' ').reverse().join(' ');
}
console.log(daoNguocChuoi(str));