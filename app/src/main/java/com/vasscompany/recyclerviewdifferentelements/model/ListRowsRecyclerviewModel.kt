package com.vasscompany.recyclerviewdifferentelements.model

abstract class ListRowsRecyclerviewModel() : BaseModel() {

    enum class ListRowsTypes {
        TYPE_TITLE, TYPE_ITEM, TYPE_END
    }

    abstract fun getListRowType(): ListRowsTypes
}