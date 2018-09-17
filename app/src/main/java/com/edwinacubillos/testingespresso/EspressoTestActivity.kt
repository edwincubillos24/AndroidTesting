package com.edwinacubillos.testingespresso

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class EspressoTestActivity : AppCompatActivity() {

    private lateinit var eName : EditText
    private lateinit var eUsername : EditText
    private lateinit var ePassword : EditText
    private lateinit var tError : TextView
    private lateinit var bRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        eName = findViewById(R.id.eName)
        eUsername = findViewById(R.id.eUsername)
        ePassword = findViewById(R.id.ePassword)
        tError = findViewById(R.id.tError)
        bRegister = findViewById(R.id.bRegister)
    }

    fun bRegisterClicked(view : View){
        if (eName.text.isEmpty() || eUsername.text.isEmpty() || ePassword.text.isEmpty()){
            tError.visibility = View.VISIBLE
            tError.text = getString(R.string.error_text)
        } else {
            tError.visibility = View.VISIBLE
            tError.text = getString(R.string.count_created)
        }
    }


}

