package com.app.taskbeaver.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.taskbeaver.data.repositories.UserRepository;
import com.app.taskbeaver.ui.activities.login.LoginViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(UserRepository.getInstance());
        }else{
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
