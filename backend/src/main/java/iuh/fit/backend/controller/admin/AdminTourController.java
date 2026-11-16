package iuh.fit.backend.controller.admin;

import iuh.fit.backend.entity.Tour;
import iuh.fit.backend.exception.NotFoundException;
import iuh.fit.backend.service.TourService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/tours")
public class AdminTourController {
    private  TourService tourService;

    public AdminTourController(TourService tourService) {
        this.tourService = tourService;
    }

    @PostMapping
    public ResponseEntity<Tour> themTour(@Valid  @RequestBody Tour tour){
        Tour tm= tourService.save(tour);
        return ResponseEntity.ok(tm);
    }

    @PutMapping("/{maTour}")
    public ResponseEntity<Tour> capNhatTour(@Valid @RequestBody Tour tour, @PathVariable Long maTour){
        tour.setMaTour(maTour);

        Tour updatedTour = tourService.save(tour);
        return ResponseEntity.ok(updatedTour);
    }

    @DeleteMapping("/{maTour}")
    public ResponseEntity<String> xoaTour(@PathVariable Long maTour) {
        tourService.delete(maTour);
        return ResponseEntity.ok("Đã xóa Tour có mã: " + maTour);
    }
}
