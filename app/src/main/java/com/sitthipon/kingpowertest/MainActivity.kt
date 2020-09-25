package com.sitthipon.kingpowertest

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sitthipon.kingpowertest.adapter.MainAdapter
import com.sitthipon.kingpowertest.common.Common
import com.sitthipon.kingpowertest.model.Photos
import com.sitthipon.kingpowertest.service.PhotosService
import kotlinx.android.synthetic.main.activity_main.*
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var mService : PhotosService
    lateinit var adapter : MainAdapter
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mService = Common.retrofitService

        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.setLayoutManager(GridLayoutManager(this, 2))

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()

        getAllMovieList()

    }

    private fun getAllMovieList() {
        dialog.show()

        mService.getPhotos().enqueue(object : Callback<MutableList<Photos>>  {
            override fun onFailure(call: Call<MutableList<Photos>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<MutableList<Photos>>, response: Response<MutableList<Photos>>) {
                adapter = MainAdapter(baseContext, response.body() as MutableList<Photos>)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter

                dialog.dismiss()
            }

        })
    }

}
