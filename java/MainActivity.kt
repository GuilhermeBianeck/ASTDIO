package com.example.simpsons.test123

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Example of a call to a native method
        sample_text.text = stringFromJNI()

        val next = findViewById<View>(R.id.ButtonAlm) as Button
        next.setOnClickListener(object : View.OnClickListener() {
            fun onClick(view: View) {
                val myIntent = Intent(view.getContext(), AlmocoActivity::class.java)
                startActivityForResult(myIntent, 0)
            }

        })

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
