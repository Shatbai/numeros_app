package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val numList= mutableListOf<Int>()
        initUI(numList)
    }
    private fun initUI(numList: MutableList<Int>){
        binding.agregar.setOnClickListener {
            addNumbers(numList)
        }
        binding.promedio.setOnClickListener {
            mean(numList)
        }
        binding.mayor.setOnClickListener {
            max(numList)
        }
        binding.pares.setOnClickListener {
            pairs(numList)
        }
    }
    private fun addNumbers(numList: MutableList<Int>){
        val number= binding.editTextNumberSigned.text.toString()
        val numberValue=number.toIntOrNull()
        if (numberValue==null){
            Toast.makeText(this,"Write at least one number",Toast.LENGTH_SHORT).show()
            return
        }
        numList.add(numberValue)
        binding.resultados.text="$numList"
        binding.editTextNumberSigned.text.clear()
    }
    private fun mean(numList: MutableList<Int>){
        val sumList=numList.sum()
        val meanList=sumList/numList.size
        binding.resultados.text="$meanList"
    }
    private fun max(numList: MutableList<Int>){
        val maxList=numList.maxOrNull()
        binding.resultados.text="$maxList"
    }
    private fun pairs(numList: MutableList<Int>){
        val pairList=numList.filter{x->x%2==0}
        binding.resultados.text="$pairList"
    }

}