package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Tour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maTour")
    private Long maTour;

    @NotBlank(message = "Tên tour không được để trống")
    @Size(min = 5, max = 200, message = "Tên tour từ 5 đến 200 ký tự")
    @Column(name = "tenTour", nullable = false, length = 255)
    private String tenTour;

    @Size(max = 4000, message = "Mô tả tối đa 4000 ký tự")
    @Column(name = "moTa", columnDefinition = "TEXT")
    private String moTa;

    @NotBlank(message = "Thời lượng không được để trống")
    @Size(max = 50, message = "Thời lượng tối đa 50 ký tự")
    @Column(name = "thoiLuong", length = 100)
    private String thoiLuong;

    @NotBlank(message = "Phương tiện không được để trống")
    @Size(max = 100, message = "Phương tiện tối đa 100 ký tự")
    @Column(name = "phuongTien", length = 255)
    private String phuongTien;

    @Size(max = 100, message = "Tiêu chuẩn lưu trú tối đa 100 ký tự")
    @Column(name = "tieuChuanLuuTru", length = 255)
    private String tieuChuanLuuTru;

    @NotNull(message = "Giá người lớn không được để trống")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá người lớn phải lớn hơn 0")
    @Column(name = "giaNguoiLon", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaNguoiLon;

    @NotNull(message = "Giá trẻ em không được để trống")
    @DecimalMin(value = "0.0", message = "Giá trẻ em phải >= 0")
    @Column(name = "giaTreEm", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTreEm;

    @NotNull(message = "Giá em bé không được để trống")
    @DecimalMin(value = "0.0", message = "Giá em bé phải >= 0")
    @Column(name = "giaEmBe", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaEmBe;

    @Size(max = 100, message = "Phong cách tối đa 100 ký tự")
    @Column(name = "phongCach", length = 255)
    private String phongCach;

    @Min(value = 1, message = "Mức độ vận động từ 1 đến 5") @Max(value = 5, message = "Mức độ vận động từ 1 đến 5")
    @Column(name = "mucDoVanDong")
    private Integer mucDoVanDong;

    @NotBlank(message = "Hình ảnh chính không được để trống")
    @Size(max = 500, message = "Đường dẫn ảnh tối đa 500 ký tự")
    @Pattern(regexp = "(?i)^.+\\.(jpg|jpeg|png|webp|gif)$", message = "Định dạng ảnh không hợp lệ")
    @Column(name = "hinhAnhChinh", length = 1000)
    private String hinhAnhChinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", length = 20)
    private TrangThaiTour trangThai;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLoaiTour", nullable = false)
    private LoaiTour loaiTour;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LichTrinhTour> lichTrinhTours;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AnhTour> anhTours;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LichKhoiHanh> lichKhoiHanhs;

    @OneToMany(mappedBy = "tour")
    private List<DanhGia> danhGias;

    public BigDecimal tinhGiaVeTreEmTuDong() {
        if (giaNguoiLon == null) return BigDecimal.ZERO;
        return giaNguoiLon.multiply(new BigDecimal("0.75"));
    }

    public BigDecimal tinhGiaVeEmBeTuDong() {
        if (giaNguoiLon == null) return BigDecimal.ZERO;
        return giaNguoiLon.multiply(new BigDecimal("0.25"));
    }

    public boolean kiemTraCoTheMoBan() {
        return this.trangThai == TrangThaiTour.HOAT_DONG && this.giaNguoiLon != null && this.loaiTour != null;
    }

    public void capNhatBangGia(BigDecimal giaNguoiLonMoi, BigDecimal giaTreEmMoi, BigDecimal giaEmBeMoi) {
        if (giaNguoiLonMoi == null || giaNguoiLonMoi.compareTo(BigDecimal.ZERO) <= 0 ||
                giaTreEmMoi == null || giaTreEmMoi.compareTo(BigDecimal.ZERO) < 0 ||
                giaEmBeMoi == null || giaEmBeMoi.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Mức giá mới cập nhật không hợp lệ!");
        }
        this.giaNguoiLon = giaNguoiLonMoi;
        this.giaTreEm = giaTreEmMoi;
        this.giaEmBe = giaEmBeMoi;
    }
}