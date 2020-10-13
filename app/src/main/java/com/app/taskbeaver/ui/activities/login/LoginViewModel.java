package com.app.taskbeaver.ui.activities.login;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.taskbeaver.R;
import com.app.taskbeaver.data.model.entities.Token;
import com.app.taskbeaver.data.model.entities.User;
import com.app.taskbeaver.data.model.results.Result;
import com.app.taskbeaver.data.repositories.UserRepository;
import com.app.taskbeaver.utils.Validator;

public class LoginViewModel extends ViewModel {

    MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    MutableLiveData<Result<Token>> loginResult = new MutableLiveData<>();
    UserRepository userRepository;

    public LoginViewModel(UserRepository userRepository){
        this.userRepository = userRepository;
        loginFormState.setValue(new LoginFormState(false));
    }

    public void login(String email, String password){
        if(getLoginFormState().getValue() !=null && getLoginFormState().getValue().isDataValid()){
            userRepository.login(email, password, loginResult);
        }
    }

    public void dataChanged(String email, String password){
        if(Validator.isEmailValid(email)){
            loginFormState.setValue( new LoginFormState(R.string.invalid_email, null));
        }else if(Validator.isPasswordValid(password)){
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        }else{
            loginFormState.setValue(new LoginFormState(true));
        }
    }

    public LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    public LiveData<Result<Token>> getLoginResult() {
        return loginResult;
    }

}
