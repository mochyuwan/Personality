package com.example.personality
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class QuizAdapter
    (private val listku: ArrayList<KontakData>): RecyclerView.Adapter<QuizAdapter.KontakViewHolder>()
{
    inner class KontakViewHolder(viewku: View) : RecyclerView.ViewHolder(viewku) {
        var soal: TextView = viewku.findViewById(R.id.soalquiz)
      //  var id: TextView = viewku.findViewById(R.id.idsoal)
        var rg: RadioGroup = viewku.findViewById(R.id.pilihan)
        var A: RadioButton = viewku.findViewById(R.id.pilihanA)
        var B: RadioButton = viewku.findViewById(R.id.pilihanB)
        var C: RadioButton = viewku.findViewById(R.id.pilihanC)
        var D: RadioButton = viewku.findViewById(R.id.pilihanD)
       // var btnnext:Button = viewku.findViewById(R.id.btnnext)
        var apiIterface: ServiceInterface? = Repository.getDataAPI().create(ServiceInterface::class.java)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KontakViewHolder {
        val viewView: View = LayoutInflater.from(parent.context).inflate(R.layout.data_quiz, parent, false)
        return KontakViewHolder(viewView)
    }

    override fun onBindViewHolder(holder: KontakViewHolder, position: Int) {
        val dataku = listku[position]
      //  holder.id.text = dataku.id.toString()
        holder.soal.text = dataku.soal
        holder.A.text =  dataku.a
        holder.B.text =  dataku.b
        holder.C.text =  dataku.c
        holder.D.text =  dataku.d
      // holder.btnnext.setOnClickListener {
       //                 listku.removeAt(1)
         //               notifyDataSetChanged()
           //             Toast.makeText(
             //               holder.itemView.context,
               //             "Delete Data Success",
                 //           Toast.LENGTH_SHORT
                   //     ).show()

        //}
    }

    override fun getItemCount(): Int {
        return listku.size
    }

}