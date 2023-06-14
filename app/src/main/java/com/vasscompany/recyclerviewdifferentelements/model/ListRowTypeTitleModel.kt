package com.vasscompany.recyclerviewdifferentelements.model

class ListRowTypeTitleModel(val title: String) : ListRowsRecyclerviewModel() {
    override fun getListRowType(): ListRowsTypes {
        return ListRowsRecyclerviewModel.ListRowsTypes.TYPE_TITLE
    }
}