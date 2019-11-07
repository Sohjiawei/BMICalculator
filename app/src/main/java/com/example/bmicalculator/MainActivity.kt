package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CalculateButton.setOnClickListener{
            calculateBMI()
        }
    }

    private fun calculateBMI(){
        if(editTextHeight.text.isEmpty() || editTextWeight.text.isBlank()){
            editTextHeight.setError(getString(R.string.error_input))
            return
        }
       val calculateweight:Float = editTextWeight.text.toString().toFloat()
       val calculateheight:Float= editTextHeight.text.toString().toFloat()

       val bmiResult=calculateweight/calculateheight.pow(2)

        TotalBMI.text=String.format("%s %.2f",getString(R.string.bmi),bmiResult)

        if(bmiResult<18.5){
            Profile.setImageResource(R.drawable.under)
            PersonalStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.underweight))
        }
        else if(18.5<bmiResult && bmiResult<=24.9){
            Profile.setImageResource(R.drawable.normal)
            PersonalStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.normalweight))
        }
        else{
            Profile.setImageResource(R.drawable.over)
            PersonalStatus.text=String.format("%s %s",getString(R.string.status),getString(R.string.overweight))
        }
    }

    fun resetinput(view:View){
        editTextWeight.setText("")
        editTextHeight.setText("")
        TotalBMI.text=getString(R.string.bmi)
        PersonalStatus.text=getString(R.string.bmi)
    }
}
