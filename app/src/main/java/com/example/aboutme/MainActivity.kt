package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

@Suppress("UNUSED_EXPRESSION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Ahmed Ben Abdesselem")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) // R pour referencer une resource qui est mise en page
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

       binding.myName = myName
        binding.doneButton.setOnClickListener { addNickname(it) }
        //findViewById<Button>(R.id.done_button).setOnClickListener{
           //addNickname(it)
        //}
    }
    private fun addNickname(view: View){


        binding.apply {
            this
            myName?.nickname = nicknameEdit.text.toString()
            binding.nicknameText.text = binding.nicknameEdit.text
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }

        //cacher le clavier
        val inn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inn.hideSoftInputFromWindow(view.windowToken, 0)
    }

}