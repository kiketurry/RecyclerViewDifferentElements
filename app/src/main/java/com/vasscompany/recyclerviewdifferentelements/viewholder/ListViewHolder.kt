package com.vasscompany.recyclerviewdifferentelements.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.vasscompany.recyclerviewdifferentelements.MyListAdapter
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel

abstract class ListViewHolder(val view: View, val itemClickListener: MyListAdapter.ItemClickListener) : RecyclerView.ViewHolder(view) {

    abstract fun onBind(listRowsRecyclerviewModel: ListRowsRecyclerviewModel)

}
