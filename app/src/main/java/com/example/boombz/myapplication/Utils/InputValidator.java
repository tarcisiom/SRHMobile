package com.example.boombz.myapplication.Utils;

import android.util.Patterns;

/**
 * Created by boombz on 23/09/16.
 */
public class InputValidator {
    /**
     * Method used to verify is email is valid
     * @param email Email string to verify
     * @return Boolean representing email validity, true if valid and false if not
     */
    public static boolean isEmailValid(String email) {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Method used to verify is password is valid
     * @param password Password to verify
     * @return Boolean representing password validity, true if valid and false if not
     */
    public static boolean isPasswordValid(String password) {
        return password.length() >= 4;
    }

    /**
     * Method used to verify is name is valid
     * @param name Password to verify
     * @return Boolean representing name validity, true if valid and false if not
     */
    public static boolean isNameValid(String name) {
        return name.length() > 4 && name.length() <= 15;
    }
}
