//Viết chương trình sắp xếp mảng tăng dần và giảm dần sử dụng thuật toán sắp xếp sủi bọt 
const ds=[10,2,3,2,5];
for (let i=0;i<ds.length-1;i++){
    for (let j=0;j<ds.length-1-i;j++){
        if (ds[j]>ds[j+1]){
            let tg=ds[j];
            ds[j]=ds[j+1];
            ds[j+1]=tg;
        }
    }
}
console.log(ds);