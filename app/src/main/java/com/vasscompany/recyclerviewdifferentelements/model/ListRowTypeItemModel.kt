package com.vasscompany.recyclerviewdifferentelements.model

class ListRowTypeItemModel(val item: ItemModel) : ListRowsRecyclerviewModel() {
    override fun getListRowType(): ListRowsTypes {
        return ListRowsRecyclerviewModel.ListRowsTypes.TYPE_ITEM
    }
}