package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ThanhToan")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maThanhToan")
    private Long maThanhToan;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Phương thức thanh toán không được để trống")
    @Column(name = "phuongThuc", nullable = false, length = 50)
    private PhuongThucThanhToan phuongThuc;

    @NotBlank(message = "Mã giao dịch không được để trống")
    @Size(min = 5, max = 100, message = "Mã giao dịch từ 5 đến 100 ký tự")
    @Column(name = "maGiaoDich", nullable = false, length = 255)
    private String maGiaoDich;

    @NotNull(message = "Số tiền không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Số tiền phải lớn hơn 0")
    @Column(name = "soTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal soTien;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Trạng thái thanh toán không được để trống")
    @Column(name = "trangThai", nullable = false, length = 50)
    private TrangThaiThanhToan trangThai;

    @Column(name = "thoiGian")
    private LocalDateTime thoiGian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    private DonHang donHang;

    public boolean kiemTraKhopSoTienThanhToan() {
        if (this.donHang == null || this.soTien == null || this.donHang.getThanhTien() == null) return false;
        return this.soTien.compareTo(this.donHang.getThanhTien()) == 0;
    }
}