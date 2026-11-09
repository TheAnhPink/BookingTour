package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "HanhKhach")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HanhKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer maHanhKhach;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maChiTiet", nullable = false)
    @JsonIgnore
    private ChiTietDonHang chiTietDonHang;

    @Column(nullable = false, length = 100)
    private String hoTen;

    @Column(nullable = false, length = 20)
    private String loaiHanhKhach; // ADULT / CHILD / INFANT

    private LocalDate ngaySinh;

    @Column(length = 10)
    private String gioiTinh;

    @Column(length = 50)
    private String cccdHoChieu;
}