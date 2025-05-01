package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val edittext = findViewById<EditText>(R.id.edittext)
        edittext.showSoftInputOnFocus = false
        val acButton = findViewById<Button>(R.id.Acbutton)
        val textview = findViewById<TextView>(R.id.textview)
        val equlto = findViewById<Button>(R.id.equalto)
        val backbutton = findViewById<ImageButton>(R.id.backButton)
        backbutton.setOnClickListener {
            val currentText = edittext.text.toString()
            if (currentText.isNotEmpty()) {
                edittext.setText(currentText.dropLast(1))
                edittext.setSelection(edittext.text.length)

            }
        }
        acButton.setOnClickListener {
            edittext.setText("")
            textview.setText("")

        }

        val seven = findViewById<Button>(R.id.seven)
        seven.setOnClickListener {
            edittext.append("7")

        }
        val eight = findViewById<Button>(R.id.eight)
        eight.setOnClickListener {
            edittext.append("8")
        }

        val nine = findViewById<Button>(R.id.nine)
        nine.setOnClickListener {
            edittext.append("9")
        }
        val mult = findViewById<Button>(R.id.multiplicatoin)
        mult.setOnClickListener {
            edittext.append("*")
        }
        val div = findViewById<Button>(R.id.divisionButton)
        div.setOnClickListener {
            edittext.append("/")
        }

        val four = findViewById<Button>(R.id.four)
        four.setOnClickListener {
            edittext.append("4")
        }

        val five = findViewById<Button>(R.id.five)
        five.setOnClickListener {
            edittext.append("5")
        }

        val six = findViewById<Button>(R.id.six)
        six.setOnClickListener {
            edittext.append("6")
        }
        val minus = findViewById<Button>(R.id.minus)
        minus.setOnClickListener {
            edittext.append("-")
        }

        val one = findViewById<Button>(R.id.one)
        one.setOnClickListener {
            edittext.append("1")
        }

        val two = findViewById<Button>(R.id.two)
        two.setOnClickListener {
            edittext.append("2")
        }

        val three = findViewById<Button>(R.id.three)
        three.setOnClickListener {
            edittext.append("3")

        }
        val addButton = findViewById<Button>(R.id.add)
        addButton.setOnClickListener {
            edittext.append("+")
        }


        val mode = findViewById<Button>(R.id.modulus)
        mode.setOnClickListener {
            edittext.append("%")
        }

        val zero = findViewById<Button>(R.id.zero)
        zero.setOnClickListener {
            edittext.append("0")
        }

        val point = findViewById<Button>(R.id.dot)
        point.setOnClickListener {
            edittext.append(".")

        val plusorminus = findViewById<Button>(R.id.PlusorMinusButton)
            plusorminus.setOnClickListener {
                val currentText = edittext.text.toString()
                if (currentText.isNotEmpty()) {
                    if (currentText.startsWith("-")) {
                        // Remove the minus sign to make it positive
                        edittext.setText(currentText.substring(1))
                    } else {
                        // Add a minus sign to make it negative
                        edittext.setText("-$currentText")
                    }
                }
            }

        }
        equlto.setOnClickListener {
            val input = edittext.text.toString()
            try {
                val result = when {
                    input.contains("+") -> {
                        val numbers = input.split("+").map { it.trim().toInt() }
                        numbers.sum()
                    }

                    input.contains("-") -> {
                        val numbers = input.split("-").map { it.trim().toInt() }
                        numbers.reduce { acc, i -> acc - i }
                    }

                    input.contains("*") -> {
                        val numbers = input.split("*").map { it.trim().toInt() }
                        numbers.reduce { acc, i -> acc * i }
                    }

                    input.contains("/") -> {
                        val numbers = input.split("/").map { it.trim().toDouble() }
                        if (numbers[1] == 0.0) {
                            throw ArithmeticException("Cannot divide by zero")
                        }
                        numbers.reduce { acc, i -> acc / i }
                    }
                    input.contains("%")->{
                        val numbers = input.split("%").map {it.trim().toInt()}
                        numbers.reduce { acc,i -> acc%i }

                    }

                    else -> {
                        throw Exception("Invalid Expression")
                    }
                }
                textview.text = result.toString()
            } catch (e: Exception) {
                textview.text = "Invalid Input"
            }

        }


    }
}






