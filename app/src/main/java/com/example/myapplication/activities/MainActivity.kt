package com.example.myapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.AppConstants
import com.example.myapplication.R
import com.example.myapplication.showToast

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() //Loại bỏ thanh trạng thái và thanh điều hướng khỏi vùng layout.
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnShowToast = findViewById<Button>(R.id.btnShowToast)
        val btnSendMsgNestActivity = findViewById<Button>(R.id.btnSendMsgNestActivity)
        val btnShareToOtherApp = findViewById<Button>(R.id.btnShareToOtherApp)
        val btnRecyclerViewDemo = findViewById<Button>(R.id.btnRecyclerViewDemo)

        val etUserMessage = findViewById<EditText>(R.id.etUserMessage)

        btnShowToast.setOnClickListener {
            Log.i(TAG, "Button was clicked !")
            showToast("Button was click !")
        }
        btnSendMsgNestActivity.setOnClickListener {
            val message: String = etUserMessage.text.toString()
//            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(AppConstants.USER_MSG_KEY, message)
            startActivity(intent)
        }
        btnShareToOtherApp.setOnClickListener {
            val message: String = etUserMessage.text.toString()

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to: "))
        }
        btnRecyclerViewDemo.setOnClickListener {
            val intent = Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}