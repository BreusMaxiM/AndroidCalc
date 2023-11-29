package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numCount = 0
        var number=""

        val numbersMassive = mutableListOf<Double>()

        val operatiList = mutableListOf<String>()

        var textCalc = findViewById<TextView>(R.id.textCalculateView)

        val num1 = findViewById<Button>(R.id.buttonOne);
        num1.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "1";
            number+="1"
        }

        val num2 = findViewById<Button>(R.id.buttonTwo);
        num2.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "2";
            number+="2"
        }

        val num3 = findViewById<Button>(R.id.buttonThree);
        num3.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "3";
            number+="3"
        }

        val num4 = findViewById<Button>(R.id.buttonFoure);
        num4.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "4";
            number+="4"
        }

        val num5 = findViewById<Button>(R.id.buttonFive);
        num5.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "5";
            number+="5"
        }

        val num6 = findViewById<Button>(R.id.buttonSix);
        num6.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "6";
            number+="6"
        }

        val num7 = findViewById<Button>(R.id.buttonSeven);
        num7.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "7";
            number+="7"
        }

        val num8 = findViewById<Button>(R.id.buttonEach);
        num8.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "8";
            number+="8"
        }

        val num9 = findViewById<Button>(R.id.buttonNine);
        num9.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "9";
            number+="9"
        }

        val num0 = findViewById<Button>(R.id.buttonZero);
        num0.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "0";
            number+="0"
        }



        val plus = findViewById<Button>(R.id.buttonPlus);
        plus.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "+";
            numbersMassive.add(number.toDouble())
            operatiList.add("+")
            number="";
            numCount++

        }

        val minus = findViewById<Button>(R.id.buttonMinus);
        minus.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "-";
            numbersMassive.add(number.toDouble())
            operatiList.add("-")
            number="";
            numCount++
        }

        val multiplication = findViewById<Button>(R.id.buttonMultiplication);
        multiplication.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "x";
            numbersMassive.add(number.toDouble())
            operatiList.add("x")
            number="";
            numCount++
        }

        val division = findViewById<Button>(R.id.buttonDivision);
        division.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "/";
            numbersMassive.add(number.toDouble())
            operatiList.add("/")
            number="";
            numCount++

        }

        val delete = findViewById<Button>(R.id.buttonDeleate);
        delete.setOnClickListener{
            textCalc.text=removeLastChar(textCalc.text.toString())
            number=removeLastChar(number)
        }

        fun enableButtons(bol:Boolean){
            num1.isEnabled = bol
            num2.isEnabled = bol
            num3.isEnabled = bol
            num4.isEnabled = bol
            num5.isEnabled = bol
            num6.isEnabled = bol
            num7.isEnabled = bol
            num8.isEnabled = bol
            num9.isEnabled = bol
            num0.isEnabled = bol
            plus.isEnabled = bol
            minus.isEnabled = bol
            multiplication.isEnabled = bol
            division.isEnabled = bol
            delete.isEnabled = bol

        }
        val equal = findViewById<Button>(R.id.buttonEquals);
        equal.setOnClickListener{
            textCalc.text= textCalc.text.toString() + "=";
            numbersMassive.add(number.toDouble())
            number="";


            var azazin = numbersMassive[0]
            for(i in 1 until numbersMassive.size){
                if (operatiList[i-1]=="+"){azazin+=  numbersMassive[i]}
                else if (operatiList[i-1]=="-"){azazin-=  numbersMassive[i]}
                else if (operatiList[i-1]=="x"){azazin*=  numbersMassive[i]}
                else{ azazin/=  numbersMassive[i]}
            }

            textCalc.text = textCalc.text.toString() + azazin.toString()
            enableButtons(false);
            equal.isEnabled=false
        }



        val deleteAll = findViewById<Button>(R.id.buttonAC);
        deleteAll.setOnClickListener{
            textCalc.text="";
            number=""
            operatiList.clear()
            numbersMassive.clear()
            enableButtons(true);
            equal.isEnabled=true
        }

    }
    private fun removeLastChar(input: String): String {
        return if (input.isNotEmpty()) {
            input.substring(0, input.length - 1)
        } else {
            input
        }
    }


}