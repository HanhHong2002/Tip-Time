package com.example.tiptime

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.math.RoundingMode
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.caculateButton.setOnClickListener { Caculate() }

    }
    @SuppressLint("SetTextI18n")
    private fun Caculate(){
        val cost: Double
        val tipRate:Double
        if (binding.goodOption.isChecked){
            tipRate = 1.18
        } else if (binding.okayOption.isChecked){
            tipRate = 1.15
        } else tipRate = 1.2

        cost = ( binding.costOfService.text.toString().toDoubleOrNull())?.times(tipRate) ?:0.0

        if (binding.roundUpSwitch.isChecked){
            binding.tipResult.text = (cost.toBigDecimal().setScale(2,RoundingMode.HALF_UP)).toString()
        } else
            binding.tipResult.text = cost.toString( )


    }
}