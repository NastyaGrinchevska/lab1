package com.example.lab_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoxAdapter(
    private val foxes: List<Fox>,
    private val onFoxClickListener: OnFoxClickListener
) : RecyclerView.Adapter<FoxAdapter.FoxViewHolder>() {

    class FoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foxImageView: ImageView = itemView.findViewById(R.id.foxImageView)
        val typeTextView: TextView = itemView.findViewById(R.id.typeTextView)
        val binomialTextView: TextView = itemView.findViewById(R.id.binomialNameTextView)
        val derailsButton: Button = itemView.findViewById(R.id.detailsButton)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoxViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.fox_item, parent, false)
        return FoxViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoxViewHolder, position: Int) {
        val fox = foxes[position]

        holder.foxImageView.setImageResource(fox.imageRes)
        holder.typeTextView.text = fox.type
        holder.binomialTextView.text = fox.binomialName

        holder.derailsButton.setOnClickListener {
            onFoxClickListener.onClick(fox)
        }
    }

    override fun getItemCount(): Int {
        return foxes.size
    }
}
