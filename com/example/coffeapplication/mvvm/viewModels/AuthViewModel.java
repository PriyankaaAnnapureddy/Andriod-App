package com.example.coffeapplication.mvvm.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.coffeapplication.mvvm.repositories.AuthRepository;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;


public class AuthViewModel extends AndroidViewModel {

    private final FirebaseAuth firebaseAuth;
    private final AuthRepository repository;
    private final MutableLiveData<FirebaseUser> userData;
    private final MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);
        repository = new AuthRepository(application);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void register(String email , String pass, String name, String sec_name, String birthday, String gender){
        repository.register(email, pass, name, sec_name, birthday, gender);
    }

    public void signOut(){
        repository.signOut();
    }
}
