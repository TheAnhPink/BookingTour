-- ==========================================
-- 1. TẠO DATABASE (Chuẩn hỗ trợ tiếng Việt & Emoji)
-- ==========================================
DROP DATABASE IF EXISTS WebTourDuLich;
CREATE DATABASE WebTourDuLich CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE WebTourDuLich;

-- ==========================================
-- 2. TẠO CÁC BẢNG DANH MỤC ĐỘC LẬP
-- ==========================================

-- Bảng Người Dùng
CREATE TABLE NguoiDung (
    maNguoiDung     INT AUTO_INCREMENT PRIMARY KEY,
    hoTen           VARCHAR(100) NOT NULL,
    email           VARCHAR(100) NOT NULL UNIQUE,
    matKhau         VARCHAR(255) NOT NULL,             -- BCrypt hash
    soDienThoai     VARCHAR(20),
    ngaySinh        DATE,
    cccdHoChieu     VARCHAR(50),
    vaiTro          VARCHAR(20) NOT NULL DEFAULT 'CUSTOMER',  -- ADMIN / CUSTOMER
    trangThai       TINYINT(1) NOT NULL DEFAULT 1,     -- 1: Hoạt động, 0: Bị khóa
    ngayTao         TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Loại Tour
CREATE TABLE LoaiTour (
    maLoaiTour      INT AUTO_INCREMENT PRIMARY KEY,
    tenLoai         VARCHAR(100) NOT NULL,
    moTa            TEXT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Khách Sạn
CREATE TABLE KhachSan (
    maKhachSan      INT AUTO_INCREMENT PRIMARY KEY,
    tenKhachSan     VARCHAR(200) NOT NULL,
    diaChi          VARCHAR(255) NOT NULL,
    hangSao         INT,
    soDienThoai     VARCHAR(20)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ==========================================
-- 3. TẠO CÁC BẢNG NGHIỆP VỤ CHÍNH
-- ==========================================

-- Bảng Tour
CREATE TABLE Tour (
    maTour              INT AUTO_INCREMENT PRIMARY KEY,
    maLoaiTour          INT NOT NULL,
    tenTour             VARCHAR(255) NOT NULL,
    moTa                TEXT,
    thoiLuong           VARCHAR(50),
    phuongTien          VARCHAR(100),
    tieuChuanLuuTru     VARCHAR(100),
    giaNguoiLon         DECIMAL(15,2) NOT NULL,
    giaTreEm            DECIMAL(15,2) NOT NULL,
    giaEmBe             DECIMAL(15,2) NOT NULL,
    phongCach           VARCHAR(100),
    mucDoVanDong        INT DEFAULT 1,
    hinhAnhChinh        VARCHAR(255),
    trangThai           VARCHAR(20) NOT NULL DEFAULT 'ACTIVE',
    CONSTRAINT fk_Tour_LoaiTour FOREIGN KEY (maLoaiTour) REFERENCES LoaiTour(maLoaiTour)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Ảnh Tour
CREATE TABLE AnhTour (
    maAnh           INT AUTO_INCREMENT PRIMARY KEY,
    maTour          INT NOT NULL,
    duongDan        VARCHAR(255) NOT NULL,
    laAnhChinh      TINYINT(1) DEFAULT 0,
    CONSTRAINT fk_AnhTour_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Lịch Khởi Hành
CREATE TABLE LichKhoiHanh (
    maLichKhoiHanh  INT AUTO_INCREMENT PRIMARY KEY,
    maTour          INT NOT NULL,
    ngayKhoiHanh    DATETIME NOT NULL,
    ngayKetThuc     DATETIME NOT NULL,
    soChoToiDa      INT NOT NULL,
    soChoConLai     INT NOT NULL,
    trangThai       VARCHAR(20) DEFAULT 'OPEN',
    CONSTRAINT fk_LichKhoiHanh_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Lịch Trình Tour
CREATE TABLE LichTrinhTour (
    maLichTrinh     INT AUTO_INCREMENT PRIMARY KEY,
    maTour          INT NOT NULL,
    ngayThu         INT NOT NULL,
    tieuDe          VARCHAR(255) NOT NULL,
    noiDung         TEXT,
    maKhachSan      INT NULL,
    CONSTRAINT fk_LichTrinh_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE,
    CONSTRAINT fk_LichTrinh_KhachSan FOREIGN KEY (maKhachSan) REFERENCES KhachSan(maKhachSan) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Khuyến Mãi
CREATE TABLE KhuyenMai (
    maKhuyenMai         INT AUTO_INCREMENT PRIMARY KEY,
    maCode              VARCHAR(50) NOT NULL UNIQUE,
    tenChuongTrinh      VARCHAR(255) NOT NULL,
    moTa                TEXT,
    loaiGiamGia         VARCHAR(20) NOT NULL,          -- PERCENT / FIXED_AMOUNT
    giaTriGiam          DECIMAL(15,2) NOT NULL,
    giamToiDa           DECIMAL(15,2),
    ngayBatDau          DATETIME NOT NULL,
    ngayKetThuc         DATETIME NOT NULL,
    soLuongToiDa        INT,
    soLuongDaDung       INT DEFAULT 0,
    trangThai           TINYINT(1) DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Đơn Hàng
CREATE TABLE DonHang (
    maDonHang       INT AUTO_INCREMENT PRIMARY KEY,
    maNguoiDung     INT NOT NULL,
    maKhuyenMai     INT NULL,
    ngayDat         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    tongTien        DECIMAL(15,2) NOT NULL,
    tienGiam        DECIMAL(15,2) DEFAULT 0,
    thanhTien       DECIMAL(15,2) NOT NULL,
    trangThai       VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    ghiChu          TEXT,
    ngayHuy         DATETIME NULL,
    lyDoHuy         TEXT NULL,
    tienPhatHuy     DECIMAL(15,2) DEFAULT 0,
    
    CONSTRAINT fk_DonHang_NguoiDung FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung),
    CONSTRAINT fk_DonHang_KhuyenMai FOREIGN KEY (maKhuyenMai) REFERENCES KhuyenMai(maKhuyenMai) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Chi Tiết Đơn Hàng
CREATE TABLE ChiTietDonHang (
    maChiTiet           INT AUTO_INCREMENT PRIMARY KEY,
    maDonHang           INT NOT NULL,
    maLichKhoiHanh      INT NOT NULL,
    soLuongNguoiLon     INT NOT NULL DEFAULT 0,
    soLuongTreEm        INT NOT NULL DEFAULT 0,
    soLuongEmBe         INT NOT NULL DEFAULT 0,
    donGiaNguoiLon      DECIMAL(15,2) NOT NULL,
    donGiaTreEm         DECIMAL(15,2) NOT NULL,
    donGiaEmBe          DECIMAL(15,2) NOT NULL,
    CONSTRAINT fk_CTDH_DonHang FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang) ON DELETE CASCADE,
    CONSTRAINT fk_CTDH_LichKhoiHanh FOREIGN KEY (maLichKhoiHanh) REFERENCES LichKhoiHanh(maLichKhoiHanh)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Hành Khách
CREATE TABLE HanhKhach (
    maHanhKhach     INT AUTO_INCREMENT PRIMARY KEY,
    maChiTiet       INT NOT NULL,
    hoTen           VARCHAR(100) NOT NULL,
    loaiHanhKhach   VARCHAR(20) NOT NULL,              -- ADULT / CHILD / INFANT
    ngaySinh        DATE,
    gioiTinh        VARCHAR(10),
    cccdHoChieu     VARCHAR(50),
    CONSTRAINT fk_HanhKhach_CTDH FOREIGN KEY (maChiTiet) REFERENCES ChiTietDonHang(maChiTiet) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Thanh Toán
CREATE TABLE ThanhToan (
    maThanhToan     INT AUTO_INCREMENT PRIMARY KEY,
    maDonHang       INT NOT NULL,
    phuongThuc      VARCHAR(50) NOT NULL,              -- VNPAY / MOMO / BANK_TRANSFER
    maGiaoDich      VARCHAR(100),
    soTien          DECIMAL(15,2) NOT NULL,
    trangThai       VARCHAR(50) NOT NULL,
    thoiGian        TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_ThanhToan_DonHang FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Bảng Đánh Giá
CREATE TABLE DanhGia (
    maDanhGia       INT AUTO_INCREMENT PRIMARY KEY,
    maNguoiDung     INT NOT NULL,
    maTour          INT NOT NULL,
    maDonHang       INT NOT NULL,
    soSao           INT NOT NULL,
    binhLuan        TEXT,
    ngayTao         TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_DanhGia_NguoiDung FOREIGN KEY (maNguoiDung) REFERENCES NguoiDung(maNguoiDung) ON DELETE CASCADE,
    CONSTRAINT fk_DanhGia_Tour FOREIGN KEY (maTour) REFERENCES Tour(maTour) ON DELETE CASCADE,
    CONSTRAINT fk_DanhGia_DonHang FOREIGN KEY (maDonHang) REFERENCES DonHang(maDonHang)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ==========================================
-- 4. TẠO INDEX (Tối ưu hóa truy vấn)
-- ==========================================
CREATE INDEX idx_Tour_tenTour ON Tour(tenTour);
CREATE INDEX idx_LichKhoiHanh_ngay ON LichKhoiHanh(ngayKhoiHanh);
CREATE INDEX idx_DonHang_ngayDat ON DonHang(ngayDat);