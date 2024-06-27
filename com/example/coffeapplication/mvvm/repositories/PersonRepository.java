package com.example.coffeapplication.mvvm.repositories;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class PersonRepository {
    private final FirebaseDatabase mFirebaseDatabase;
    private final FirebaseAuth mAuth;
    private final DatabaseReference myRef;
    private final FirebaseUser user;

    public PersonRepository() {
        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference("Users");
        user = mAuth.getCurrentUser();
    }

    public FirebaseUser getUser() {
        return user;
    }

    public DatabaseReference getmFirebaseDatabase() {
        return mFirebaseDatabase.getReference();
    }

    public DatabaseReference getMyRef() {
        return myRef;
    }

    public FirebaseAuth getmAuth() {
        return mAuth;
    }
}
