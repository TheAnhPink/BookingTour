package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "KhuyenMai")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhuyenMai")
    private Long maKhuyenMai;

    @NotBlank(message = "Tên chương trình không được để trống")
    @Size(min = 5, max = 150, message = "Tên chương trình từ 5 đến 150 ký tự")
    @Column(name = "tenChuongTrinh", nullable = false, length = 255)
    private String tenChuongTrinh;

    @Size(max = 1000, message = "Mô tả tối đa 1000 ký tự")
    @Column(name = "moTa", length = 2000)
    private String moTa;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Loại giảm giá không được để trống")
    @Column(name = "loaiGiamGia", nullable = false, length = 20)
    private LoaiGiamGia loaiGiamGia;

    @NotNull(message = "Giá trị giảm không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá trị giảm phải lớn hơn 0")
    @Column(name = "giaTriGiam", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTriGiam;

    @DecimalMin(value = "0.0", message = "Giảm tối đa phải >= 0")
    @Column(name = "giamToiDa", precision = 15, scale = 2)
    private BigDecimal giamToiDa;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    @FutureOrPresent(message = "Ngày bắt đầu không được ở quá khứ")
    @Column(name = "ngayBatDau", nullable = false)
    private LocalDateTime ngayBatDau;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @Future(message = "Ngày kết thúc phải ở tương lai")
    @Column(name = "ngayKetThuc", nullable = false)
    private LocalDateTime ngayKetThuc;

    @NotNull(message = "Số lượng tối đa không được để trống")
    @Min(value = 1, message = "Số lượng tối đa phải lớn hơn 0")
    @Column(name = "soLuongToiDa", nullable = false)
    private Integer soLuongToiDa;

    @Min(value = 0, message = "Số lượng đã dùng không được âm")
    @Column(name = "soLuongDaDung")
    private Integer soLuongDaDung = 0;

    @Column(name = "trangThai")
    private Boolean trangThai = true;

    @OneToMany(mappedBy = "khuyenMai")
    private List<DonHang> donHangs;

    @AssertTrue(message = "Giá trị giảm theo phần trăm không được vượt quá 100")
    public boolean isGiaTriGiamHopLe() {
        if (loaiGiamGia == LoaiGiamGia.PHAN_TRAM && giaTriGiam != null) {
            return giaTriGiam.compareTo(new BigDecimal("100")) <= 0;
        }
        return true;
    }

    public boolean kiemTraHieuLuc() {
        LocalDateTime now = LocalDateTime.now();
        return Boolean.TRUE.equals(this.trangThai) && now.isAfter(this.ngayBatDau) && now.isBefore(this.ngayKetThuc)
                && this.soLuongDaDung < this.soLuongToiDa;
    }

    public BigDecimal tinhSoTienGiam(BigDecimal tongTienDonHang) {
        if (!kiemTraHieuLuc() || tongTienDonHang == null) return BigDecimal.ZERO;
        BigDecimal tienGiamThucTe;
        if (this.loaiGiamGia == LoaiGiamGia.PHAN_TRAM) {
            tienGiamThucTe = tongTienDonHang.multiply(this.giaTriGiam).divide(new BigDecimal("100"));
            if (this.giamToiDa != null && tienGiamThucTe.compareTo(this.giamToiDa) > 0) {
                tienGiamThucTe = this.giamToiDa;
            }
        } else {
            tienGiamThucTe = this.giaTriGiam.min(tongTienDonHang);
        }
        return tienGiamThucTe;
    }
}