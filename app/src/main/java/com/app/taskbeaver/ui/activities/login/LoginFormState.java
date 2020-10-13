package com.app.taskbeaver.ui.activities.login;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Data validation state of the login form
 */
class LoginFormState {

    @Nullable
    private Integer emailError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer emailError, @Nullable Integer passwordError){
        this.emailError = emailError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid){
        this.emailError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getEmailError(){
        return this.emailError;
    }

    @Nullable
    Integer getPasswordError(){
        return this.passwordError;
    }

    @NonNull
    boolean isDataValid(){
        return this.isDataValid;
    }

}
