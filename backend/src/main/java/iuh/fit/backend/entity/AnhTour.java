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

    @NotBlank(message = "Đường dẫn ảnh không được để trống")
    @Size(max = 500, message = "Đường dẫn tối đa 500 ký tự")
    @Pattern(regexp = "(?i)^.+\\.(jpg|jpeg|png|webp)$", message = "Ảnh phải có định dạng hợp lệ (.jpg| .jpeg| .png| .webp)")
    @Column(name = "duongDan", nullable = false, length = 1000)
    private String duongDan;

    @Column(name = "laAnhChinh")
    private Boolean laAnhChinh = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maTour", nullable = false)
    private Tour tour;

    public boolean kiemTraDinhDangAnh() {
        if (this.duongDan == null) return false;
        String lower = this.duongDan.toLowerCase();
        return lower.endsWith(".jpg") || lower.endsWith(".jpeg") || lower.endsWith(".png") || lower.endsWith(".webp");
    }

    public void datLamAnhChinh() {
        this.laAnhChinh = true;
    }
}