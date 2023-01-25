package com.example.android_study

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignInActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val signup = findViewById<Button>(R.id.btn_signin_singup)
        val btn_signin = findViewById<Button>(R.id.btn_signin_singin)
        val signin_id = findViewById<EditText>(R.id.et_signin_idhint)
        val signin_pw = findViewById<EditText>(R.id.et_signin_passhint)

        fun movetosignup(){
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        signup.setOnClickListener{
            movetosignup()
        }



        val toss_id = intent.getStringExtra("id")
        val toss_pw = intent.getStringExtra("pw")
        val toss_mbti = intent.getStringExtra("mbti")


        fun movetohome(){
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        btn_signin.setOnClickListener{
            if (toss_id == signin_id.text.toString() && toss_pw == signin_pw.text.toString()){
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_LONG).show()
                movetohome()
            }
            else{
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_LONG).show()
            }
        }


    }
}