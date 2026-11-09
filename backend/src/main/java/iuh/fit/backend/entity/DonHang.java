package iuh.fit.backend.entity;

import jakarta.persistence.*;
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
    private Integer maDonHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiDung", nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhuyenMai")
    private KhuyenMai khuyenMai;

    private LocalDateTime ngayDat = LocalDateTime.now();

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal tongTien;

    @Column(precision = 15, scale = 2)
    private BigDecimal tienGiam = BigDecimal.ZERO;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal thanhTien;

    @Column(length = 50)
    private String trangThai = "PENDING";

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String ghiChu;

    // Thuộc tính hủy tour
    private LocalDateTime ngayHuy;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String lyDoHuy;
    @Column(precision = 15, scale = 2)
    private BigDecimal tienPhatHuy = BigDecimal.ZERO;

    // Mối quan hệ
    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ChiTietDonHang> danhSachChiTiet;

    @OneToMany(mappedBy = "donHang", cascade = CascadeType.ALL)
    private List<ThanhToan> danhSachThanhToan;
}