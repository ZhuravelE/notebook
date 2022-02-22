package com.zhuravel.notebook.model;

import com.zhuravel.notebook.model.Record;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private List<Record> records;

    public Model() {
        this.records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }
}
