package com.app.taskbeaver.data.repositories;

import androidx.lifecycle.MutableLiveData;

import com.app.taskbeaver.data.model.entities.Token;
import com.app.taskbeaver.data.model.entities.User;
import com.app.taskbeaver.data.model.results.Result;

public class UserRepository {

    private static UserRepository instance;

    private UserRepository(){
    }

    public static UserRepository getInstance(){
        if(instance==null){
            instance = new UserRepository();
        }
        return instance;
    }

    public void login(String email, String password, MutableLiveData<Result<Token>> loginResult){

    }

    public void signUp(String email, String password, MutableLiveData<Result<Token>> signUpResult){

    }

}
