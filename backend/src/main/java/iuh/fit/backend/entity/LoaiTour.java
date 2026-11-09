package iuh.fit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "LoaiTour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LoaiTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLoaiTour;

    @Column(nullable = false, length = 100)
    private String tenLoai;

    private String moTa;

    @OneToMany(mappedBy = "loaiTour")
    private List<Tour> danhSachTour;
}