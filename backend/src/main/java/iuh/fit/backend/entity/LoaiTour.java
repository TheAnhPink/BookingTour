package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "LoaiTour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLoaiTour")
    private Long maLoaiTour;

    @NotBlank(message = "Tên loại tour không được để trống")
    @Size(min = 3, max = 100, message = "Tên loại tour phải từ 3 đến 100 ký tự")
    @Column(name = "tenLoai", nullable = false, length = 255)
    private String tenLoai;

    @Size(max = 1000, message = "Mô tả tối đa 1000 ký tự")
    @Column(name = "moTa", length = 2000)
    private String moTa;

    @OneToMany(mappedBy = "loaiTour")
    private List<Tour> tours;

    public boolean kiemTraLoaiTourHopLe() {
        return this.tenLoai != null && this.tenLoai.trim().length() >= 3 && this.tenLoai.length() <= 100;
    }

    public String hienThiThongTinLoaiTour() {
        return this.tenLoai + (this.moTa != null ? " - " + this.moTa : "");
    }
}