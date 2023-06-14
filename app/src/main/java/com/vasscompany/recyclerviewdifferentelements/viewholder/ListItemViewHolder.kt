package com.vasscompany.recyclerviewdifferentelements.viewholder

import android.view.View
import androidx.core.content.res.ResourcesCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.vasscompany.recyclerviewdifferentelements.MyListAdapter
import com.vasscompany.recyclerviewdifferentelements.databinding.RecyclerviewListItemBinding
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeItemModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel

class ListItemViewHolder(view: View, itemClickListener: MyListAdapter.ItemClickListener) : ListViewHolder(view, itemClickListener) {

    private val binding = RecyclerviewListItemBinding.bind(view)

    override fun onBind(listRowsRecyclerviewModel: ListRowsRecyclerviewModel) {
        view.setOnClickListener { itemClickListener.onItemClick(listRowsRecyclerviewModel) }

        if (listRowsRecyclerviewModel is ListRowTypeItemModel) {

            if (listRowsRecyclerviewModel.item.expand) {
                binding.ivImage.visibility = View.VISIBLE
                binding.ivStar.setImageDrawable(ResourcesCompat.getDrawable(binding.ivStar.resources, android.R.drawable.star_big_on, null))
            } else {
                binding.ivImage.visibility = View.GONE
                binding.ivStar.setImageDrawable(ResourcesCompat.getDrawable(binding.ivStar.resources, android.R.drawable.star_big_off, null))
            }

            binding.ivStar.setOnClickListener { itemClickListener.onItemClickExpand(listRowsRecyclerviewModel, adapterPosition) }

            binding.tvNameData.text = listRowsRecyclerviewModel.item.name

            Glide.with(binding.ivImage.context)
                .load(listRowsRecyclerviewModel.item.image)
                .transform(RoundedCorners(8))
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .into(binding.ivImage)

        } else {
            binding.clRecyclerItem.visibility = View.GONE
        }
    }
}
