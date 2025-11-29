/* Câu 5: Cho một chuỗi sau 

Thực hiện xử lý chuỗi:
Xử lý chuỗi để chuỗi đó không xuất hiện các ký tự đặc biệt: @, #, !, {, }, [,], (, )
Xử lý chuỗi để không xuất hiện nhiều hơn 1 ký tự ‘ ‘(dấu cách) liên tiếp trong chuỗi, không xuất hiện ký tự ‘ ‘(dấu cách) ở đầu và cuối câu

Sau đó viết các hàm sau:
a. viết 1 hàm nhận vào chuỗi đã xử lý và trả ra một mảng mà mỗi phần tử trong mảng luôn là 1 từ, các từ phải được viết hoa chữ cái đầu tiên còn các chữ cái sau thì phải viết thường, thứ tự các từ được sắp xếp ngược lại(xem thêm ví dụ)
Ví dụ:
Chuỗi “” thì trả ra: []
Chuỗi “Xin chào  Cy” thì trả ra: [“Cy”, “Chào”, “Xin”]
Chuỗi “Xin chào @CYer” thì trả ra: [“Cyer”, “Chào”, “Xin”]
Chuỗi “ Xin c{h}ào #Tech@!Cy(VN)   ” thì trả ra: [“Techcyvn”, “Chào”, “Xin”]

b. viết 1 hàm nhận vào chuỗi đã xử lý và trả ra giá trị trung bình các số xuất hiện trong chuỗi (Số được xác định là 1 từ chỉ chứa các ký tự số); số trung bình chỉ lấy đến 1 số sau dấu phẩy
Ví dụ:
Chuỗi “” thì trả ra: 0
Chuỗi “Xin chào  Cy” thì trả ra: 0
Chuỗi “Xin chào 123456 @Cy” thì trả ra: 123456 */

function xulyChuoiTho(s) {
    for (let i=0; i<s.length; i++){
        if (s[i]==='@' || s[i]==='#' || s[i]==='!' || s[i]==='{' || s[i]==='}' || s[i]==='[' || s[i]===']' || s[i]==='(' || s[i]===')'){
            s=s.replace(s[i],"");
        }
    }
    //delete space at the beginning and end
    s=s.trim();
    //delete more than 1 space between words
    while (s.indexOf("  ")!==-1){
        s=s.replace("  "," ");
    }
    return s;
}
function xuLy(s){
    let arr = xulyChuoiTho(s).split(" ");
    let res = [];
    for (let i=0; i<arr.length; i++){
        let word = arr[i];
        word = word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
        res.unshift(word);//reverse order
    }
    return res;
}
function demSo(s){
    s = xulyChuoiTho(s);
    let arr = s.split(" ");
    let sum = 0;
    let count = 0;
    for (let i=0; i<arr.length; i++){
        if (/^\d+$/.test(arr[i])){
            sum += Number(arr[i]);
            count++;
        }
    }
    return count === 0 ? 0 : (sum/count).toFixed(1);
}
