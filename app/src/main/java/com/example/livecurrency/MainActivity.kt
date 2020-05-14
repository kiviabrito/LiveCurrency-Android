package com.example.livecurrency

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.livecurrency.main.ResultFragment
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.main_activity)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .replace(R.id.container, ResultFragment.newInstance())
        .commitNow()
    }
  }

  fun showProgressBar(show: Boolean){
    val progressBar = progress_bar
    if (show){
      progressBar.visibility = View.VISIBLE
    } else {
      progressBar.visibility = View.GONE
    }
  }
}
