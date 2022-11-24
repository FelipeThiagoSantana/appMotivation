package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreference
import com.example.motivation.databinding.ActivityUserBinding
import com.example.motivation.infra.MotivationConstants

private lateinit var binding: ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)


        supportActionBar?.hide()

        verifyUserName()


    }

    override fun onClick(v: View) {
        if (v.id == R.id.buttonSave){

            handleSalve()
        }
    }

    private fun verifyUserName(){
        val name = SecurityPreference(this).getString(MotivationConstants.KEY.USER_NAME)
        if (name != ""){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }

    private fun  handleSalve(){
        val name = binding.validationName.text.toString()
        if (name !=""){

            SecurityPreference(this).storeString("USER_NAME", name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this, R.string.digite_seu_nome, Toast.LENGTH_SHORT).show()
        }
    }

}