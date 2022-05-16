package com.thetechbears.expensical.Signup;


import android.content.Context;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class User {
//    User Variables
    private String email;
    private String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    //    Firebase Variables
    private String userId;
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private DatabaseReference root = FirebaseDatabase.getInstance().getReference().child("Users");

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeData(){
        userId = mAuth.getCurrentUser().getUid();
        root.child(userId).child("Email").setValue(email);
        root.child(userId).child("Name").setValue(name);
    }
}