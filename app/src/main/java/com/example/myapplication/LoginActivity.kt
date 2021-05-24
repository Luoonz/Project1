package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val adminId = "admin"
    val adminPw = "1234admin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginBtn.setOnClickListener {
            val id = idEdt.text.toString()
            val pw = pwEdt.text.toString()

            if( id.equals("") || pw.equals("") ){
                Toast.makeText(this, "id 또는 pw 공백", Toast.LENGTH_SHORT).show()
            }else{

                // 실제는
                // DB 접속하여 id와 pw 맞는지 확인 필요
                // 맞으면 return 값을 ok 로, 틀리면 return 값을 no 로
                // 아래 if 문의 조건에 return 값 대조
                if( id.equals(adminId) && pw.equals(adminPw) ){
                    val intent = Intent(this@LoginActivity, MainActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "id 또는 pw 오류", Toast.LENGTH_SHORT).show()
                }
            }
        }

        joinBtn.setOnClickListener {
            val intent = Intent(this@LoginActivity, JoinActivity::class.java)
            startActivity(intent)
        }
    }
}