//-	1, Viết chương trình định nghĩa một mảng số nguyên bất kì,  kiểm tra xem trong mảng có bao nhiêu số chẵn, bao nhiêu số lẻ và in ra trình duyệt
const ds = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
let chan= 0;
for (let i =0; i < ds.length; i++) {
    if (ds[i] % 2 === 0) chan++;
}
console.log("Số lượng số chẵn:", chan);
console.log("Số lượng số lẻ:", ds.length - chan);
        