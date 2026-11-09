package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "ChiTietDonHang")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maChiTiet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    @JsonIgnore
    private DonHang donHang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maLichKhoiHanh", nullable = false)
    private LichKhoiHanh lichKhoiHanh;

    private Integer soLuongNguoiLon = 0;
    private Integer soLuongTreEm = 0;
    private Integer soLuongEmBe = 0;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaNguoiLon;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaTreEm;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal donGiaEmBe;

    @OneToMany(mappedBy = "chiTietDonHang", cascade = CascadeType.ALL)
    private List<HanhKhach> danhSachHanhKhach;
}