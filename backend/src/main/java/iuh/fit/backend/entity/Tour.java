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

    @NotBlank @Size(min = 5, max = 200)
    @Column(name = "tenTour", nullable = false, length = 200)
    private String tenTour;

    @Size(max = 4000)
    @Column(name = "moTa", length = 4000)
    private String moTa;

    @NotBlank @Size(max = 50)
    @Column(name = "thoiLuong", length = 50)
    private String thoiLuong;

    @NotBlank @Size(max = 100)
    @Column(name = "phuongTien", length = 100)
    private String phuongTien;

    @Size(max = 100)
    @Column(name = "tieuChuanLuuTru", length = 100)
    private String tieuChuanLuuTru;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "giaNguoiLon", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaNguoiLon;

    @NotNull @DecimalMin("0.0")
    @Column(name = "giaTreEm", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTreEm;

    @NotNull @DecimalMin("0.0")
    @Column(name = "giaEmBe", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaEmBe;

    @Size(max = 100)
    @Column(name = "phongCach", length = 100)
    private String phongCach;

    @Min(1) @Max(5)
    @Column(name = "mucDoVanDong")
    private Integer mucDoVanDong;

    @NotBlank @Size(max = 500)
    @Pattern(regexp = "(?i)^.+\\.(jpg|jpeg|png|webp|gif)$")
    @Column(name = "hinhAnhChinh", length = 500)
    private String hinhAnhChinh;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", length = 20)
    private TrangThaiTour trangThai;

    // --- MỐI QUAN HỆ ---
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
}