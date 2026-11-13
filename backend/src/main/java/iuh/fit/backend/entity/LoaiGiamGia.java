package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LoaiGiamGia {
    PHAN_TRAM("Phần trăm"),
    SO_TIEN_CO_DINH("Số tiền cố định");

    private final String tenHT;

    LoaiGiamGia(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}