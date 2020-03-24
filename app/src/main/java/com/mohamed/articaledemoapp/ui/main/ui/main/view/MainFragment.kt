package com.mohamed.articaledemoapp.ui.main.ui.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

import org.koin.androidx.viewmodel.ext.android.viewModel
import com.mohamed.articaledemoapp.R
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.ui.bases.OnListItemClickListener
import com.mohamed.articaledemoapp.ui.main.ui.main.viewModel.MainViewModel
import com.mohamed.articaledemoapp.ui.main.utilities.Constants
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment(), OnListItemClickListener<Result> {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.main_fragment, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.getAllArticles().observe(activity!!, Observer { results ->
            rv_articles.adapter = ArticleAdapter(context!!, results, this)
        })
    }

    override fun onItemClick(view: View, model: Result) {
        val bundle = Bundle()
        bundle.putParcelable(Constants.bundle.ARTICLE, model)
        view.findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
    }

}
