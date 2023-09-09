package com.example.mynews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class DetailFragment : Fragment() {

    //DetailFragment에서 Bundle로부터 데이터 받기
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val articleTxt: TextView = view.findViewById(R.id.articleTxt)
        val imageView: ImageView = view.findViewById(R.id.articleimg)

        arguments?.let {
            val articleDetail = it.getString("articleDetail")
            articleTxt.text = articleDetail
            val imgDetail = it.getInt("imgDetail")
            imageView.setImageResource(imgDetail)
        }

        return view
    }
}
