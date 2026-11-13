package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "DanhGia")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maDanhGia")
    private Long maDanhGia;

    @NotNull @Min(1) @Max(5)
    @Column(name = "soSao", nullable = false)
    private Integer soSao;

    @Size(max = 1000)
    @Column(name = "binhLuan", length = 1000)
    private String binhLuan;

    @PastOrPresent
    @Column(name = "ngayTao")
    private LocalDate ngayTao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiDung", nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    private DonHang donHang;
}