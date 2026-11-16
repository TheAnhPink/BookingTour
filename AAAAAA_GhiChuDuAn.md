* **xóa mã code trong khuyến mãi** (Đã xóa trong classDi)



* **Đơn hàng thêm các thông tin tk hoàn tiền** (Đã thêm ClaDi)



* **API danh sách ngân hàng**

https://api.vietqr.io/v2/banks



* **Hiển thị QR cho admin chuyển khoản đơn hủy**
String qrUrl = String.format(

&#x20;   "https://img.vietqr.io/image/%s-%s-compact2.png?amount=%s\&addInfo=Hoan%%20tien%%20don%%20%d\&accountName=%s",

&#x20;   donHang.getNganHangHoanTien(),

&#x20;   donHang.getSoTaiKhoanHoanTien(),

&#x20;   soTienHoan.toBigInteger().toString(),

&#x20;   donHang.getMaDonHang(),

&#x20;   URLEncoder.encode(donHang.getTenChuTaiKhoan(), StandardCharsets.UTF\_8)

);

\------------------------------------------------------------



* **Cần kiểm tra**

\+ tuổi người dky tk

\+ xem lại "uc xác nhận tour" vì có cổng thanh toán

\+ có giỏ hàng ko

\+ coi Nối Đổi tour với Thanh toán trực tuyến / Cổng thanh toán.   ko

\+ Thêm điểm đến trong tour, làm sao để tạo dbs tên cột theo đúng thứ tự code







**DANH SÁCH CHỨC NĂNG API**



I. KHÁCH HÀNG (PUBLIC)



1\. Lấy danh sách Tour (tìm kiếm, lọc, phân trang)

&#x20;  - API: GET /tour

&#x20;  - Tham số: tenTim, maLoaiTim, giaMin, giaMax, ngayKH, ngayKT, trang, size

&#x20;  - Controller: TourController.java



2\. Xem chi tiết Tour

&#x20;  - API: GET /tour/{maTour}

&#x20;  - Controller: TourController.java



3\. Lấy danh sách Loại Tour

&#x20;  - API: GET /loai-tour

&#x20;  - Controller: LoaiTourController.java



4\. Lấy danh sách Khách Sạn

&#x20;  - API: GET /khach-san

&#x20;  - Controller: KhachSanController.java



5\. Lấy danh sách Khuyến Mãi (phân trang)

&#x20;  - API: GET /khuyen-mai

&#x20;  - Tham số: trang, size

&#x20;  - Controller: KhuyenMaiController.java





II. ADMIN (QUẢN TRỊ)



1\. Quản lý Tour - AdminTourController.java

&#x20;  - Thêm: POST /admin/tour

&#x20;  - Cập nhật: PUT /admin/tour/{maTour}

&#x20;  - Xóa: DELETE /admin/tour/{maTour}



2\. Quản lý Loại Tour - AdminLoaiTourController.java

&#x20;  - Thêm: POST /admin/loai-tour

&#x20;  - Cập nhật: PUT /admin/loai-tour/{maLoaiTour}

&#x20;  - Xóa: DELETE /admin/loai-tour/{maLoaiTour}



3\. Quản lý Khách Sạn - AdminKhachSanController.java

&#x20;  - Thêm: POST /admin/khach-san

&#x20;  - Cập nhật: PUT /admin/khach-san/{maKhachSan}

&#x20;  - Xóa: DELETE /admin/khach-san/{maKhachSan}



4\. Quản lý Khuyến Mãi - AdminKhuyenMaiController.java

&#x20;  - Thêm: POST /admin/khuyen-mai

&#x20;  - Cập nhật: PUT /admin/khuyen-mai/{maKhuyenMai}

&#x20;  - Xóa: DELETE /admin/khuyen-mai/{maKhuyenMai}



