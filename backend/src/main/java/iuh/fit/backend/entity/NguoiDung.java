package iuh.fit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "NguoiDung")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maNguoiDung;

    @Column(nullable = false, length = 100)
    private String hoTen;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String matKhau;

    @Column(length = 20)
    private String soDienThoai;

    private LocalDate ngaySinh;

    @Column(length = 50)
    private String cccdHoChieu;

    @Column(length = 20)
    private String vaiTro = "CUSTOMER"; // ADMIN / CUSTOMER

    private Boolean trangThai = (Boolean) true;

    private LocalDateTime ngayTao = LocalDateTime.now();

    // Mối quan hệ với Đơn Hàng
    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private List<DonHang> danhSachDonHang;

    // Mối quan hệ với Đánh Giá
    @OneToMany(mappedBy = "nguoiDung", cascade = CascadeType.ALL)
    private List<DanhGia> danhSachDanhGia;
}