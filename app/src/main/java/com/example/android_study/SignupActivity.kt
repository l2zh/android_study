package com.example.android_study

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.addTextChangedListener

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val btn_signup = findViewById<Button>(R.id.btn_signup_singup)
        val id = findViewById<EditText>(R.id.et_signup_idhint)
        val pw = findViewById<EditText>(R.id.et_signup_passhint)
        val mbti = findViewById<EditText>(R.id.et_singup_mbtihint)
        pw.isEnabled = false
        btn_signup.isEnabled = false

        id.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                if( id.length() < 11 && id.length() > 5 ) {
                    pw.isEnabled = true
                }
            }
        })

        pw.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                    if(pw.length() > 7 && pw.length() < 13){
                        btn_signup.isEnabled = true
                    }
            }
        })

        btn_signup.setOnClickListener{
            val input_id = id.text.toString()
            val input_pw = pw.text.toString()
            val input_mbti = mbti.text.toString()

            val intent = Intent(this, SignInActivity::class.java)
            intent.putExtra("id", input_id)
            intent.putExtra("pw", input_pw)
            intent.putExtra("mbti", input_mbti)
            startActivity(intent)

        }

    }

}