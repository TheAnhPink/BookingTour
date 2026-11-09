package iuh.fit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "KhuyenMai")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KhuyenMai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhuyenMai;

    @Column(nullable = false, unique = true, length = 50)
    private String maCode;

    @Column(nullable = false, length = 255)
    private String tenChuongTrinh;

    private String moTa;

    @Column(nullable = false, length = 20)
    private String loaiGiamGia; // PERCENT / FIXED_AMOUNT

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal giaTriGiam;

    @Column(precision = 15, scale = 2)
    private BigDecimal giamToiDa;

    @Column(nullable = false)
    private LocalDateTime ngayBatDau;

    @Column(nullable = false)
    private LocalDateTime ngayKetThuc;

    private Integer soLuongToiDa;
    private Integer soLuongDaDung = 0;
    private Boolean trangThai = true;
}