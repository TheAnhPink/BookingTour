package iuh.fit.backend.controller.admin;

import iuh.fit.backend.entity.KhuyenMai;
import iuh.fit.backend.service.KhuyenMaiService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/khuyen-mai")
public class AdminKhuyenMaiController {
    private final KhuyenMaiService khuyenMaiService;

    public AdminKhuyenMaiController(KhuyenMaiService khuyenMaiService) {
        this.khuyenMaiService = khuyenMaiService;
    }

    @PostMapping
    public ResponseEntity<KhuyenMai> themKhuyenMai(@Valid @RequestBody KhuyenMai km) {
        KhuyenMai saved = khuyenMaiService.save(km);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{maKhuyenMai}")
    public ResponseEntity<KhuyenMai> capNhatKhuyenMai(@Valid @RequestBody KhuyenMai km, @PathVariable Long maKhuyenMai) {
        km.setMaKhuyenMai(maKhuyenMai);
        KhuyenMai updated = khuyenMaiService.save(km);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{maKhuyenMai}")
    public ResponseEntity<String> xoaKhuyenMai(@PathVariable Long maKhuyenMai) {
        khuyenMaiService.delete(maKhuyenMai);
        return ResponseEntity.ok("Đã xóa khuyến mãi có mã: " + maKhuyenMai);
    }
}