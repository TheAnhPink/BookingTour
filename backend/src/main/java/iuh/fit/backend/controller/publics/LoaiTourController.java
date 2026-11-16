package iuh.fit.backend.controller.publics;

import iuh.fit.backend.dto.response.LoaiTourDTO;
import iuh.fit.backend.service.LoaiTourService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loai-tour")
public class LoaiTourController {
    private  LoaiTourService loaiTourService;

    public LoaiTourController(LoaiTourService loaiTourService) {
        this.loaiTourService = loaiTourService;
    }

    @GetMapping
    public ResponseEntity<List<LoaiTourDTO>> findAll(){
        List<LoaiTourDTO> dsLoaiTour= loaiTourService.findAll();
        return ResponseEntity.ok(dsLoaiTour);
    }
}
