package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "HanhKhach")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HanhKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHanhKhach")
    private Long maHanhKhach;

    @NotBlank @Size(min = 2, max = 100)
    @Pattern(regexp = "^[\\p{L}\\s]+$")
    @Column(name = "hoTen", nullable = false, length = 100)
    private String hoTen;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "loaiHanhKhach", nullable = false, length = 20)
    private LoaiHanhKhach loaiHanhKhach;

    @NotNull @Past
    @Column(name = "ngaySinh", nullable = false)
    private LocalDate ngaySinh;

    @NotBlank @Size(max = 10)
    @Pattern(regexp = "^(Nam|Nữ|Khác)$")
    @Column(name = "gioiTinh", nullable = false, length = 10)
    private String gioiTinh;

    @Size(max = 15) @Pattern(regexp = "^$|^[0-9]{12}$|^[A-Z][0-9]{7,8}$")
    @Column(name = "cccdHoChieu", length = 15)
    private String cccdHoChieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maChiTiet", nullable = false)
    private ChiTietDonHang chiTietDonHang;
}