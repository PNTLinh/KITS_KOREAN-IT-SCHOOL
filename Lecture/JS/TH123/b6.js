//Viết chương trình để biến đổi mảng trên thành mảng có cấu trúc như sau  
let arr=[
    {
        name:'A',
        model: 'X',
    },{
        name:'A',
        model: 'Y',
    },{
        name:'B',
        model: 'Z',
    },{
        name:'C',
        model: 'W',
    },{
        name:'B',
        model: 'V',
    },{
        name:'C',
        model: 'T',
    }
];
function bd(arr) {
    let kq= [];
    let map = {};
    for (let i of arr){
        if (!map[i.name]) map[i.name] = [];
        map[i.name].push({name: i.name, model: i.model});
    }
    for (let key in map){
        kq.push({name: key, model: map[key]});
    }
    return kq;
}