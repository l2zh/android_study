package com.example.android_study

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignInActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signup = findViewById<Button>(R.id.btn_signin_singup)

        fun movetosignup(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener{
            movetosignup()
        }



    }
}