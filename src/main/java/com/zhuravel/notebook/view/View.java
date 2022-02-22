package com.zhuravel.notebook.view;

import java.util.Locale;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class View {
    private static final Logger LOG = LoggerFactory.getLogger(View.class);

    public static final String RESOURCE = "messages";
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE, Locale.getDefault());

    public void showMessage(String message) {
        try {
            System.out.println(resourceBundle.getString(message));
        } catch (NullPointerException e) {
            LOG.error(e.getMessage());
        }
    }

    public void showMessageWrong() {
        try {
            System.out.println(resourceBundle.getString(MessagesContainer.WRONG_INPUT));
        } catch (NullPointerException e) {
            LOG.error(e.getMessage());
        }
    }
}
