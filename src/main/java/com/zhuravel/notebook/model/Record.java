package com.zhuravel.notebook.model;

import java.util.HashMap;
import java.util.Map;

public class Record {

    private Map<FieldType, String> fields;

    public Record() {
        this.fields = new HashMap<>();
    }

    public Record(Map<FieldType, String> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        fields.put(field.getType(), field.getValue());
    }
}
