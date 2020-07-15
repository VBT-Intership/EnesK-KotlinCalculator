package com.enes.calculator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonsOnClick(view: View) {
        when (view.id) {
            R.id.btnOne -> setOperationText("1")
            R.id.btnTwo -> setOperationText("2")
            R.id.btnThree -> setOperationText("3")
            R.id.btnFour -> setOperationText("4")
            R.id.btnFive -> setOperationText("5")
            R.id.btnSix -> setOperationText("6")
            R.id.btnSeven -> setOperationText("7")
            R.id.btnEight -> setOperationText("8")
            R.id.btnNine -> setOperationText("9")
            R.id.btnPlus -> setOperationText("+")
            R.id.btnMinus -> setOperationText("-")
            R.id.btnDiv -> setOperationText("÷")
            R.id.btnTimes -> setOperationText("×")
            R.id.btnEqual -> takeAction()
            R.id.btnZero -> setOperationText("0")
            R.id.btnMod -> setOperationText("%")
            R.id.btnDot -> setOperationText(".")
            R.id.btnDelete -> setOperationText("<")
            R.id.btnClear -> {
                edtOperation.setText(""); tvResult.text = ""
            }
            R.id.btnSin -> setOperationText("sin(")
            R.id.btnCos -> setOperationText("cos(")
            R.id.btnTan -> setOperationText("tan(")
            R.id.btnPi -> setOperationText("π")
            R.id.btnOpenParantez -> setOperationText("(")
            R.id.btnCloseParantez -> setOperationText(")")
            R.id.btnOver -> setOperationText("^")
            R.id.btnFactorial -> setOperationText("!")
            R.id.btnLog -> setOperationText("log₁₀(")
            R.id.btnLn -> setOperationText("logₑ(")
            R.id.btnSquare -> setOperationText("√(")
        }
    }

    private fun takeAction() {
        val currentText = edtOperation.text.toString()
            .replace("×", "*")
            .replace("÷", "/")
            .replace("π", "pi")
            .replace("₁₀", "10")
            .replace("ₑ", "e")
            .replace("√", "sqrt")
        val e = Expression(currentText)
        tvResult.text = e.calculate().toString()
    }

    private fun setOperationText(operation: String) {
        val currentText = edtOperation.text.toString()

        if (operation == "<" && currentText.isNotEmpty()) edtOperation.setText(
            currentText.substring(
                0,
                currentText.length - 1
            )
        )
        else if (operation != "<") edtOperation.setText(currentText.plus(operation))
    }
}