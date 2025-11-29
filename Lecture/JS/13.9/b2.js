const ds= [10,1,6,8,3,5,7,9,2,4];
for (let i=0; i < ds.length -1; i++) {
    for (let j=i+1; j < ds.length; j++) {
        if (ds[i]> ds[j]) {
            let tg= ds[i];
            ds[i]= ds[j];
            ds[j]= tg;
        }
    }
}
console.log("Mảng sau khi sắp xếp:", ds);
//-	2, Viết chương trình sắp xếp mảng số nguyên ở câu 1 theo thứ tự tăng dần và in ra trình duyệt