package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ChiTietDonHang")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maChiTiet")
    private Long maChiTiet;

    @NotNull @Min(0)
    @Column(name = "soLuongNguoiLon", nullable = false)
    private Integer soLuongNguoiLon;

    @NotNull @Min(0)
    @Column(name = "soLuongTreEm", nullable = false)
    private Integer soLuongTreEm;

    @NotNull @Min(0)
    @Column(name = "soLuongEmBe", nullable = false)
    private Integer soLuongEmBe;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "donGiaNguoiLon", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaNguoiLon;

    @NotNull @DecimalMin("0.0")
    @Column(name = "donGiaTreEm", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaTreEm;

    @NotNull @DecimalMin("0.0")
    @Column(name = "donGiaEmBe", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaEmBe;

    @Size(max = 500)
    @Column(name = "ghiChu", length = 500)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLichKhoiHanh", nullable = false)
    private LichKhoiHanh lichKhoiHanh;

    @OneToMany(mappedBy = "chiTietDonHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HanhKhach> hanhKhachs;
}