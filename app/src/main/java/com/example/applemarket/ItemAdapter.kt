package com.example.applemarket

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class ItemAdapter(private val itemList: List<Item>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        private var onItemClickListener: OnItemClickListener? = null

        // 인터페이스 정의
        interface OnItemClickListener {
            fun onItemClick(view: View, position: Int)
        }

        // 외부에서 인터페이스를 설정하는 메서드
        fun setOnItemClickListener(listener: OnItemClickListener) {
            this.onItemClickListener = listener
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ItemViewHolder(view)
        }

        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            val item = itemList[position]
            holder.textTitle.text = item.title
            holder.textDescription.text = item.description
        }

        override fun getItemCount(): Int {
            return itemList.size
        }

        class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textTitle: TextView = itemView.findViewById(R.id.textTitle)
            val textDescription: TextView = itemView.findViewById(R.id.textDescription)
        }
    }