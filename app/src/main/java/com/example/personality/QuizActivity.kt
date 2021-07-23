package com.example.personality

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Callback
import retrofit2.Response

class QuizActivity : AppCompatActivity() {
   lateinit var rvdata: RecyclerView
    lateinit var apiService: ServiceInterface
    private var ambilData: ArrayList<KontakData> = arrayListOf()
    //var btnnext: Button = findViewById(R.id.btnnext)
   //  var btnprev: Button = findViewById(R.id.btnprev)
    var nomor:Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        rvdata = findViewById(R.id.rv_data)

       // var btnnext: Button = findViewById(R.id.btnnext)
        // var btnprev: Button = findViewById(R.id.btnprev)
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getDataId(nomor).enqueue(object : Callback<List<KontakData>> {
            override fun onResponse(
                call: retrofit2.Call<List<KontakData>>,
                response: Response<List<KontakData>>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    ambilData.addAll(res!!)
                   rvdata.layoutManager = LinearLayoutManager(this@QuizActivity)
                   rvdata.adapter = QuizAdapter(ambilData)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<KontakData>>, t: Throwable) {
            }
        })


    }

    fun next(view: View) {
        nomor++
        apiService = Repository.getDataAPI().create(ServiceInterface::class.java)
        apiService.getDataId(nomor).enqueue(object : Callback<List<KontakData>> {
            override fun onResponse(
                call: retrofit2.Call<List<KontakData>>,
                response: Response<List<KontakData>>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    ambilData.addAll(res!!)
                    rvdata.layoutManager = LinearLayoutManager(this@QuizActivity)
                    rvdata.adapter = QuizAdapter(ambilData)
                }
            }

            override fun onFailure(call: retrofit2.Call<List<KontakData>>, t: Throwable) {
            }
        })
    }


}

