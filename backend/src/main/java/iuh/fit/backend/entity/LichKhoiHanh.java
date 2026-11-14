package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LichKhoiHanh")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LichKhoiHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLichKhoiHanh")
    private Long maLichKhoiHanh;

    @NotNull(message = "Ngày khởi hành không được để trống")
    @Future(message = "Ngày khởi hành phải lớn hơn hiện tại")
    @Column(name = "ngayKhoiHanh", nullable = false)
    private LocalDateTime ngayKhoiHanh;

    @NotNull(message = "Ngày kết thúc không được để trống")
    @Column(name = "ngayKetThuc", nullable = false)
    private LocalDateTime ngayKetThuc;

    @NotNull(message = "Số chỗ tối đa không được để trống")
    @Min(value = 1, message = "Số chỗ tối đa phải lớn hơn 0")
    @Column(name = "soChoToiDa", nullable = false)
    private Integer soChoToiDa;

    @NotNull(message = "Số chỗ còn lại không được để trống")
    @Min(value = 0, message = "Số chỗ còn lại không được âm")
    @Column(name = "soChoConLai", nullable = false)
    private Integer soChoConLai;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", length = 50)
    private TrangThaiLichKhoiHanh trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhachSan", nullable = false)
    private KhachSan khachSan;

    @OneToMany(mappedBy = "lichKhoiHanh")
    private List<ChiTietDonHang> chiTietDonHangs;

    @AssertTrue(message = "Ngày kết thúc phải sau ngày khởi hành")
    public boolean isNgayKetThucHopLe() {
        if (ngayKhoiHanh == null || ngayKetThuc == null) return true;
        return ngayKetThuc.isAfter(ngayKhoiHanh);
    }

    @AssertTrue(message = "Số chỗ còn lại không được vượt quá số chỗ tối đa")
    public boolean isSoChoHopLe() {
        if (soChoToiDa == null || soChoConLai == null) return true;
        return soChoConLai >= 0 && soChoConLai <= soChoToiDa;
    }

    public boolean kiemTraConCho(int soLuongKhach) {
        if (soLuongKhach <= 0) return false;
        return this.soChoConLai >= soLuongKhach && this.trangThai == TrangThaiLichKhoiHanh.DANG_MO_BAN;
    }

    public void giamSoChoConLai(int soLuongDat) {
        if (soLuongDat <= 0 || this.soChoConLai < soLuongDat) {
            throw new IllegalArgumentException("Số chỗ trống còn lại không đủ!");
        }
        this.soChoConLai -= soLuongDat;
        if (this.soChoConLai == 0) {
            this.trangThai = TrangThaiLichKhoiHanh.HET_CHO;
        }
    }

    public void hoanTraSoChoConLai(int soLuongHuy) {
        if (soLuongHuy <= 0) throw new IllegalArgumentException("Số lượng hủy không hợp lệ!");
        this.soChoConLai += soLuongHuy;
        if (this.soChoConLai > this.soChoToiDa) this.soChoConLai = this.soChoToiDa;
        if (this.trangThai == TrangThaiLichKhoiHanh.HET_CHO) this.trangThai = TrangThaiLichKhoiHanh.DANG_MO_BAN;
    }
}