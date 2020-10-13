package com.app.taskbeaver.utils;

import android.util.Patterns;

public class Validator {

    /*
        This regex expression means:
        - A digit must occur at least once
        - A lower case letter must occur at least once.
        - An upper case letter must occur at least once.
        - No white space is allowed in the entire string.
        - The string must contain at least 8 characters.
     */
    private static String regexPassword = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    
    public static boolean isEmailValid(String email){
        if(email==null) return false;
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password){
        if(password==null) return false;
        return regexPassword.matches(regexPassword);
    }

}
