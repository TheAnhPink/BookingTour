USE bookingtour_final;

-- Tắt kiểm tra khóa ngoại
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE DanhGia;
TRUNCATE TABLE HanhKhach;
TRUNCATE TABLE ThanhToan;
TRUNCATE TABLE ChiTietDonHang;
TRUNCATE TABLE LichKhoiHanh;
TRUNCATE TABLE AnhTour;
TRUNCATE TABLE LichTrinhTour;
TRUNCATE TABLE DonHang;
TRUNCATE TABLE Tour;
TRUNCATE TABLE KhachSan;
TRUNCATE TABLE KhuyenMai;
TRUNCATE TABLE LoaiTour;
TRUNCATE TABLE NguoiDung;

SET FOREIGN_KEY_CHECKS = 1;

-- ==========================================
-- 1. NẠP DỮ LIỆU BẢNG ĐỘC LẬP
-- ==========================================

-- NguoiDung
INSERT INTO NguoiDung (hoTen, email, matKhau, soDienThoai, ngaySinh, cccdHoChieu, vaiTro, trangThai, ngayTao) VALUES
                                                                                                                  (N'Quản Trị Viên', 'admin@bookingtour.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '0901234567', '1985-05-20', '012345678912', 'QUAN_TRI_VIEN', 1, '2024-01-01'),
                                                                                                                  (N'Nguyễn Văn An', 'an.nguyen@gmail.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '0912345678', '1995-10-15', '012345678913', 'KHACH_HANG', 1, '2024-02-15'),
                                                                                                                  (N'Trần Thị Bình', 'binh.tran@gmail.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '0987654321', '1998-08-20', '012345678914', 'KHACH_HANG', 1, '2024-03-10'),
                                                                                                                  (N'Lê Hoàng Cường', 'cuong.le@gmail.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '0933111222', '1992-12-01', '012345678915', 'KHACH_HANG', 1, '2024-04-05'),
                                                                                                                  (N'Phạm Mỹ Duyên', 'duyen.pham@gmail.com', '$2a$10$N9qo8uLOickgx2ZMRZoMyeIjZAgcfl7p92ldGxad68LJZdL17lhWy', '0944555666', '2000-01-25', '012345678916', 'KHACH_HANG', 0, '2024-05-12');

-- LoaiTour
INSERT INTO LoaiTour (tenLoai, moTa) VALUES
                                         (N'Tour Trong Nước', N'Khám phá vẻ đẹp Việt Nam từ Bắc chí Nam'),
                                         (N'Tour Quốc Tế', N'Trải nghiệm văn hóa và cảnh quan các nước trên thế giới'),
                                         (N'Tour Nghỉ Dưỡng', N'Thư giãn tại các resort 5 sao, hồ bơi vô cực'),
                                         (N'Tour Mạo Hiểm', N'Chinh phục thiên nhiên, leo núi, lặn biển');

-- KhachSan
INSERT INTO KhachSan (tenKhachSan, diaChi, hangSao, soDienThoai) VALUES
                                                                     (N'Furama Resort', N'105 Võ Nguyên Giáp, Ngũ Hành Sơn, Đà Nẵng', 5, '0236398888'),
                                                                     (N'Vinpearl Resort & Spa', N'Đảo Hòn Tre, Nha Trang, Khánh Hòa', 5, '0258359888'),
                                                                     (N'Khách sạn Mường Thanh', N'CC2 Bắc Linh Đàm, Hoàng Mai, Hà Nội', 4, '0243555555'),
                                                                     (N'Khách sạn Hồng Hải', N'123 Trần Phú, Lộc Thọ, Nha Trang', 3, '0258352222');

-- KhuyenMai
INSERT INTO KhuyenMai (tenChuongTrinh, moTa, loaiGiamGia, giaTriGiam, giamToiDa, ngayBatDau, ngayKetThuc, soLuongToiDa, soLuongDaDung, trangThai) VALUES
                                                                                                                                                      (N'Ưu đãi hè rực rỡ', N'Giảm 10% cho tất cả tour mùa hè', 'PHAN_TRAM', 10.00, 500000.00, '2024-05-01 00:00:00', '2024-08-31 23:59:59', 100, 1, 1),
                                                                                                                                                      (N'Khách hàng mới', N'Giảm trực tiếp 200k cho đơn đầu tiên', 'SO_TIEN_CO_DINH', 200000.00, NULL, '2024-01-01 00:00:00', '2024-12-31 23:59:59', 500, 1, 1),
                                                                                                                                                      (N'Chào đón Quốc Khánh', N'Giảm 15% dịp lễ 2/9', 'PHAN_TRAM', 15.00, 1000000.00, '2024-08-25 00:00:00', '2024-09-05 23:59:59', 50, 0, 1);

-- ==========================================
-- 2. NẠP DỮ LIỆU TOUR & CÁC BẢNG LIÊN QUAN
-- ==========================================

-- Tour (Đã cập nhật thêm cột diemDen vào đúng vị trí)
INSERT INTO Tour (tenTour, diemDen, moTa, thoiLuong, phuongTien, tieuChuanLuuTru, giaNguoiLon, giaTreEm, giaEmBe, phongCach, mucDoVanDong, hinhAnhChinh, trangThai, maLoaiTour) VALUES
                                                                                                                                                                                    (N'Tour Đà Nẵng - Hội An 3 Ngày 2 Đêm', N'Đà Nẵng', N'Khám phá thành phố đáng sống nhất Việt Nam và phố cổ Hội An', N'3 ngày 2 đêm', N'Máy bay', N'Resort 5 sao', 3500000.00, 2625000.00, 875000.00, 'Nghỉ dưỡng', 2, 'https://images.unsplash.com/photo-1559592413-7cec4d0cae2b?w=800&q=80', 'HOAT_DONG', 1),
                                                                                                                                                                                    (N'Kỳ quan Vịnh Hạ Long 2 Ngày 1 Đêm', N'Quảng Ninh', N'Trải nghiệm du thuyền 5 sao trên Vịnh Hạ Long', N'2 ngày 1 đêm', N'Xe khách', N'Du thuyền 5 sao', 2000000.00, 1500000.00, 500000.00, 'Khám phá', 1, 'https://images.unsplash.com/photo-1521993462929-8a45a8be5b3f?w=800&q=80', 'HOAT_DONG', 1),
                                                                                                                                                                                    (N'Thiên đường đảo ngọc Phú Quốc 4N3Đ', N'Phú Quốc', N'Thư giãn tại Bãi Sao, cáp treo Hòn Thơm', N'4 ngày 3 đêm', N'Máy bay', N'Resort 5 sao', 6500000.00, 4875000.00, 1625000.00, 'Nghỉ dưỡng', 1, 'https://images.unsplash.com/photo-1590523277543-a94d2e4eb00b?w=800&q=80', 'HOAT_DONG', 3),
                                                                                                                                                                                    (N'Hành trình di sản Nhật Bản 5N4Đ', N'Nhật Bản', N'Tham quan núi Phú Sĩ, cố đô Kyoto, Tokyo', N'5 ngày 4 đêm', N'Máy bay', N'Khách sạn 4 sao', 25000000.00, 18000000.00, 5000000.00, 'Văn hóa', 3, 'https://images.unsplash.com/photo-1493976040374-85c8e12f0c0e?w=800&q=80', 'HOAT_DONG', 2),
                                                                                                                                                                                    (N'Trekking Tà Năng - Phan Dũng', N'Lâm Đồng', N'Cung đường trekking đẹp nhất Việt Nam', N'2 ngày 1 đêm', N'Xe 16 chỗ', N'Lều trại', 1500000.00, 1200000.00, 0.00, 'Mạo hiểm', 5, 'https://images.unsplash.com/photo-1551632811-561732d1e306?w=800&q=80', 'HOAT_DONG', 4);

-- LichTrinhTour
INSERT INTO LichTrinhTour (ngayThu, tieuDe, noiDung, maTour) VALUES
                                                                 (1, N'Đón khách - Nhận phòng - Tham quan Bà Nà Hills', N'Sáng: Xe đón tại sân bay. Chiều: Cáp treo Bà Nà, check-in Cầu Vàng.', 1),
                                                                 (2, N'Khám phá Phố Cổ Hội An', N'Tham quan Chùa Cầu, thả đèn hoa đăng trên sông Hoài.', 1),
                                                                 (3, N'Mua sắm - Tiễn khách', N'Tự do mua sắm đặc sản. Chiều: Xe đưa ra sân bay, kết thúc tour.', 1),
                                                                 (1, N'Khởi hành - Lên du thuyền', N'Xe đón tại Hà Nội. Trưa lên tàu, ăn buffet. Chiều: Tham quan hang Sửng Sốt.', 2),
                                                                 (2, N'Tập Thái Cực - Về Hà Nội', N'Sáng: Ngắm bình minh, chèo Kayak. Trưa: Ăn trưa, về lại Hà Nội.', 2);

-- AnhTour
INSERT INTO AnhTour (duongDan, laAnhChinh, maTour) VALUES
                                                       ('https://images.unsplash.com/photo-1528127269322-539801943592?w=800&q=80', 0, 1),
                                                       ('https://images.unsplash.com/photo-1583417319070-4a69db38a482?w=800&q=80', 0, 1),
                                                       ('https://images.unsplash.com/photo-1504457047772-27faf1c00561?w=800&q=80', 0, 2),
                                                       ('https://images.unsplash.com/photo-1570366583862-f91883984fde?w=800&q=80', 0, 2),
                                                       ('https://images.unsplash.com/photo-1507525428034-b723cf961d3e?w=800&q=80', 0, 3),
                                                       ('https://images.unsplash.com/photo-1492571350019-22de08371fd3?w=800&q=80', 0, 4);

-- LichKhoiHanh
INSERT INTO LichKhoiHanh (ngayKhoiHanh, ngayKetThuc, soChoToiDa, soChoConLai, trangThai, maTour, maKhachSan) VALUES
                                                                                                                 ('2024-07-15 08:00:00', '2024-07-17 18:00:00', 40, 38, 'DANG_MO_BAN', 1, 1),
                                                                                                                 ('2024-07-20 08:00:00', '2024-07-22 18:00:00', 40, 40, 'DANG_MO_BAN', 1, 1),
                                                                                                                 ('2024-07-18 07:00:00', '2024-07-19 17:00:00', 30, 30, 'DANG_MO_BAN', 2, 3),
                                                                                                                 ('2024-08-05 09:00:00', '2024-08-08 14:00:00', 50, 48, 'DANG_MO_BAN', 3, 2);

-- ==========================================
-- 3. NẠP DỮ LIỆU ĐƠN HÀNG VÀ CHI TIẾT
-- ==========================================

-- DonHang
INSERT INTO DonHang (ngayDat, tongTien, tienGiam, thanhTien, trangThai, ghiChu, maNguoiDung, maKhuyenMai) VALUES
                                                                                                              ('2024-06-01 10:30:00', 7000000.00, 700000.00, 6300000.00, 'DA_XAC_NHAN', N'Đi cùng gia đình, xin phòng view biển', 2, 1),
                                                                                                              ('2024-06-05 14:15:00', 4000000.00, 0.00, 4000000.00, 'DA_XAC_NHAN', N'Đi tuần trăng mật', 3, NULL),
                                                                                                              ('2024-06-10 09:00:00', 13000000.00, 200000.00, 12800000.00, 'CHO_XU_LY', N'Không lấy hóa đơn', 4, 2);

-- ChiTietDonHang
INSERT INTO ChiTietDonHang (soLuongNguoiLon, soLuongTreEm, soLuongEmBe, donGiaNguoiLon, donGiaTreEm, donGiaEmBe, ghiChu, maDonHang, maLichKhoiHanh) VALUES
                                                                                                                                                        (2, 0, 0, 3500000.00, 2625000.00, 875000.00, N'Cần phòng tầng cao', 1, 1),
                                                                                                                                                        (2, 0, 0, 2000000.00, 1500000.00, 500000.00, N'Ăn chay', 2, 3),
                                                                                                                                                        (2, 0, 0, 6500000.00, 4875000.00, 1625000.00, NULL, 3, 4);

-- ThanhToan
INSERT INTO ThanhToan (phuongThuc, maGiaoDich, soTien, trangThai, thoiGian, maDonHang) VALUES
                                                                                           ('VNPAY', 'VNP123456789', 6300000.00, 'DA_THANH_TOAN', '2024-06-01 10:35:00', 1),
                                                                                           ('MOMO', 'MOMO987654321', 4000000.00, 'DA_THANH_TOAN', '2024-06-05 14:20:00', 2),
                                                                                           ('CHUYEN_KHOAN', 'FT240610123', 12800000.00, 'DANG_CHO', '2024-06-10 09:05:00', 3);

-- ==========================================
-- 4. NẠP DỮ LIỆU HÀNH KHÁCH VÀ ĐÁNH GIÁ
-- ==========================================

-- HanhKhach
INSERT INTO HanhKhach (hoTen, loaiHanhKhach, ngaySinh, gioiTinh, cccdHoChieu, maChiTiet) VALUES
                                                                                             (N'Nguyễn Văn An', 'NGUOI_LON', '1995-10-15', N'Nam', '012345678913', 1),
                                                                                             (N'Nguyễn Thị Hoa', 'NGUOI_LON', '1997-03-22', N'Nữ', '012345678918', 1),
                                                                                             (N'Trần Thị Bình', 'NGUOI_LON', '1998-08-20', N'Nữ', '012345678914', 2),
                                                                                             (N'Trần Văn Hùng', 'NGUOI_LON', '1996-05-10', N'Nam', '012345678917', 2),
                                                                                             (N'Lê Hoàng Cường', 'NGUOI_LON', '1992-12-01', N'Nam', '012345678915', 3),
                                                                                             (N'Lê Thị Mai', 'NGUOI_LON', '1994-09-09', N'Nữ', '012345678919', 3);

-- DanhGia
INSERT INTO DanhGia (soSao, binhLuan, ngayTao, maNguoiDung, maTour, maDonHang) VALUES
                                                                                   (5, N'Dịch vụ tuyệt vời, hướng dẫn viên nhiệt tình, phòng khách sạn view biển rất đẹp!', '2024-06-05', 2, 1, 1),
                                                                                   (4, N'Chuyến đi tốt, đồ ăn ngon nhưng thời tiết hơi mưa.', '2024-06-08', 3, 2, 2);