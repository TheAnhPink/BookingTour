package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="LoaiTour")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maLoaiTour;

    @NotBlank(message = "Tên loại tour không được để trống")
    @Size(min = 3, max=100, message = "Tên loại tour phải từ 3 đến 100 ký tự")
    @Column(nullable = false, length = 100)
    private String tenLoai;

    @Size(max = 1000, message = "Mô tả tối đa 1000 ký tự")
    @Column(length = 1000)
    private String moTa;

    @OneToMany(mappedBy = "loaiTour")
    private List<Tour> tours;
}
