
CREATE DATABASE QLBanBK1;


USE QLBanBK1;

CREATE TABLE NguoiDung(
    TaiKhoan NVARCHAR(255) PRIMARY KEY NOT NULL,
	MatKhau NVARCHAR(255) Not null,
);


CREATE TABLE NhanVien (
    MaNV INT PRIMARY KEY NOT NULL,
    TenNV NVARCHAR(255) NOT NULL,
    DiaChi NVARCHAR(255) NOT NULL,
    Luong float NOT NULL,
    Email NVARCHAR(255) NOT NULL,
    NgaySinh DATE NULL,
    GioiTinh NVARCHAR(10)NOT NULL,
    ChucVu NVARCHAR(50) NOT NULL
);


CREATE TABLE NhaCungCap (
    MaNCC INT PRIMARY KEY NOT NULL,
    TenNCC NVARCHAR(255) NOT NULL,
    DiaChi NVARCHAR(255)NOT  NULL,
    DienThoai NVARCHAR(15) NOT NULL,
    Email NVARCHAR(255)NOT NULL
);


CREATE TABLE SanPham(
    MaSP INT PRIMARY KEY NOT NULL,
    TenSP NVARCHAR(255) NOT NULL,
    MoTa NVARCHAR(255)NOT NULL,
    Gia FLOAT NOT NULL,  
	SoLuong INT NOT NULL,
    MaNCC INT NOT NULL,
  -- FOREIGN KEY (MaNCC) REFERENCES NhaCungCap (MaNCC)
);

CREATE TABLE HoaDon (
    MaHD INT PRIMARY KEY NOT NULL,
    MaNV INT NOT NULL,
    NgayLap DATE  NULL,
    TongTien FLOAT NOT NULL,
    --FOREIGN KEY (MaNV) REFERENCES NhanVien (MaNV),
	
);

CREATE TABLE ChiTietHoaDon (
    STT INT  PRIMARY KEY NOT NULL,
    MaHD INT  NOT NULL,
    MaSP INT  NOT NULL,
    TenSP NVARCHAR(255) NOT NULL,
    SoLuong INT NOT NULL,
    GiaBan FLOAT NOT NULL,
	--FOREIGN KEY (MaSP) REFERENCES SanPham (MaSP),
	--FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
);
INSERT INTO NguoiDung (TaiKhoan,MatKhau)
VALUES
    (N'admin', N'admin12345');

INSERT INTO NhaCungCap (MaNCC, TenNCC, DiaChi, DienThoai, Email)
VALUES
    (1, N'Hòa Phát Bakery', N'TP. HCM', N'0123456789', N'hoa.phat@example.com'),
    (2, N'Bánh Mì QR', N'TP. Hà Nội', N'0987654321', N'hoabinh@example.com'),
    (3, N'Công Ty Bánh Kẹo Đa Quốc Gia', N'789 Đường GHI, Quận LMN', N'0345678901', N'daquocgia@example.com'),
    (4, N'Công Ty Bánh Kẹo ABC', N'TP. Hà Tĩnh', N'0554321098', N'abc@example.com'),
    (5, N'Bánh Mì Nam Phong', N'TP. Cần Thơ', N'0333333333', N'namphong@example.com');

INSERT INTO NhanVien (MaNV, TenNV, DiaChi,Luong, Email, NgaySinh, GioiTinh, ChucVu)
VALUES
    (1, N'Chung', N'TP. Hà Nội',5000, N'a@example.com', '1990-01-15', N'Nam', N'Quản lý'),
    (2, N'Công', N'TP. Hà Nội', 4000, N'b@example.com', '1992-03-20', N'Nam', N'Nhân viên bán hàng'),
    (3, N'Đức', N'TP. Hà Nội', 4000, N'c@example.com', '1985-11-10', N'Nam', N'Nhân viên bán hàng'),
    (4, N'Trang', N'TP. Hà Tĩnh', 4000, N'd@example.com', '1991-07-25', N'Nữ', N'Nhân viên bán hàng'),
    (5, N'Linh', N'TP. HCM', 3000, N'f@example.com', '1988-04-12', N'Nữ', N'Nhân viên bán hàng');
    


INSERT INTO SanPham (MaSP, TenSP, MoTa, Gia,SoLuong, MaNCC)
VALUES
    (1, N'Bánh Sữa', N'Bánh sữa thơm ngon', 100, 100, 1),
    (2, N'Bánh Bao', N'Bánh bao xốp mềm', 50, 150, 1),
    (3, N'Bánh Trung Thu', N'Bánh trung thu truyền thống', 30, 200, 2),
    (4, N'Kẹo Hạt Dẻ', N'Kẹo hạt dẻ ngọt ngào', 30, 300, 3),
    (5, N'Bánh Mì Bơ', N'Bánh mì bơ tươi ngon', 35, 250, 4),
    (6, N'Bánh Khoai Môn', N'Bánh khoai môn giòn tan', 25, 180, 3),
    (7, N'Kẹo Sô Cô La', N'Kẹo sô cô la đắng ngọt', 40, 400, 3),
    (8, N'Bánh Flan', N'Bánh flan mềm mịn', 15, 120, 4),
    (9, N'Bánh Pía', N'Bánh pía sầu riêng', 45, 220, 3),
    (10, N'Bánh Gato', N'Bánh gato phủ socola', 90, 160, 4),
    (11, N'Bánh Tiramisu', N'Bánh tiramisu thơm ngon', 40, 80, 1),
    (12, N'Kẹo Caramel', N'Kẹo caramel béo ngon', 20, 200, 2),
    (13, N'Bánh Donut', N'Bánh donut trắng mịn', 30, 150, 3),
    (14, N'Kẹo Dẻo Fruity', N'Kẹo dẻo vị trái cây', 25, 250, 4),
    (15, N'Bánh Bông Lan', N'Bánh bông lan thơm lừng', 18, 180, 1),
    (16, N'Bánh Chuối', N'Bánh chuối béo ngon', 15, 120, 2),
    (17, N'Kẹo Hấp Hấp', N'Kẹo hấp hấp ngon miệng', 30, 300, 3),
    (18, N'Bánh Kem Dâu', N'Bánh kem dâu tươi ngon', 28, 280, 4),
    (19, N'Bánh Sô-cô-la Sữa', N'Bánh sô-cô-la sữa ngọt', 19, 190, 1),
    (20, N'Kẹo Bạc Hà', N'Kẹo bạc hà thơm ngon', 22, 220, 2),
    (21, N'Bánh Bí Đỏ', N'Bánh bí đỏ giòn tan', 17, 170, 3),
    (22, N'Bánh Phô Mai', N'Bánh phô mai béo ngon', 13, 130, 4),
    (23, N'Kẹo Mứt Trái Cây', N'Kẹo mứt trái cây tươi', 25, 250, 1),
    (24, N'Bánh Lamington', N'Bánh lamington socola', 16, 160, 2),
    (25, N'Kẹo Dẻo Jelly', N'Kẹo dẻo jelly ngọt', 19, 190, 3),
    (26, N'Bánh Nướng', N'Bánh nướng tươi ngon', 22, 220, 4),
    (27, N'Bánh Mỳ Khoai', N'Bánh mỳ khoai thơm', 18, 180, 1),
    (28, N'Kẹo Milkshake', N'Kẹo milkshake béo', 20, 200, 2),
    (29, N'Bánh Mỳ Sữa', N'Bánh mỳ sữa ngọt', 17, 170, 3),
    (30, N'Kẹo Sữa Dẻo', N'Kẹo sữa dẻo béo', 21, 210, 4);

CREATE TRIGGER UpdateSoLuongHangHoa
ON ChiTietHoaDon
AFTER INSERT
AS
BEGIN
    -- Cập nhật số lượng hàng hóa trong bảng SanPham dựa trên thông tin từ bảng ChiTietHoaDon
    UPDATE SanPham
    SET SanPham.SoLuong = SanPham.SoLuong - I.SoLuong
    FROM SanPham
    INNER JOIN inserted AS I ON SanPham.MaSP = I.MaSP;
END;

--tính tổng tiền hóa đơn
SELECT MaHD, SUM(SoLuong * GiaBan) AS TongTienHoaDon
FROM ChiTietHoaDon
GROUP BY MaHD;

--Tính tổng doanh thu theo tháng
SELECT MONTH(NgayLap) AS Thang, SUM(TongTien) AS TongDoanhThu
FROM HoaDon
GROUP BY MONTH(NgayLap);

-- số lượng sản phẩm 
SELECT COUNT(TenSP) AS SoLuongSanPham
FROM SanPham;


-- Cập nhật tên và email của nhân viên có MaNV = 1
UPDATE NhanVien
SET TenNV = N'Nguyễn Văn B', Email = N'b@example.com'
WHERE MaNV = 1;

-- Xóa nhân viên có MaNV = 6
DELETE FROM NhanVien
WHERE MaNV = 6;

-- Cập nhật tên và email của nhà cung cấp có MaNCC = 1
UPDATE NhaCungCap
SET TenNCC = N'Công Ty Bánh Socola X', Email = N'socolax@example.com'
WHERE MaNCC = 1;

-- Xóa nhà cung cấp có MaNCC = 6
DELETE FROM NhaCungCap
WHERE MaNCC = 6;

-- Cập nhật giá và số lượng của sản phẩm có MaSP = 1
UPDATE SanPham
SET Gia = 110, SoLuong = 90
WHERE MaSP = 1;

-- Xóa sản phẩm có MaSP = 31
DELETE FROM SanPham
WHERE MaSP = 31;

