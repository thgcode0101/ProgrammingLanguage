package com.thgcode.kotlinrv.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.thgcode.kotlinrv.R
import com.thgcode.kotlinrv.model.ProgrammingLanguage
import kotlinx.android.synthetic.main.programming_language_item.view.*

class RepositoryAdapter(
        private val items: List<ProgrammingLanguage>,
        private val context: Context,
        private val listener: (ProgrammingLanguage) -> Unit
) : RecyclerView.Adapter<RepositoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.programming_language_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bindView(item, listener)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(item: ProgrammingLanguage,
                     listener: (ProgrammingLanguage) -> Unit) = with(itemView) {
            ivMain.setImageDrawable(ContextCompat.getDrawable(context, item.imageResourceId))
            tvTitle.text = item.title
            tvLaunchYear.text = item.year.toString()
            tvDescription.text = item.description

            setOnClickListener { listener(item) }
        }

    }
}

