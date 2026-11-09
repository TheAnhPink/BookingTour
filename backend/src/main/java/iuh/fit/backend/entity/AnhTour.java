package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "AnhTour")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AnhTour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maAnh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    @JsonIgnore // Tránh vòng lặp vô hạn khi trả JSON
    private Tour tour;

    @Column(nullable = false)
    private String duongDan;

    private Boolean laAnhChinh = (Boolean) false;
}