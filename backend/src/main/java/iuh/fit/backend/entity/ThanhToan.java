package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ThanhToan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maThanhToan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    @JsonIgnore
    private DonHang donHang;

    @Column(nullable = false, length = 50)
    private String phuongThuc; // VNPAY / MOMO / BANK_TRANSFER

    @Column(length = 100)
    private String maGiaoDich;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal soTien;

    @Column(nullable = false, length = 50)
    private String trangThai;

    private LocalDateTime thoiGian = LocalDateTime.now();
}