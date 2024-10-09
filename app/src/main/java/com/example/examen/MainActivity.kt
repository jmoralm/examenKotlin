package com.example.examen

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.reflect.KParameter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val f1 = ::ecuacionSegundoGrado

    }

    companion object {
        val TAG: String  = "---EXAMEN----"
    }


    fun ecuacionSegundoGrado (a: Double, b: Double, c: Double): DoubleArray {

        // Se declaran las variables de cada valor de x y sus operaciones

        val x1 : Double = (-b + sqrt(b.pow(2) - (4*a*b)) / 2 * a)
        val x2 : Double = (-b - sqrt(b.pow(2) - (4*a*b)) / 2 * a)

        // Se calcula el discriminante
        var discriminante: Double = b.pow(2) - 4 * a * c

        lateinit var solucion: DoubleArray

        // Se filtra el discriminante para retornar las posibles soluciones en
        // dependiendo del valor del mismo

        // Me gustaría implementar los nulables con el let?. y el operador elvis :?
        // en el caso de que no exista solución
        // Pero se escapa de mi conocimiento por ahora, dada la complejidad del ejercicio.

        when {

            discriminante == 0.0 -> {
                solucion = doubleArrayOf(x1 ,x2, 1.0)
            }
            discriminante > 0.0 && x1 == x2 -> {
                solucion = doubleArrayOf(x1, x2, 1.0 )
            }
            discriminante < 0.0 -> {
                solucion = doubleArrayOf(0.0, 0.0, 0.0)
            }
        }

        return solucion
    }

    // fun f1 (a: Double, b: Double, c: Double, fn: (Double, Double, Double) -> DoubleArray) {}
}