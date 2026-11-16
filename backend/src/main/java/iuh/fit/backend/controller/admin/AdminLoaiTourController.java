package iuh.fit.backend.controller.admin;

import iuh.fit.backend.entity.LoaiTour;
import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.service.LoaiTourService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/loai-tour")
public class AdminLoaiTourController {
    private final LoaiTourService loaiTourService;

    public AdminLoaiTourController(LoaiTourService loaiTourService) {
        this.loaiTourService = loaiTourService;
    }

    @PostMapping
    public ResponseEntity<LoaiTour> themLoaiTour(@Valid @RequestBody LoaiTour loaiTourMoi){
        LoaiTour lt= loaiTourService.save(loaiTourMoi);
        return ResponseEntity.status(HttpStatus.CREATED).body(loaiTourMoi);
    }

    @PutMapping("/{maLoaiTour}")
    public ResponseEntity<LoaiTour> capNhatLoaiTour(@Valid @RequestBody LoaiTour loaiTourMoi,
                                                    @PathVariable Long maLoaiTour){
        loaiTourMoi.setMaLoaiTour(maLoaiTour);
        LoaiTour loaiTour= loaiTourService.save(loaiTourMoi);
        return ResponseEntity.ok(loaiTour);
    }

    @DeleteMapping("/{maLoaiTour}")
    public ResponseEntity<String> xoaLoaiTour(@PathVariable Long maLoaiTour){
        loaiTourService.delete(maLoaiTour);
        return ResponseEntity.ok("Xóa thành công loại tour: "+ maLoaiTour);
    }
}
