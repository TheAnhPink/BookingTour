package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    @NotNull(message = "Tổng tiền không được để trống")
    @DecimalMin(value = "0.0", message = "Tổng tiền phải >= 0")
    @Column(name = "tongTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal tongTien;

    @DecimalMin(value = "0.0", message = "Tiền giảm phải >= 0")
    @Column(name = "tienGiam", precision = 15, scale = 2)
    private BigDecimal tienGiam = BigDecimal.ZERO;

    @NotNull(message = "Thành tiền không được để trống")
    @DecimalMin(value = "0.0", message = "Thành tiền phải >= 0")
    @Column(name = "thanhTien", nullable = false, precision = 15, scale = 2)
    private BigDecimal thanhTien;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "trangThai", nullable = false, length = 50)
    private TrangThaiDonHang trangThai;

    @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
    @Column(name = "ghiChu", length = 1000)
    private String ghiChu;

    @Column(name = "ngayHuy")
    private LocalDateTime ngayHuy;

    @Size(max = 1000, message = "Lý do hủy tối đa 1000 ký tự")
    @Column(name = "lyDoHuy", length = 2000)
    private String lyDoHuy;

    @DecimalMin(value = "0.0", message = "Tiền phạt hủy phải >= 0")
    @Column(name = "tienPhatHuy", precision = 15, scale = 2)
    private BigDecimal tienPhatHuy = BigDecimal.ZERO;

    @Size(max = 100, message = "Tên ngân hàng tối đa 100 ký tự")
    @Column(name = "nganHangHoanTien", length = 255)
    private String nganHangHoanTien;

    @Size(max = 100, message = "Tên chủ tài khoản tối đa 100 ký tự")
    @Column(name = "tenChuTaiKhoan", length = 255)
    private String tenChuTaiKhoan;

    @Size(max = 20, message = "Số tài khoản từ 6-20 số")
    @Pattern(regexp = "^$|^[0-9]{6,20}$", message = "Số tài khoản không hợp lệ")
    @Column(name = "soTaiKhoanHoanTien", length = 50)
    private String soTaiKhoanHoanTien;

    @Column(name = "daHoanTien")
    private Boolean daHoanTien = false;

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

    public BigDecimal tinhThanhTien(BigDecimal tongTienChiTiet, boolean laKhachHangThanThiet) {
        BigDecimal giamGiaThanThiet = BigDecimal.ZERO;
        if (laKhachHangThanThiet) {
            giamGiaThanThiet = tongTienChiTiet.multiply(new BigDecimal("0.03"));
        }
        BigDecimal tongGiam = giamGiaThanThiet.add(this.tienGiam != null ? this.tienGiam : BigDecimal.ZERO);
        this.tienGiam = tongGiam;
        this.tongTien = tongTienChiTiet;
        BigDecimal thanhTien = tongTienChiTiet.subtract(tongGiam);
        this.thanhTien = thanhTien.max(BigDecimal.ZERO);
        return this.thanhTien;
    }

    public BigDecimal tinhPhiHuyTour(LocalDate ngayKhoiHanh) {
        if (this.ngayHuy == null || this.thanhTien == null || ngayKhoiHanh == null) return BigDecimal.ZERO;
        long soNgay = ChronoUnit.DAYS.between(this.ngayHuy.toLocalDate(), ngayKhoiHanh);
        if (soNgay >= 30) return BigDecimal.ZERO;
        else if (soNgay >= 15) return this.thanhTien.multiply(new BigDecimal("0.5"));
        else return this.thanhTien;
    }
}