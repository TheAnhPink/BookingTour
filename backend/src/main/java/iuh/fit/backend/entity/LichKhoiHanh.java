package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "LichKhoiHanh")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class LichKhoiHanh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maLichKhoiHanh;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    @JsonIgnore
    private Tour tour;

    @Column(nullable = false)
    private LocalDateTime ngayKhoiHanh;

    @Column(nullable = false)
    private LocalDateTime ngayKetThuc;

    @Column(nullable = false)
    private Integer soChoToiDa;

    @Column(nullable = false)
    private Integer soChoConLai;

    @Column(length = 20)
    private String trangThai = "OPEN";

    @OneToMany(mappedBy = "lichKhoiHanh")
    private List<ChiTietDonHang> danhSachChiTietDonHang;
}