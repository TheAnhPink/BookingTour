package iuh.fit.backend.entity;

import com.fasterxml.jackson.annotation.JsonValue;

public enum VaiTro {
    KHACH_HANG("Khách hàng"),
    QUAN_TRI_VIEN("Quản trị viên");

    private final String tenHT;

    VaiTro(String tenHT) {
        this.tenHT = tenHT;
    }
    @JsonValue
    public String getTenHT(){
        return tenHT;
    }
}
