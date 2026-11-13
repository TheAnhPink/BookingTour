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

    @NotBlank @Size(min = 5, max = 150)
    @Column(name = "tenChuongTrinh", nullable = false, length = 150)
    private String tenChuongTrinh;

    @Size(max = 1000)
    @Column(name = "moTa", length = 1000)
    private String moTa;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "loaiGiamGia", nullable = false, length = 20)
    private LoaiGiamGia loaiGiamGia;

    @NotNull @DecimalMin(value = "0.0", inclusive = false)
    @Column(name = "giaTriGiam", nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTriGiam;

    @DecimalMin(value = "0.0")
    @Column(name = "giamToiDa", precision = 15, scale = 2)
    private BigDecimal giamToiDa;

    @NotNull @FutureOrPresent
    @Column(name = "ngayBatDau", nullable = false)
    private LocalDateTime ngayBatDau;

    @NotNull @Future
    @Column(name = "ngayKetThuc", nullable = false)
    private LocalDateTime ngayKetThuc;

    @NotNull @Min(1)
    @Column(name = "soLuongToiDa", nullable = false)
    private Integer soLuongToiDa;

    @Min(0)
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
}