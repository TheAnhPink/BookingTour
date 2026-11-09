package iuh.fit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Tour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maTour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLoaiTour", nullable = false)
    private LoaiTour loaiTour;

    @Column(nullable = false, length = 255)
    private String tenTour;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String moTa;

    @Column(length = 50)
    private String thoiLuong;

    @Column(length = 100)
    private String phuongTien;

    @Column(length = 100)
    private String tieuChuanLuuTru;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal giaNguoiLon;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTreEm;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal giaEmBe;

    @Column(length = 100)
    private String phongCach;

    private Integer mucDoVanDong = 1;

    private String hinhAnhChinh;

    @Column(length = 20)
    private String trangThai = "ACTIVE";

    // Các mối quan hệ
    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<AnhTour> danhSachAnh;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<LichKhoiHanh> danhSachLichKhoiHanh;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<LichTrinhTour> danhSachLichTrinh;

    @OneToMany(mappedBy = "tour")
    private List<DanhGia> danhSachDanhGia;
}