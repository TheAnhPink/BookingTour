package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "DonHang")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDonHang")
    private Long maDonHang;

    @Column(name = "ngayDat")
    private LocalDateTime ngayDat;

    @NotNull @DecimalMin("0.0")
    @Column(name = "tongTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal tongTien; // Đã khôi phục

    @DecimalMin("0.0")
    @Column(name = "tienGiam", precision = 15, scale = 2)
    private BigDecimal tienGiam = BigDecimal.ZERO;

    @NotNull @DecimalMin("0.0")
    @Column(name = "thanhTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal thanhTien;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "trangThai", nullable = false, length = 50)
    private TrangThaiDonHang trangThai;

    @Size(max = 500)
    @Column(name = "ghiChu", length = 500)
    private String ghiChu;

    @Column(name = "ngayHuy")
    private LocalDateTime ngayHuy;

    @Size(max = 1000)
    @Column(name = "lyDoHuy", length = 1000)
    private String lyDoHuy;

    @DecimalMin("0.0")
    @Column(name = "tienPhatHuy", precision = 15, scale = 2)
    private BigDecimal tienPhatHuy = BigDecimal.ZERO;

    @Size(max = 100)
    @Column(name = "nganHangHoanTien", length = 100)
    private String nganHangHoanTien;

    @Size(max = 100)
    @Column(name = "tenChuTaiKhoan", length = 100)
    private String tenChuTaiKhoan;

    @Size(max = 20) @Pattern(regexp = "^$|^[0-9]{6,20}$")
    @Column(name = "soTaiKhoanHoanTien", length = 20)
    private String soTaiKhoanHoanTien;

    @Column(name = "daHoanTien")
    private Boolean daHoanTien = false;

    // --- MỐI QUAN HỆ ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiDung", nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhuyenMai")
    private KhuyenMai khuyenMai;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ChiTietDonHang> chiTietDonHangs;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ThanhToan> thanhToans;

    @OneToMany(mappedBy = "donHang")
    private List<DanhGia> danhGias;
}