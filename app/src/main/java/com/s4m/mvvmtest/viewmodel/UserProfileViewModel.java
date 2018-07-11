package com.s4m.mvvmtest.viewmodel;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.s4m.mvvmtest.model.User.User;
import com.s4m.mvvmtest.model.User.UserRepository;

import javax.inject.Inject;

/**
 * File Description
 * ------------------
 * Author : meera
 * Email : meera@farabi.ae
 * Date : 7/5/2018
 * Project : AndroidUpdates
 * Company : Farabi Technology
 */
public class UserProfileViewModel extends ViewModel {

    private LiveData<User> user;

    private UserRepository userRepo;

    @Inject // UserRepository parameter is provided by Dagger 2
    public UserProfileViewModel(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void init(int userId) {
        if (this.user != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        user = userRepo.getUser(userId);
    }

    public LiveData<User> getUser() {
        return this.user;
    }



}
