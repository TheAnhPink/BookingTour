package iuh.fit.backend.controller.publics;

import iuh.fit.backend.dto.response.KhachSanDTO;
import iuh.fit.backend.service.KhachSanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/khach-san")
public class KhachSanController {
    private final KhachSanService khachSanService;

    public KhachSanController(KhachSanService khachSanService) {
        this.khachSanService = khachSanService;
    }

    @GetMapping
    public ResponseEntity<List<KhachSanDTO>> findAll() {
        return ResponseEntity.ok(khachSanService.findAll());
    }
}