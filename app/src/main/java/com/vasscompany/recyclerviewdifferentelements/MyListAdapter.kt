package com.vasscompany.recyclerviewdifferentelements

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeItemModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel
import com.vasscompany.recyclerviewdifferentelements.viewholder.ListEndViewHolder
import com.vasscompany.recyclerviewdifferentelements.viewholder.ListItemViewHolder
import com.vasscompany.recyclerviewdifferentelements.viewholder.ListTitleViewHolder
import com.vasscompany.recyclerviewdifferentelements.viewholder.ListViewHolder

class MyListAdapter(context: Context, private val dataSet: ArrayList<ListRowsRecyclerviewModel>, private val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<ListViewHolder>() {

    private var layoutInflater: LayoutInflater = LayoutInflater.from(context)

    interface ItemClickListener {
        fun onItemClick(listRowsRecyclerviewModel: ListRowsRecyclerviewModel)
        fun onItemClickExpand(listRowTypeItemModel: ListRowTypeItemModel, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View
        return when (viewType) {
            ListRowsRecyclerviewModel.ListRowsTypes.TYPE_TITLE.ordinal -> {
                view = layoutInflater.inflate(R.layout.recyclerview_list_title, parent, false)
                ListTitleViewHolder(view, itemClickListener)
            }

            ListRowsRecyclerviewModel.ListRowsTypes.TYPE_END.ordinal -> {
                view = layoutInflater.inflate(R.layout.recyclerview_list_end, parent, false)
                ListEndViewHolder(view, itemClickListener)
            }

            else -> {
                view = layoutInflater.inflate(R.layout.recyclerview_list_item, parent, false)
                ListItemViewHolder(view, itemClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.onBind(dataSet[position])
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun refreshData(listRowsRecyclerviewModel: ArrayList<ListRowsRecyclerviewModel>) {
        dataSet.clear()
        dataSet.addAll(listRowsRecyclerviewModel)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return dataSet[position].getListRowType().ordinal
    }

}
