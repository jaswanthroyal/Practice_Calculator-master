package com.example.practice_calculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.sql.Types.NULL

class MainActivity : AppCompatActivity() {
    var tvInput:TextView? =null
    var lastNum = false
    var lasDecimal = false
    var DigitCount : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInput = findViewById(R.id.tv_input)
    }
    fun equals(view: View){
        if(lastNum==true){
            if(tvInput?.text?.contains("+") == true) {
                var selectednum = tvInput?.text?.split("+")
                var num1 = selectednum?.get(0)?.toDouble()
                var num2 = selectednum?.get(1)?.toDouble()
                tvInput?.text = (num1!! + num2!!).toString()
            }else if(tvInput?.text?.contains("*") == true) {
                var selectednum = tvInput?.text?.split("*")
                var num1 = selectednum?.get(0)?.toDouble()
                var num2 = selectednum?.get(1)?.toDouble()
                tvInput?.text = (num1!! * num2!!).toString()
            }else if(tvInput?.text?.contains("/") == true) {
                var selectednum = tvInput?.text?.split("/")
                var num1 = selectednum?.get(0)?.toDouble()
                var num2 = selectednum?.get(1)?.toDouble()
                if(num2!=0.0) {
                    tvInput?.text = (num1!! / num2!!).toString()
                }else{
                    tvInput?.text="Infinity"
                }
            }else if(tvInput?.text?.contains("-") == true) {
                var test_string = tvInput?.text
                if(test_string?.startsWith("-") == true){

                }
                var selectednum = tvInput?.text?.split("-")
                var num1 = selectednum?.get(0)?.toDouble()
                var num2 = selectednum?.get(1)?.toDouble()
                tvInput?.text = (num1!! - num2!!).toString()
            }
        }
        DigitCount = 0
    }
    fun functions(view: View){

        var tv_input = (view as Button).text

        if(tvInput?.text?.isEmpty() == false&&DigitCount==0){
            tvInput?.append(tv_input)
        }
        if (tv_input != null) {
            if(tv_input.contains("+")||tv_input.contains("-")||tv_input.contains("*")||tv_input.contains("/")){
                DigitCount = 1
            }
        }

        if(tvInput?.text?.isEmpty() == true){
            if(tv_input=="-"){
                tvInput?.append(tv_input)
                DigitCount = 0
            }
        }
        lastNum = false
    }
    fun Onclick(view: View){
        tvInput?.append((view as Button).text)
        lastNum = true
    }
    fun Onclear(view :View){
        tvInput?.text = ""
        lasDecimal = false
        DigitCount = 0;
    }
    fun Ondecimal(view: View){
        if(!lasDecimal && lastNum) {
            tvInput?.append((view as Button).text)
            lasDecimal = true
            lastNum = false
        }
    }
}