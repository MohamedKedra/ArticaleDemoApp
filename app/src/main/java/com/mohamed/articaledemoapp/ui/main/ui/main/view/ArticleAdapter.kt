package com.mohamed.articaledemoapp.ui.main.ui.main.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohamed.articaledemoapp.R
import com.mohamed.articaledemoapp.ui.main.data.model.Result
import com.mohamed.articaledemoapp.ui.main.ui.bases.OnListItemClickListener
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(
    private val context: Context,
    private val results : List<Result>,
    private val onListItemClickListener: OnListItemClickListener<Result>
): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder = ArticleViewHolder(
        LayoutInflater.from(context).inflate(R.layout.item_article,parent,false)
    )

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.onBind(position)
    }


    inner class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,View.OnClickListener{
        override fun onClick(p0: View?) {
            onListItemClickListener.onItemClick(itemView,results[adapterPosition])
        }

        fun onBind(position : Int){
            itemView.setOnClickListener(this)
            val article = results[position]
            itemView.tv_text.text = article.abstract
            itemView.tv_owner.text = article.byline
            itemView.tv_source.text = article.source
            itemView.tv_date.text = article.publishedDate
            if(article.media.isNotEmpty()){
                Glide.with(itemView.context).load(article.media[0].mediaMetadata[0].url).into(itemView.ivImage)
            }
        }
    }
}