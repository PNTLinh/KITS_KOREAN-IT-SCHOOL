create database aims_test;
use aims_test;

create table Customer(
	CustomerID INT auto_increment primary key,
    FullName varchar(100),
    Email varchar(100) unique,
    PasswordHash varchar(100),
    Address varchar(200)
);


INSERT INTO Customer (FullName, Email, PasswordHash, Address) VALUES
('Nguyen Van A', 'a@gmail.com', 'hash1', 'Hanoi'),
('Le Thi B', 'b@gmail.com', 'hash2', 'HCM City'),
('Tran Van C', 'c@gmail.com', 'hash3', 'Da Nang'),
('Pham Thi D', 'd@gmail.com', 'hash4', 'Can Tho'),
('Do Van E', 'e@gmail.com', 'hash5', 'Hai Phong');

CREATE TABLE Manager (
    ManagerID INT AUTO_INCREMENT PRIMARY KEY,
    Email VARCHAR(50) UNIQUE,
    PasswordHash VARCHAR(255)
);
INSERT INTO Manager (Email, PasswordHash) VALUES
('admin1@gmail.com', 'adminhash1'),
('admin2@gmail.com', 'adminhash2'),
('manager3@gmail.com', 'adminhash3'),
('manager4@gmail.com', 'adminhash4'),
('admin5@gmail.com', 'adminhash5');

create table Product(
ProductID INT auto_increment primary key,
Title varchar(200),
Category varchar(200),
Price Decimal(10, 2),
Quantity int,
AddedDate datetime,
ProductType ENUM('Book', 'DVD', 'CD') NOT NULL
);
INSERT INTO Product (Title, Category, Price, Quantity, AddedDate, ProductType) VALUES
('Book A', 'Books', 120000, 10, NOW(), 'Book'),
('CD B', 'Music', 80000, 20, NOW(), 'CD'),
('DVD C', 'Movies', 150000, 15, NOW(), 'DVD'),
('Book D', 'Books', 100000, 8, NOW(), 'Book'),
('CD E', 'Music', 95000, 12, NOW(), 'CD');


create table Book(
	ProductID int primary key,
    ContentLength int,
    foreign key (ProductID) references Product(ProductID) on delete cascade
);

create table BookAuthor(
	BookID int,
    AuthorName Varchar(100),
    primary key (BookID, AuthorName),
    foreign key (BookID) references Book(ProductID) on delete cascade
);

INSERT INTO Book (ProductID, ContentLength) VALUES
(1, 350),
(4, 420);

INSERT INTO BookAuthor (BookID, AuthorName) VALUES
(1, 'Author A1'),
(1, 'Author A2'),
(4, 'Author D1'),
(4, 'Author D2'),
(4, 'Author D3');

CREATE TABLE CD (
    ProductID INT PRIMARY KEY,
    Artist VARCHAR(100),
    Director VARCHAR(100),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
);

CREATE TABLE Track (
    TrackID INT AUTO_INCREMENT PRIMARY KEY,
    CDID INT,
    Title VARCHAR(255),
    Length INT,
    FOREIGN KEY (CDID) REFERENCES CD(ProductID) ON DELETE CASCADE
);

CREATE TABLE DVD (
    ProductID INT PRIMARY KEY,
    Director VARCHAR(100),
    Length INT,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
);

INSERT INTO CD (ProductID, Artist, Director) VALUES
(2, 'Artist B', 'Director B'),
(5, 'Artist E', 'Director E');
INSERT INTO Track (CDID, Title, Length) VALUES
(2, 'Track 1', 180),
(2, 'Track 2', 210),
(5, 'Track A', 160),
(5, 'Track B', 200),
(5, 'Track C', 220);
INSERT INTO DVD (ProductID, Director, Length) VALUES
(3, 'Director C', 110);


CREATE TABLE Cart (
    CartID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE
);

# Liên kết giữa Cart và Product
CREATE TABLE CartItem (
    CartID INT,
    ProductID INT,
    Quantity INT,
    PRIMARY KEY (CartID, ProductID),
    FOREIGN KEY (CartID) REFERENCES Cart(CartID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
);


INSERT INTO Cart (CustomerID) VALUES
(1), (2), (3), (4), (5);
INSERT INTO CartItem (CartID, ProductID, Quantity) VALUES
(1, 1, 1),
(1, 2, 2),
(2, 3, 1),
(3, 4, 1),
(4, 5, 3);

CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    TotalAmount DECIMAL(10,2),
    VAT DECIMAL(10,2),
    ShippingFee DECIMAL(10,2),
    Status ENUM('Pending', 'Approved', 'Rejected') DEFAULT 'Pending',
    ShippingAddress TEXT,
    FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID) ON DELETE CASCADE
);
# LIên kết giữa Order và Product
CREATE TABLE OrderItem (
    OrderID INT,
    ProductID INT,
    Quantity INT,
    Price DECIMAL(10,2),
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE CASCADE
);


INSERT INTO Orders (CustomerID, OrderDate, TotalAmount, VAT, ShippingFee, Status, ShippingAddress)
VALUES
(1, NOW(), 300000, 30000, 20000, 'Pending', 'Hanoi'),
(2, NOW(), 150000, 15000, 15000, 'Approved', 'HCM City'),
(3, NOW(), 180000, 18000, 20000, 'Pending', 'Da Nang'),
(4, NOW(), 220000, 22000, 25000, 'Rejected', 'Can Tho'),
(5, NOW(), 200000, 20000, 20000, 'Approved', 'Hai Phong');

INSERT INTO OrderItem (OrderID, ProductID, Quantity, Price) VALUES
(1, 1, 1, 120000),
(1, 2, 2, 80000),
(2, 3, 1, 150000),
(3, 4, 1, 100000),
(4, 5, 1, 95000);


# Giao dịch/Thanh toán
CREATE TABLE Transaction (
    TransactionID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    CardNumber VARCHAR(20),
    CardHolderName VARCHAR(100),
    Amount DECIMAL(10,2),
    TransactionDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE CASCADE
);
INSERT INTO Transaction (OrderID, CardNumber, CardHolderName, Amount) VALUES
(1, '1234567890123456', 'Nguyen Van A', 300000),
(2, '2345678901234567', 'Le Thi B', 150000),
(3, '3456789012345678', 'Tran Van C', 180000),
(4, '4567890123456789', 'Pham Thi D', 220000),
(5, '5678901234567890', 'Do Van E', 200000);


# Khuyến mãi
CREATE TABLE Promotion (
    PromotionID INT AUTO_INCREMENT PRIMARY KEY,
    ProductID INT,
    Description TEXT,
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID) ON DELETE SET NULL
);
INSERT INTO Promotion (ProductID, Description) VALUES
(2, 'Tặng CD B khi mua bất kỳ sản phẩm nào'),
(3, 'Tặng DVD C cho hóa đơn trên 500k'),
(5, 'CD E tặng kèm khi mua combo CD'),
(1, 'Sách A giảm 10% và có quà tặng'),
(4, 'Book D tặng bookmark');

#1. Liệt kê tất cả khách hàng cùng email và địa chỉ
select c.FullName as Name,c.Address as DC, c.Email as Email
from Customer c

#2. Liệt kê tất cả sản phẩm có giá tren 100000
select *
from Product p
where p.Price>100000

#3. Liệt kê tất cả CD và tên nghệ sĩ
select CD.Artist, p.Title
from Product P
join CD on p.ProductID = CD.ProductID
where p.ProductType='CD'

 #4. Liệt kê tất cả sách và tên tác giả
select ba.AuthorName, p.Title
from Product p
join Book b on p.ProductID = b.ProductID
join BookAuthor ba on b.ProductID = ba.BookID
where p.ProductType='Book'

#5. Tính tổng số lượng hàng tồn kho

#6. Liệt kê giỏ hàng của khách hàng “Nguyen Van A” cùng số lượng sản phẩm
SELECT c.FullName, ci.Quantity as SoLuong, p.Title
from Customer c
join Cart c on c.CustomerID=c.CustomerID
join CartItem ci on c.CartID=ci.CartID
join Product p on ci.ProductID=p.ProductID
where c.FullName='Nguyen Van A'

#7. Liệt kê tất cả hóa đơn “Approved”
select *
from Orders ON
where o.Status='Approved'






