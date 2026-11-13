package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LoaiHanhKhach {
    NGUOI_LON("Người lớn"),
    TRE_EM("Trẻ em"),
    EM_BE("Em bé");

    private final String tenHT;

    LoaiHanhKhach(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}