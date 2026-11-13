package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "LichTrinhTour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LichTrinhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maLichTrinh")
    private Long maLichTrinh;

    @NotNull @Min(1)
    @Column(name = "ngayThu", nullable = false)
    private Integer ngayThu;

    @NotBlank @Size(min = 5, max = 255)
    @Column(name = "tieuDe", nullable = false, length = 255)
    private String tieuDe;

    @NotBlank @Size(max = 4000)
    @Column(name = "noiDung", nullable = false, length = 4000)
    private String noiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;
}