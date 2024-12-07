package com.example.myapplication.activities

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.showToast

class SecondActivity: AppCompatActivity() {

    companion object {
        val TAG: String = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Loại bỏ thanh trạng thái và thanh điều hướng khỏi vùng layout.
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        val bundle: Bundle? = intent.extras
//        val msg = bundle!!.getString("user_message")
        val msg = intent.getStringExtra("user_message").toString()
        showToast(msg)

        val txtUserMessage = findViewById<TextView>(R.id.txtUserMessage)
        txtUserMessage.text = msg
    }
}