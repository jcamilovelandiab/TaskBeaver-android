package com.app.taskbeaver.ui.activities.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.app.taskbeaver.R;
import com.app.taskbeaver.data.model.entities.Token;
import com.app.taskbeaver.data.model.results.Result;
import com.app.taskbeaver.ui.ViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;

    private TextInputLayout emailTextInputLayout, passwordTextInputLayout;
    private TextInputEditText emailTextInputEditText, passwordTextInputEditText;
    private Button signInButton, signUpButton;
    private ProgressBar loadingProgressBar;

    public static void start(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpActivity();
    }

    private void setUpActivity() {
        loginViewModel = new ViewModelProvider(getViewModelStore(), new ViewModelFactory()).get(LoginViewModel.class);
        connectModelWithView();
        setUpObservers();
        setUpListeners();
    }

    private void connectModelWithView(){
        emailTextInputEditText = findViewById(R.id.login_email_textInputEditText);
        passwordTextInputEditText = findViewById(R.id.login_password_textInputEditText);
        emailTextInputLayout = findViewById(R.id.login_email_textInputLayout);
        passwordTextInputLayout = findViewById(R.id.login_password_textInputLayout);
        loadingProgressBar = findViewById(R.id.login_loading_progressBar);
    }

    private void setUpObservers() {
        loginViewModel.getLoginFormState().observe(this, loginFormState -> {
            if(loginFormState!=null) {
                signInButton.setEnabled(loginFormState.isDataValid());
                emailTextInputLayout.setError(loginFormState.getEmailError()!=null ? getString(R.string.invalid_email) : null);
                passwordTextInputLayout.setError(loginFormState.getPasswordError()!=null ? getString(R.string.invalid_password) : null);
            }
        });
        loginViewModel.getLoginResult().observe(this, tokenResult -> {
            if(tokenResult!=null){
                loadingProgressBar.setVisibility(View.GONE);
                if(tokenResult instanceof Result.Error){

                }else{
                    
                }
            }
        });
    }

    private void setUpListeners() {
    }

}