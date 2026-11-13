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

\+ sửa lại tài liệu vì khách sạn nối 1-n vào tour luôn

