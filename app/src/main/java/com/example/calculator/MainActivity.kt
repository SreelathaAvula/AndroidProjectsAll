package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.calculator.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val buttons: List<View> = listOf(
            binding.numberOne,
            binding.numberTwo,
            binding.numberThree,
            binding.numberFour,
            binding.numberFive,
            binding.numberSix,
            binding.numberSeven,
            binding.numberEight,
            binding.numberNine,
            binding.numberZero,
            binding.numberAddition,
            binding.numberSubstraction,
            binding.numberMultiplication,
            binding.numberDivision,
            binding.numberPercentage,
            binding.numberDot,
            binding.numberEqual,
            binding.allClear,
            binding.numberDelete
        )
        for (item in buttons) {
            item.setOnClickListener { clickEvent(it) }
        }
    }

    private fun clickEvent(view: View) {
        when (view.id) {
            R.id.number_seven -> numberEvent(view)
            R.id.number_eight -> numberEvent(view)
            R.id.number_six -> numberEvent(view)
            R.id.number_nine -> numberEvent(view)
            R.id.number_five -> numberEvent(view)
            R.id.number_four -> numberEvent(view)
            R.id.number_three -> numberEvent(view)
            R.id.number_one -> numberEvent(view)
            R.id.number_two -> numberEvent(view)
            R.id.number_zero -> numberEvent(view)

            R.id.number_addition -> numberEvent(view)
            R.id.number_substraction -> numberEvent(view)
            R.id.number_multiplication -> numberEvent(view)
            R.id.number_division -> numberEvent(view)
            R.id.number_percentage -> numberEvent(view)
            R.id.number_dot -> numberEvent(view)
            R.id.number_delete -> removeOperation()
            R.id.all_clear -> allClearOperation()


            R.id.number_equal -> performCalculation()

        }
    }

    fun allClearOperation() {
        binding.finalResult.text = ""
        binding.result.text = ""
    }

    fun removeOperation() {
        val len = binding.result.length()
        if (len > 0) {
            //subSequence returns 0,len-1...starting inclusive ending exclusive
            binding.result.text = binding.result.text.subSequence(0, len - 1)
            binding.finalResult.text = ""
        }
    }

    fun numberEvent(view: View) {
        if (view is Button) {
            binding.result.append(view.text)
            var checkElement: Char = view.text.toString().single()

        }
    }

    fun performCalculation() {
        var stringExpression: String = binding.result.text.toString()
        var charArray = stringExpression.toCharArray(0, stringExpression.length - 1)


        val numbers = Stack<Int>()
        val operators=Stack<Char>()


        for (i in charArray.indices) {
            if (charArray[i] <= '0' && charArray[i] <= '9') {
                var mutedExpresion=StringBuffer()

                while (i < charArray.size&&
                    charArray[i] >= '0' &&
                    charArray[i] <= '9'){
                    mutedExpresion.append(charArray[i])
                }
                numbers.push(mutedExpresion.toString().toInt())
            }
            else if(charArray[i] =='+' ||charArray[i] =='-'||  charArray[i] =='*' ||charArray[i] =='/' || charArray[i] =='%'){

            }
        }

    }
}

