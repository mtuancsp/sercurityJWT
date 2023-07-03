package com.example.springboot;

import java.text.MessageFormat;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        ResourceBundle bundle = ResourceBundle.getBundle("message");

        String welcomeMessage = bundle.getString("welcomeMessage");

        String formattedMessage = MessageFormat.format(welcomeMessage, "C02", "team 2");

        System.err.println(formattedMessage);
    }
}

