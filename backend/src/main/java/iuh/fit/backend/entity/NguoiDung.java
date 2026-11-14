package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="NguoiDung")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maNguoiDung")
    private Long maNguoiDung;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 2, max = 100, message = "Họ tên phải từ 2 đến 100 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Họ tên chỉ được chứa chữ và khoảng trắng")
    @Column(name = "hoTen", nullable = false, length = 255)
    private String hoTen;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không đúng định dạng")
    @Size(max = 100, message = "Email tối đa 100 ký tự")
    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 8, max = 100, message = "Mật khẩu phải từ 8 đến 100 ký tự")
    @Column(name = "matKhau", nullable = false, length = 255)
    private String matKhau;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^0[0-9]{9}$", message = "SĐT phải gồm 10 số và bắt đầu bằng 0")
    @Size(max = 15, message = "SĐT tối đa 15 ký tự")
    @Column(name = "soDienThoai", unique = true, nullable = false, length = 20)
    private String soDienThoai;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải trước ngày hiện tại")
    @Column(name = "ngaySinh", nullable = false)
    private LocalDate ngaySinh;

    @NotBlank(message = "CCCD/Hộ chiếu không được để trống")
    @Pattern(regexp = "^[0-9]{12}$|^[A-Z][0-9]{7,8}$", message = "CCCD 12 số hoặc Hộ chiếu không đúng định dạng")
    @Size(max = 15, message = "CCCD/Hộ chiếu tối đa 15 ký tự")
    @Column(name = "cccdHoChieu", nullable = false, length = 20)
    private String cccdHoChieu;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Vai trò không được để trống")
    @Column(name = "vaiTro", nullable = false, length = 20)
    private VaiTro vaiTro;

    @Column(name = "trangThai")
    private boolean trangThai = true;

    @CreationTimestamp
    @Column(name = "ngayTao", updatable = false)
    private LocalDate ngayTao;

    @AssertTrue(message = "Người dùng phải từ đủ 18 tuổi trở lên")
    public boolean isDu18Tuoi() {
        if (ngaySinh == null) return true;
        return java.time.Period.between(ngaySinh, LocalDate.now()).getYears() >= 18;
    }

    public boolean kiemTraDaDuTuoiKhiDatVe() {
        if (ngaySinh == null) return false;
        return Period.between(ngaySinh, LocalDate.now()).getYears() >= 18;
    }
}