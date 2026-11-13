package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TrangThaiLichKhoiHanh {
    DANG_MO_BAN("Đang mở bán"),
    HET_CHO("Hết chỗ"),
    DANG_DIEN_RA("Đang diễn ra"),
    HOAN_THANH("Hoàn thành"),
    DA_HUY("Đã hủy");

    private final String tenHT;

    TrangThaiLichKhoiHanh(String tenHT) {
        this.tenHT = tenHT;
    }

    @JsonValue
    public String getTenHT() {
        return tenHT;
    }
}