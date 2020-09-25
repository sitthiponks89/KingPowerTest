package com.sitthipon.kingpowertest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.ActionBar
import com.sitthipon.kingpowertest.R

class Detail : AppCompatActivity() {

    var imgView: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar: ActionBar? = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        setWidget()
        setEvent()

    }

    private fun setWidget() {

    //    imgView = findViewById(R.id.imgView)

    }

    private fun setEvent() {
        var intent = getIntent()
        imgView!!.setImageResource(intent.getIntExtra("IMAGE", 0))


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int? = item.itemId
        if (id == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}
