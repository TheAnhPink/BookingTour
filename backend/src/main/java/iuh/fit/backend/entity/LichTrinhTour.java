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

    @NotNull(message = "Ngày thứ không được để trống")
    @Min(value = 1, message = "Ngày thứ phải lớn hơn 0")
    @Column(name = "ngayThu", nullable = false)
    private Integer ngayThu;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(min = 5, max = 255, message = "Tiêu đề từ 5 đến 255 ký tự")
    @Column(name = "tieuDe", nullable = false, length = 500)
    private String tieuDe;

    @NotBlank(message = "Nội dung không được để trống")
    @Size(max = 4000, message = "Nội dung tối đa 4000 ký tự")
    @Column(name = "noiDung", nullable = false, columnDefinition = "TEXT")
    private String noiDung;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;

    public boolean kiemTraLichTrinhHopLe() {
        return this.ngayThu != null && this.ngayThu > 0 && this.tieuDe != null && !this.tieuDe.trim().isEmpty()
                && this.noiDung != null && !this.noiDung.trim().isEmpty() && this.tour != null;
    }

    public String hienThiChiTietNgay() {
        return "Ngày " + this.ngayThu + ": " + this.tieuDe + "\n" + this.noiDung;
    }
}