package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "LichTrinhTour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LichTrinhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLichTrinh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    @JsonIgnore
    private Tour tour;

    @Column(nullable = false)
    private Integer ngayThu;

    @Column(nullable = false, length = 255)
    private String tieuDe;

    private String noiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maKhachSan")
    private KhachSan khachSan;
}