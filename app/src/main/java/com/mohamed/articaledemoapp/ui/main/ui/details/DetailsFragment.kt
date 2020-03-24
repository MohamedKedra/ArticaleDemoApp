package com.mohamed.articaledemoapp.ui.main.ui.details


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide

import com.mohamed.articaledemoapp.R
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.utilities.Constants
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        initViews()
    }

    private fun initViews(){

        arguments?.let {
            val article = it.getParcelable<Result>(Constants.bundle.ARTICLE)
            if(article != null){
                tv_title.text = article.title
                tv_abstract.text = article.abstract
                tv_by_line.text = article.byline
                tv_date.text = article.byline
                tv_section.text = article.section
                tv_source.text = article.source
                tv_url.text = article.url
            }else{
                findNavController().popBackStack()
            }
        }?: run{
            findNavController().popBackStack()
        }

    }
}
