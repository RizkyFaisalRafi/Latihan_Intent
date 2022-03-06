package com.rifara.praktik2.explicitIntent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.rifara.praktik2.MainActivity
import com.rifara.praktik2.R

class MoveActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move)

        val btnMain: Button = findViewById(R.id.btn_main_activity)
        btnMain.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_main_activity -> {
                val mainIntent = Intent(this@MoveActivity, MainActivity::class.java)
        // startActivity(mainIntent): Akan menjalankan activity baru tanpa membawa data
        // Obyek intent yang diinputkan adalah obyek mainIntent yang ketika kode ini dijalankan maka
        // akan membuka MainActivity.
                startActivity(mainIntent)
            }
        }
    }
}