package iuh.fit.backend.controller.admin;

import iuh.fit.backend.entity.KhachSan;
import iuh.fit.backend.service.KhachSanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/khach-san")
public class AdminKhachSanController {
    private final KhachSanService khachSanService;

    public AdminKhachSanController(KhachSanService khachSanService) {
        this.khachSanService = khachSanService;
    }

    @PostMapping
    public ResponseEntity<KhachSan> themKhachSan(@Valid @RequestBody KhachSan ks) {
        KhachSan saved = khachSanService.save(ks);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{maKhachSan}")
    public ResponseEntity<KhachSan> capNhatKhachSan(@Valid @RequestBody KhachSan ks, @PathVariable Long maKhachSan) {
        ks.setMaKhachSan(maKhachSan);
        KhachSan updated = khachSanService.save(ks);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{maKhachSan}")
    public ResponseEntity<String> xoaKhachSan(@PathVariable Long maKhachSan) {
        khachSanService.delete(maKhachSan);
        return ResponseEntity.ok("Đã xóa khách sạn có mã: " + maKhachSan);
    }
}