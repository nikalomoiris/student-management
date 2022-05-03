package com.nkalomoiris.studentmanagement.model;

public enum StudentLevel {
    LOW("l"),
    MEDIUM("m"),
    HIGH("h");

    final String code;

    StudentLevel(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
