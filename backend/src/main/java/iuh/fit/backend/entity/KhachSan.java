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

    @NotBlank(message = "Tên khách sạn không được để trống")
    @Size(min = 3, max = 150, message = "Tên khách sạn từ 3 đến 150 ký tự")
    @Column(name = "tenKhachSan", nullable = false, length = 255)
    private String tenKhachSan;

    @NotBlank(message = "Địa chỉ không được để trống")
    @Size(min = 5, max = 255, message = "Địa chỉ từ 5 đến 255 ký tự")
    @Column(name = "diaChi", nullable = false, length = 500)
    private String diaChi;

    @NotNull(message = "Hạng sao không được để trống")
    @Min(value = 1, message = "Hạng sao từ 1 đến 5")
    @Max(value = 5, message = "Hạng sao từ 1 đến 5")
    @Column(name = "hangSao", nullable = false)
    private Integer hangSao;

    @Pattern(regexp = "^0[0-9]{9}$", message = "SĐT phải gồm 10 số và bắt đầu bằng 0")
    @Size(max = 15, message = "SĐT tối đa 15 ký tự")
    @Column(name = "soDienThoai", length = 20)
    private String soDienThoai;

    @OneToMany(mappedBy = "khachSan")
    private List<LichKhoiHanh> lichKhoiHanhs;

    public boolean kiemTraKhachSanCaoCap() {
        return this.hangSao != null && this.hangSao >= 4;
    }

    public String hienThiThongTinLienHe() {
        return this.tenKhachSan + " (" + this.hangSao + " sao) - " + this.diaChi + " - SĐT: " + (this.soDienThoai != null ? this.soDienThoai : "Chưa cập nhật");
    }
}