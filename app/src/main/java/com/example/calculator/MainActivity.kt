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


            R.id.number_equal -> {
                var total: Int = performCalculation(binding.result.text.toString())

                binding.finalResult.text = total.toString()
            }

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
        }
    }
    fun precedence(operator1: Char, operator2: Char): Boolean {

        if ((operator1 == '*' || operator1 == '/') &&
            (operator2 == '+' || operator2 == '-')
        )
            return false;
        else
            return true
    }
    fun performCalculation(stringExpression: String):Int {
        var charArray = stringExpression.toCharArray()
        var length=charArray.size

        val numbers = Stack<Int>()
        val operators = Stack<Char>()

var i=0
        while(i<length) {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                var mutedExpression = StringBuffer()
                var j:Int=i
                while (j < charArray.size && (charArray[j] >= '0' && charArray[j] <= '9')) {
                    mutedExpression.append(charArray[j])
                    j++
                }
                numbers.push(mutedExpression.toString().toInt())
                i=j

            } else if (charArray[i] == '+' || charArray[i] == '-' || charArray[i] == '*' || charArray[i] == '/' || charArray[i] == '%') {
                while (!operators.isEmpty() && precedence(charArray[i], operators.peek())) {
                    numbers.push(applyOperstions(operators.pop(), numbers.pop(), numbers.pop()))
                }
                operators.push(charArray[i])
i++
            }
        }
        while (!operators.isEmpty()) {
            numbers.push(applyOperstions(operators.pop(), numbers.pop(), numbers.pop()))
        }
        return numbers.pop()

    }
}

fun applyOperstions(operator: Char, num1: Int, num2: Int): Int {
    when (operator) {
        '+' -> return num1 + num2
        '-' -> return num1 - num2
        '*' -> return num1 * num2
        '/' -> return num2/ num1
        '%' -> return num2 % num1
        else -> return 0
    }
}
