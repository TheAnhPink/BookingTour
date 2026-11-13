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
    @NotNull
    @Column(name = "phuongThuc", nullable = false, length = 50)
    private PhuongThucThanhToan phuongThuc;

    @NotBlank @Size(min = 5, max = 100)
    @Column(name = "maGiaoDich", nullable = false, length = 100)
    private String maGiaoDich;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "soTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal soTien;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "trangThai", nullable = false, length = 50)
    private TrangThaiThanhToan trangThai;

    @Column(name = "thoiGian")
    private LocalDateTime thoiGian;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    private DonHang donHang;
}