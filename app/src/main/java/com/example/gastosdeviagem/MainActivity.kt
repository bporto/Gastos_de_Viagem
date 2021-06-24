package com.example.gastosdeviagem

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.btnCalculate) {
            validateFields()
        }
    }

    private fun validateFields() {
        var validateOk = true

        if (edtDistance.text.isEmpty()
            || edtDistance.text.toString() == "0"
        ) {
            edtDistance.error =
                "Informe a distância"
            validateOk = false
        }
        if (edtPrice.text.isEmpty()
            || edtPrice.text.toString() == "0"
        ) {
            edtPrice.error =
                "Informe o valor do combustível"
            validateOk = false
        }
        if (edtAutonomy.text.isEmpty()
            || edtPrice.text.toString().toFloat() == 0f
        ) {
            edtAutonomy.error =
                "Informe a autonomia do seu veículo"
            validateOk = false
        }

        if (validateOk) {
            val distance: Float = edtDistance.text.toString().toFloat()
            val price: Float = edtPrice.text.toString().toFloat()
            val autonomy: Float = edtAutonomy.text.toString().toFloat()

            calculate(distance, price, autonomy)
        } else {
            Toast.makeText(this, "Zero não é um valor aceito", Toast.LENGTH_LONG).show()
        }
    }

    private fun calculate(distance: Float, price: Float, autonomy: Float) {

        val totalValue = (distance * price) / autonomy
        txvValue.text = "R$ ${"%.2f".format(totalValue)}"
    }
}