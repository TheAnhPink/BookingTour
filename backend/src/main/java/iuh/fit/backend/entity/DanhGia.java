package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "DanhGia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DanhGia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maDanhGia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maNguoiDung", nullable = false)
    private NguoiDung nguoiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    @JsonIgnore
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maDonHang", nullable = false)
    @JsonIgnore
    private DonHang donHang;

    @Column(nullable = false)
    private Integer soSao;

    private String binhLuan;

    private LocalDateTime ngayTao = LocalDateTime.now();
}