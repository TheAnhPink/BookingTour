package iuh.fit.backend.controller.publics;

import iuh.fit.backend.dto.response.ChiTietTourDTO;
import iuh.fit.backend.dto.response.TourDTO;
import iuh.fit.backend.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/tour")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity<Page<TourDTO>> getAndFindTour(
            @RequestParam(value = "tenTim", required = false) String tenTim,
            // ko truyền value thì Spring tự lấy maLoaiTim ở sau đưa vào value
            @RequestParam(required = false) Long maLoaiTim,
            @RequestParam(required = false) BigDecimal giaMin,
            @RequestParam(required = false) BigDecimal giaMax,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate ngayKH,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate ngayKT,

            @RequestParam(defaultValue = "0") int trang,
            @RequestParam(defaultValue = "10") int size
            ){
        Page<TourDTO> dsTour= tourService.getTours(tenTim,maLoaiTim,giaMin,giaMax,ngayKH,ngayKT,trang,size);
        return ResponseEntity.ok(dsTour);
    }

    @GetMapping("/{maTour}")
    public ResponseEntity<?> getThongTinTour(@PathVariable Long maTour){
        try {
            ChiTietTourDTO dto= tourService.getChiTietTour(maTour);
            return ResponseEntity.ok(dto);
        } catch (RuntimeException e) {
            // có bắt lỗi trong service nên đây tạo try catch để hiển thị
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
