package com.zhuravel.notebook;

import com.zhuravel.notebook.controller.Controller;
import com.zhuravel.notebook.model.Model;
import com.zhuravel.notebook.view.View;

public class App {

    public static void main(String[] args) {
        Controller controller = new Controller(new Model(), new View());
        controller.start();
    }
}
