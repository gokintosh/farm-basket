package com.gokul.farmbasketbackend.utils;

public class ControllerUtils {

    public static boolean isPasswordDifferent(String password, String password2) {
        return password!=null &&!password2.equals(password);
    }
}
