package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "AnhTour")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class AnhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maAnh")
    private Long maAnh;

    @NotBlank @Size(max = 500)
    @Pattern(regexp = "(?i)^.+\\.(jpg|jpeg|png|webp)$")
    @Column(name = "duongDan", nullable = false, length = 500)
    private String duongDan;

    @Column(name = "laAnhChinh")
    private Boolean laAnhChinh = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;
}