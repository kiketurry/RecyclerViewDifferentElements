package com.vasscompany.recyclerviewdifferentelements.viewholder

import android.view.View
import com.vasscompany.recyclerviewdifferentelements.MyListAdapter
import com.vasscompany.recyclerviewdifferentelements.databinding.RecyclerviewListEndBinding
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel

class ListEndViewHolder(view: View, itemClickListener: MyListAdapter.ItemClickListener) : ListViewHolder(view, itemClickListener) {

    private val binding = RecyclerviewListEndBinding.bind(view)

    override fun onBind(listRowsRecyclerviewModel: ListRowsRecyclerviewModel) {
        view.setOnClickListener { itemClickListener.onItemClick(listRowsRecyclerviewModel) }
    }
}
