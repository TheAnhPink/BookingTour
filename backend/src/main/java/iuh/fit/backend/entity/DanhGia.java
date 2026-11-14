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

    @NotNull(message = "Số sao không được để trống")
    @Min(value = 1, message = "Số sao từ 1 đến 5") @Max(value = 5, message = "Số sao từ 1 đến 5")
    @Column(name = "soSao", nullable = false)
    private Integer soSao;

    @Size(max = 1000, message = "Bình luận tối đa 1000 ký tự")
    @Column(name = "binhLuan", length = 2000)
    private String binhLuan;

    @PastOrPresent(message = "Ngày tạo không được lớn hơn hiện tại")
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

    public String chuanHoaBinhLuan() {
        if (this.binhLuan == null) return "";
        return this.binhLuan.trim().replaceAll("\\s+", " ");
    }
}