package com.s4m.mvvmtest.model.User;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.s4m.mvvmtest.service.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * File Description
 * ------------------
 * Author : meera
 * Email : meera@farabi.ae
 * Date : 7/5/2018
 * Project : AndroidUpdates
 * Company : Farabi Technology
 */
public class UserRepository {

    private WebService webservice;

    // ...
    public LiveData<User> getUser(int userId) {
        // This is not an optimal implementation, we'll fix it below
        final MutableLiveData<User> data = new MutableLiveData<>();
        webservice.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                // error case is left out for brevity
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });
        return data;
    }


}
