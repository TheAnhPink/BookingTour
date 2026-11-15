USE bookingtour_final;

-- ==========================================
-- 1. CÁC BẢNG ĐỘC LẬP (KHÔNG CHỨA KHÓA NGOẠI)
-- ==========================================

-- 1. NguoiDung
CREATE TABLE NguoiDung (
                           maNguoiDung BIGINT AUTO_INCREMENT PRIMARY KEY,
                           hoTen VARCHAR(255) NOT NULL,
                           email VARCHAR(255) NOT NULL UNIQUE,
                           matKhau VARCHAR(255) NOT NULL,
                           soDienThoai VARCHAR(20) NOT NULL UNIQUE,
                           ngaySinh DATE NOT NULL,
                           cccdHoChieu VARCHAR(20) NOT NULL,
                           vaiTro VARCHAR(20) NOT NULL,
                           trangThai BIT,
                           ngayTao DATE
);

-- 2. LoaiTour
CREATE TABLE LoaiTour (
                          maLoaiTour BIGINT AUTO_INCREMENT PRIMARY KEY,
                          tenLoai VARCHAR(255) NOT NULL,
                          moTa VARCHAR(2000)
);

-- 3. KhachSan
CREATE TABLE KhachSan (
                          maKhachSan BIGINT AUTO_INCREMENT PRIMARY KEY,
                          tenKhachSan VARCHAR(255) NOT NULL,
                          diaChi VARCHAR(500) NOT NULL,
                          hangSao INT NOT NULL,
                          soDienThoai VARCHAR(20)
);

-- 4. KhuyenMai
CREATE TABLE KhuyenMai (
                           maKhuyenMai BIGINT AUTO_INCREMENT PRIMARY KEY,
                           tenChuongTrinh VARCHAR(255) NOT NULL,
                           moTa VARCHAR(2000),
                           loaiGiamGia VARCHAR(20) NOT NULL,
                           giaTriGiam DECIMAL(15,2) NOT NULL,
                           giamToiDa DECIMAL(15,2),
                           ngayBatDau DATETIME NOT NULL,
                           ngayKetThuc DATETIME NOT NULL,
                           soLuongToiDa INT NOT NULL,
                           soLuongDaDung INT,
                           trangThai BIT
);


-- ==========================================
-- 2. CÁC BẢNG PHỤ THUỘC BẬC 1
-- ==========================================

-- 5. Tour
CREATE TABLE Tour (
                      maTour BIGINT AUTO_INCREMENT PRIMARY KEY,
                      tenTour VARCHAR(255) NOT NULL,
                      diemDen VARCHAR(255) NOT NULL,
                      moTa TEXT,
                      thoiLuong VARCHAR(100) NOT NULL,
                      phuongTien VARCHAR(255) NOT NULL,
                      tieuChuanLuuTru VARCHAR(255),
                      giaNguoiLon DECIMAL(15,2) NOT NULL,
                      giaTreEm DECIMAL(15,2) NOT NULL,
                      giaEmBe DECIMAL(15,2) NOT NULL,
                      phongCach VARCHAR(255),
                      mucDoVanDong INT,
                      hinhAnhChinh VARCHAR(1000) NOT NULL,
                      trangThai VARCHAR(20),
                      maLoaiTour BIGINT NOT NULL,
                      FOREIGN KEY (maLoaiTour) REFERENCES LoaiTour(maLoaiTour)
);

-- 6. DonHang
CREATE TABLE DonHang (
                         maDonHang BIGINT AUTO_INCREMENT PRIMARY KEY,
                         ngayDat DATETIME,
                         tongTien DECIMAL(15,2) NOT NULL,
                         tienGiam DECIMAL(15,2),
                         thanhTien DECIMAL(15,2) NOT NULL,
                         trangThai VARCHAR(50) NOT NULL,
                         ghiChu VARCHAR(1000),
                         ngayHuy DATETIME,
                         lyDoHuy VARCHAR(2000),
                         tienPhatHuy DECIMAL(15,2),
                         nganHangHoanTien VARCHAR(255),
                         tenChuTaiKhoan VARCHAR(255),
                         soTaiKhoanHoanTien VARCHAR(50),
                         daHoanTien BIT,
                         maNguoiDung BIGINT NOT NULL,
                         maKhuyenMai BIGINT,
                         FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung),
                         FOREIGN KEY (maKhuyenMai) REFERENCES KhuyenMai(maKhuyenMai) ON DELETE SET NULL
);


-- ==========================================
-- 3. CÁC BẢNG PHỤ THUỘC BẬC 2
-- ==========================================

-- 7. AnhTour
CREATE TABLE AnhTour (
                         maAnh BIGINT AUTO_INCREMENT PRIMARY KEY,
                         duongDan VARCHAR(1000) NOT NULL,
                         laAnhChinh BIT,
                         maTour BIGINT NOT NULL,
                         FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE
);

-- 8. LichTrinhTour
CREATE TABLE LichTrinhTour (
                               maLichTrinh BIGINT AUTO_INCREMENT PRIMARY KEY,
                               ngayThu INT NOT NULL,
                               tieuDe VARCHAR(500) NOT NULL,
                               noiDung TEXT NOT NULL,
                               maTour BIGINT NOT NULL,
                               FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE
);

-- 9. LichKhoiHanh
CREATE TABLE LichKhoiHanh (
                              maLichKhoiHanh BIGINT AUTO_INCREMENT PRIMARY KEY,
                              ngayKhoiHanh DATETIME NOT NULL,
                              ngayKetThuc DATETIME NOT NULL,
                              soChoToiDa INT NOT NULL,
                              soChoConLai INT NOT NULL,
                              trangThai VARCHAR(50),
                              maTour BIGINT NOT NULL,
                              maKhachSan BIGINT NOT NULL,
                              FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE,
                              FOREIGN KEY (maKhachSan) REFERENCES KhachSan(maKhachSan)
);

-- 10. ChiTietDonHang
CREATE TABLE ChiTietDonHang (
                                maChiTiet BIGINT AUTO_INCREMENT PRIMARY KEY,
                                soLuongNguoiLon INT NOT NULL,
                                soLuongTreEm INT NOT NULL,
                                soLuongEmBe INT NOT NULL,
                                donGiaNguoiLon DECIMAL(15,2) NOT NULL,
                                donGiaTreEm DECIMAL(15,2) NOT NULL,
                                donGiaEmBe DECIMAL(15,2) NOT NULL,
                                ghiChu VARCHAR(1000),
                                maDonHang BIGINT NOT NULL,
                                maLichKhoiHanh BIGINT NOT NULL,
                                FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang) ON DELETE CASCADE,
                                FOREIGN KEY (maLichKhoiHanh) REFERENCES LichKhoiHanh(maLichKhoiHanh)
);

-- 11. ThanhToan
CREATE TABLE ThanhToan (
                           maThanhToan BIGINT AUTO_INCREMENT PRIMARY KEY,
                           phuongThuc VARCHAR(50) NOT NULL,
                           maGiaoDich VARCHAR(255) NOT NULL,
                           soTien DECIMAL(15,2) NOT NULL,
                           trangThai VARCHAR(50) NOT NULL,
                           thoiGian DATETIME,
                           maDonHang BIGINT NOT NULL,
                           FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang) ON DELETE CASCADE
);


-- ==========================================
-- 4. CÁC BẢNG PHỤ THUỘC BẬC 3 & 4
-- ==========================================

-- 12. HanhKhach
CREATE TABLE HanhKhach (
                           maHanhKhach BIGINT AUTO_INCREMENT PRIMARY KEY,
                           hoTen VARCHAR(255) NOT NULL,
                           loaiHanhKhach VARCHAR(20) NOT NULL,
                           ngaySinh DATE NOT NULL,
                           gioiTinh VARCHAR(50) NOT NULL,
                           cccdHoChieu VARCHAR(50),
                           maChiTiet BIGINT NOT NULL,
                           FOREIGN KEY (maChiTiet) REFERENCES ChiTietDonHang(maChiTiet) ON DELETE CASCADE
);

-- 13. DanhGia
CREATE TABLE DanhGia (
                         maDanhGia BIGINT AUTO_INCREMENT PRIMARY KEY,
                         soSao INT NOT NULL,
                         binhLuan VARCHAR(2000),
                         ngayTao DATE,
                         maNguoiDung BIGINT NOT NULL,
                         maTour BIGINT NOT NULL,
                         maDonHang BIGINT NOT NULL,
                         FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung),
                         FOREIGN KEY (maTour) REFERENCES Tour(maTour),
                         FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang)
);