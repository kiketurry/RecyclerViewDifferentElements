package com.vasscompany.recyclerviewdifferentelements.viewholder

import android.view.View
import com.vasscompany.recyclerviewdifferentelements.MyListAdapter
import com.vasscompany.recyclerviewdifferentelements.databinding.RecyclerviewListTitleBinding
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeTitleModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel

class ListTitleViewHolder(view: View, itemClickListener: MyListAdapter.ItemClickListener) : ListViewHolder(view, itemClickListener) {

    private val binding = RecyclerviewListTitleBinding.bind(view)

    override fun onBind(listRowsRecyclerviewModel: ListRowsRecyclerviewModel) {
        view.setOnClickListener { itemClickListener.onItemClick(listRowsRecyclerviewModel) }
        if (listRowsRecyclerviewModel is ListRowTypeTitleModel) {
            binding.tvTitle.text = listRowsRecyclerviewModel.title
        } else {
            binding.clRecyclerTitle.visibility = View.GONE
        }
    }
}
