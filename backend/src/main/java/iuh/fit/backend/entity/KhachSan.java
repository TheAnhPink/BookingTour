package iuh.fit.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "KhachSan")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class KhachSan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maKhachSan;

    @Column(nullable = false, length = 200)
    private String tenKhachSan;

    @Column(nullable = false, length = 255)
    private String diaChi;

    private Integer hangSao;

    @Column(length = 20)
    private String soDienThoai;

    @OneToMany(mappedBy = "khachSan")
    private List<LichTrinhTour> danhSachLichTrinh;
}