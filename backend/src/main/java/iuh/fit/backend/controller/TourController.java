package iuh.fit.backend.controller;

import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.service.TourService;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.time.LocalDate;
@Controller
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public ResponseEntity<Page<Tour>> getTours(
            @RequestParam(required = false) String tenTim,
            @RequestParam(required = false) Long maLoaiTim,
            @RequestParam(required = false) BigDecimal giaMin,
            @RequestParam(required = false) BigDecimal giaMax,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayKH,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate ngayKT,
            @RequestParam(defaultValue = "0") int trang,
            @RequestParam(defaultValue = "10") int size) {

        Page<Tour> result = tourService.getTours(tenTim, maLoaiTim, giaMin, giaMax, ngayKH, ngayKT, trang, size);
        return ResponseEntity.ok(result);
    }
}
