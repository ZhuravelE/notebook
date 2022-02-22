package com.zhuravel.notebook.controller;

import com.zhuravel.notebook.model.Model;
import com.zhuravel.notebook.model.Field;
import com.zhuravel.notebook.model.FieldType;
import com.zhuravel.notebook.model.Record;
import com.zhuravel.notebook.view.MessagesContainer;
import com.zhuravel.notebook.view.View;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller {

    public static final String RESOURCE = "regex";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE, Locale.getDefault());

    private final Model model;
    private final View view;

    private final Map<FieldType, IOMessage> enterMessages = new LinkedHashMap<>(){{
        put(FieldType.LASTNAME, new IOMessage(MessagesContainer.ENTER_LASTNAME, RegexContainer.NAME));
        put(FieldType.FIRSTNAME, new IOMessage(MessagesContainer.ENTER_FIRSTNAME, RegexContainer.NAME));
        put(FieldType.MIDNAME, new IOMessage(MessagesContainer.ENTER_MIDNAME, RegexContainer.NAME));
        put(FieldType.PHONE_MOBILE, new IOMessage(MessagesContainer.ENTER_PHONE, RegexContainer.PHONE));
        put(FieldType.EMAIL, new IOMessage(MessagesContainer.ENTER_EMAIL, RegexContainer.EMAIL));
    }};

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Record record = receiveNewInput();
        model.addRecord(record);
    }

    public Record receiveNewInput() {
        Record record = new Record();

        Scanner sc = new Scanner(System.in);
        String input, localizedRegex;

        for (Map.Entry<FieldType, IOMessage> entry: enterMessages.entrySet()) {
            view.showMessage(entry.getValue().message);
            localizedRegex = resourceBundle.getString(entry.getValue().regex);

            while (!(input = sc.nextLine()).isEmpty()) {
                if (input.matches(localizedRegex)) {
                    record.addField(new Field(entry.getKey(), input));
                    break;
                } else {
                    view.showMessageWrong();
                }
            }
        }

        return record;
    }

    private static class IOMessage {
        String message;
        String regex;

        public IOMessage(String message, String regex) {
            this.message = message;
            this.regex = regex;
        }
    }
}
