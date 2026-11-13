package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="NguoiDung")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNguoiDung;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 2, max = 100, message = "Họ tên phải từ 2 đến 100 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$",message = "Họ tên chỉ được chứa chữ và khoảng trắng")
    @Column(nullable = false, length = 100)
    private String hoTen;

    @NotBlank(message = "Email không được để trống")
    @Column(nullable = false, unique = true)
    @Email(message = "Email không đúng định dạng")
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Column(nullable = false)
    @Size(min = 8, message = "Mật khẩu phải từ 8 ký tự trở lên")
    private String matKhau;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^0[0-9]{9}$", message = "SĐT phải gồm 10 số và bắt đầu bằng 0")
    @Column(unique = true, length = 20, nullable = false)
    private String soDienThoai;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải trước ngày hiện tại")
    private LocalDate ngaySinh;

    @NotBlank(message = "CCCD/Hộ chiếu không được để trống")
    @Pattern(regexp = "^[0-9]{12}$|^[A-Z][0-9]{7,8}$", message = "CCCD 12 số hoặc Hộ chiếu không đúng định dạng")
    @Column(nullable = false,length = 20)
    private String cccdHoChieu;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull
    private VaiTro vaiTro;

    private boolean trangThai=true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDate ngayTao;


    @AssertTrue(message = "Người dùng phải từ đủ 18 tuổi trở lên")
    public boolean isDu18Tuoi() {
        if (ngaySinh == null) return true;
        return java.time.Period.between(ngaySinh, LocalDate.now()).getYears() >= 18;
    }
}
