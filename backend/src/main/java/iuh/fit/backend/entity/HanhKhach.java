package iuh.fit.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "HanhKhach")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class HanhKhach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maHanhKhach")
    private Long maHanhKhach;

    @NotBlank(message = "Họ tên không được để trống")
    @Size(min = 2, max = 100, message = "Họ tên từ 2 đến 100 ký tự")
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Họ tên chỉ chứa chữ và khoảng trắng")
    @Column(name = "hoTen", nullable = false, length = 255)
    private String hoTen;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Loại hành khách không được để trống")
    @Column(name = "loaiHanhKhach", nullable = false, length = 20)
    private LoaiHanhKhach loaiHanhKhach;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải trong quá khứ")
    @Column(name = "ngaySinh", nullable = false)
    private LocalDate ngaySinh;

    @NotBlank(message = "Giới tính không được để trống")
    @Size(max = 10, message = "Giới tính tối đa 10 ký tự")
    @Pattern(regexp = "^(Nam|Nữ|Khác)$", message = "Giới tính phải là Nam, Nữ hoặc Khác")
    @Column(name = "gioiTinh", nullable = false, length = 50)
    private String gioiTinh;

    @Size(max = 15, message = "CCCD/Hộ chiếu tối đa 15 ký tự")
    @Pattern(regexp = "^$|^[0-9]{12}$|^[A-Z][0-9]{7,8}$", message = "CCCD 12 số hoặc Hộ chiếu không đúng định dạng")
    @Column(name = "cccdHoChieu", length = 50)
    private String cccdHoChieu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maChiTiet", nullable = false)
    private ChiTietDonHang chiTietDonHang;

    public LoaiHanhKhach tudongXacDinhLoaiHanhKhach() {
        if (this.ngaySinh == null) return LoaiHanhKhach.NGUOI_LON;
        int soTuoi = Period.between(this.ngaySinh, LocalDate.now()).getYears();
        if (soTuoi >= 11) return LoaiHanhKhach.NGUOI_LON;
        else if (soTuoi >= 5) return LoaiHanhKhach.TRE_EM;
        else return LoaiHanhKhach.EM_BE;
    }
}