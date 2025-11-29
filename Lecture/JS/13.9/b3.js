//-	3, Viết chương trình hiển thị thời gian của máy tính sử dụng đối tượng Date() của javascript và hiển thị ra trình duyệt
const bd = new Date();
let gio = bd.getHours();
let phut = bd.getMinutes();
let giay = bd.getSeconds();
//format date
gio = (gio < 10) ? "0" + gio : gio;
phut = (phut < 10) ? "0" + phut : phut;
giay = (giay < 10) ? "0" + giay : giay;
console.log("Bây giờ là: " + gio + ":" + phut + ":" + giay);