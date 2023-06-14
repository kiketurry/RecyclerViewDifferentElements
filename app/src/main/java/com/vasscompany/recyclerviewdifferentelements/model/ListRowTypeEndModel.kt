package com.vasscompany.recyclerviewdifferentelements.model

class ListRowTypeEndModel() : ListRowsRecyclerviewModel() {
    override fun getListRowType(): ListRowsTypes {
        return ListRowsRecyclerviewModel.ListRowsTypes.TYPE_END
    }
}