package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "KhachSan")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class KhachSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maKhachSan")
    private Long maKhachSan;

    @NotBlank @Size(min = 3, max = 150)
    @Column(name = "tenKhachSan", nullable = false, length = 150)
    private String tenKhachSan;

    @NotBlank @Size(min = 5, max = 255)
    @Column(name = "diaChi", nullable = false, length = 255)
    private String diaChi;

    @NotNull @Min(1) @Max(5)
    @Column(name = "hangSao", nullable = false)
    private Integer hangSao;

    @Pattern(regexp = "^0[0-9]{9}$")
    @Column(name = "soDienThoai", length = 15)
    private String soDienThoai;

    @OneToMany(mappedBy = "khachSan")
    private List<LichKhoiHanh> lichKhoiHanhs;
}