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

    @NotNull @Future
    @Column(name = "ngayKhoiHanh", nullable = false)
    private LocalDateTime ngayKhoiHanh;

    @NotNull
    @Column(name = "ngayKetThuc", nullable = false)
    private LocalDateTime ngayKetThuc;

    @NotNull @Min(1)
    @Column(name = "soChoToiDa", nullable = false)
    private Integer soChoToiDa;

    @NotNull @Min(0)
    @Column(name = "soChoConLai", nullable = false)
    private Integer soChoConLai;

    @Enumerated(EnumType.STRING)
    @Column(name = "trangThai", length = 50)
    private TrangThaiLichKhoiHanh trangThai;

    // --- MỐI QUAN HỆ ---
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;

    // THÊM MỚI: Lịch khởi hành này ở khách sạn nào
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
}