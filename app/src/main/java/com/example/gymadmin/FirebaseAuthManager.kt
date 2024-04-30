package com.example.gymadmin

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FirebaseAuthManager {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signup(username: String, password: String, onCompleteListener: (task: Task<AuthResult>) -> Unit) {
        auth.createUserWithEmailAndPassword(username, password)
            .addOnCompleteListener(onCompleteListener)
    }

    fun login(username: String, password: String, onCompleteListener: (task: Task<AuthResult>) -> Unit) {
        auth.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener(onCompleteListener)
    }

    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }
}