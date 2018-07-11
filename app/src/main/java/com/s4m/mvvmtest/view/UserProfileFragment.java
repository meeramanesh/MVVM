package com.s4m.mvvmtest.view;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.s4m.mvvmtest.R;
import com.s4m.mvvmtest.viewmodel.UserProfileViewModel;

/**
 * File Description
 * ------------------
 * Author : meera
 * Email : meera@farabi.ae
 * Date : 7/5/2018
 * Project : AndroidUpdates
 * Company : Farabi Technology
 */
public class UserProfileFragment extends Fragment {

    private static final String UID_KEY = "uid";
    private UserProfileViewModel viewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String userId = getArguments().getString(UID_KEY);
        viewModel = ViewModelProviders.of(this).get(UserProfileViewModel.class);
        viewModel.init(Integer.parseInt(userId));

        viewModel.getUser().observe(this, user -> {
            // update UI
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.user_profile, container, false);
    }
}
