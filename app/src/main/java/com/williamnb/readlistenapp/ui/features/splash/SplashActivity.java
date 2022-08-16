package com.williamnb.readlistenapp.ui.features.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;

import com.williamnb.readlistenapp.base.BaseActivity;
import com.williamnb.readlistenapp.databinding.ActivitySplashBinding;
import com.williamnb.readlistenapp.ui.features.login.SignInActivity;
import com.williamnb.readlistenapp.ui.features.main.MainActivity;
import com.williamnb.readlistenapp.utilities.Constants;

@SuppressLint("CustomSplashScreen")
public class SplashActivity extends BaseActivity<ActivitySplashBinding, SplashViewModel> {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            decideNextScreen(viewModel.decideNextScreen());
        }
    };

    @Override
    protected ActivitySplashBinding getActivityBinding() {
        return ActivitySplashBinding.inflate(getLayoutInflater());
    }

    @Override
    public SplashViewModel createViewModel() {
        return new ViewModelProvider(this).get(SplashViewModel.class);
    }

    @Override
    public void initializeView() {
        this.handler.postDelayed(this.runnable, 1500);
    }

    @Override
    public void initializeComponent() {

    }

    @Override
    public void initializeEvents() {

    }

    @Override
    public void initializeData() {

    }

    private void decideNextScreen(@NonNull String screen) {
        switch (screen) {
            case Constants.WELCOME_SCREEN:
                //todo
                break;
            case Constants.LOGIN_SCREEN:
                startActivity(new Intent(this, SignInActivity.class));
                break;
            case Constants.MAIN_SCREEN:
            default:
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}
