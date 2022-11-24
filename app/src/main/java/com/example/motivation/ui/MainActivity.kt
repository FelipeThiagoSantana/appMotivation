package com.example.motivation.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreference
import com.example.motivation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private  var categoryId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Esconder Barra
        supportActionBar?.hide()
        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()


        //Eventos de Click
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.buttonNewPhrase){
            handleNextPhrase()
        } else if(view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)){
            handleFilter(view.id)
        }
    }
        private fun handleNextPhrase(){
           val phrase = Mock().getPhrase(categoryId)
            binding.Text.text = phrase
        }
    private fun handleFilter(id: Int) {

        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.Grey))
        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.Grey))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.Grey))

        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.ALL
            }
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
        }
    }



        private fun handleUserName (){
        val name =   SecurityPreference(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textUserName.text = "Olá, $name!"
    }
}