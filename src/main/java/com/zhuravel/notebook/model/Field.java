package com.zhuravel.notebook.model;

public class Field {

    private final FieldType type;
    private String value;

    public Field(FieldType type, String value) {
        this.type = type;
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public FieldType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
