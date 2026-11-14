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

    @NotNull(message = "Số lượng người lớn không được để trống")
    @Min(value = 0, message = "Số lượng người lớn không được âm")
    @Column(name = "soLuongNguoiLon", nullable = false)
    private Integer soLuongNguoiLon;

    @NotNull(message = "Số lượng trẻ em không được để trống")
    @Min(value = 0, message = "Số lượng trẻ em không được âm")
    @Column(name = "soLuongTreEm", nullable = false)
    private Integer soLuongTreEm;

    @NotNull(message = "Số lượng em bé không được để trống")
    @Min(value = 0, message = "Số lượng em bé không được âm")
    @Column(name = "soLuongEmBe", nullable = false)
    private Integer soLuongEmBe;

    @NotNull(message = "Đơn giá người lớn không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Đơn giá người lớn phải > 0")
    @Column(name = "donGiaNguoiLon", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaNguoiLon;

    @NotNull(message = "Đơn giá trẻ em không được để trống")
    @DecimalMin(value = "0.0", message = "Đơn giá trẻ em phải >= 0")
    @Column(name = "donGiaTreEm", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaTreEm;

    @NotNull(message = "Đơn giá em bé không được để trống")
    @DecimalMin(value = "0.0", message = "Đơn giá em bé phải >= 0")
    @Column(name = "donGiaEmBe", nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaEmBe;

    @Size(max = 500, message = "Ghi chú tối đa 500 ký tự")
    @Column(name = "ghiChu", length = 1000)
    private String ghiChu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLichKhoiHanh", nullable = false)
    private LichKhoiHanh lichKhoiHanh;

    @OneToMany(mappedBy = "chiTietDonHang", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HanhKhach> hanhKhachs;

    public BigDecimal tinhTongTienChiTiet() {
        BigDecimal tong = BigDecimal.ZERO;
        if (soLuongNguoiLon > 0 && donGiaNguoiLon != null) tong = tong.add(donGiaNguoiLon.multiply(new BigDecimal(soLuongNguoiLon)));
        if (soLuongTreEm > 0 && donGiaTreEm != null) tong = tong.add(donGiaTreEm.multiply(new BigDecimal(soLuongTreEm)));
        if (soLuongEmBe > 0 && donGiaEmBe != null) tong = tong.add(donGiaEmBe.multiply(new BigDecimal(soLuongEmBe)));
        return tong;
    }

    public int tinhTongSoLuongHanhKhach() {
        return this.soLuongNguoiLon + this.soLuongTreEm + this.soLuongEmBe;
    }

    public boolean kiemTraKhaNangDatCho() {
        if (this.lichKhoiHanh == null) return false;
        int tongSoKhach = tinhTongSoLuongHanhKhach();
        return tongSoKhach > 0 && this.lichKhoiHanh.kiemTraConCho(tongSoKhach);
    }
}