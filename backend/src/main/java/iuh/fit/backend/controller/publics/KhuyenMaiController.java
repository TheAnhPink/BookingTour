package iuh.fit.backend.controller.publics;

import iuh.fit.backend.dto.response.KhuyenMaiDTO;
import iuh.fit.backend.service.KhuyenMaiService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/khuyen-mai")
public class KhuyenMaiController {
    private final KhuyenMaiService khuyenMaiService;

    public KhuyenMaiController(KhuyenMaiService khuyenMaiService) {
        this.khuyenMaiService = khuyenMaiService;
    }

    @GetMapping
    public Page<KhuyenMaiDTO> findAll(@RequestParam(defaultValue = "0") int trang,
                                      @RequestParam(defaultValue = "10") int size){
        return khuyenMaiService.findAll(trang,size);
    }
}
