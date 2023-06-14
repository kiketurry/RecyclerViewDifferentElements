package com.vasscompany.recyclerviewdifferentelements

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vasscompany.recyclerviewdifferentelements.databinding.ActivityMainBinding
import com.vasscompany.recyclerviewdifferentelements.model.ItemModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeEndModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeItemModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowTypeTitleModel
import com.vasscompany.recyclerviewdifferentelements.model.ListRowsRecyclerviewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var itemsAdapter: MyListAdapter
    private var exampleList: ArrayList<ListRowsRecyclerviewModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        exampleList.add(ListRowTypeTitleModel("Vamos a tope!"))
        exampleList.add(ListRowTypeItemModel(ItemModel("Hola", 20, "https://picsum.photos/300", false)))
        exampleList.add(ListRowTypeItemModel(ItemModel("Bienvenido", 20, "https://picsum.photos/300", false)))
        exampleList.add(ListRowTypeItemModel(ItemModel("Saludos", 20, "https://picsum.photos/300", false)))
        exampleList.add(ListRowTypeItemModel(ItemModel("Que pasa Máquinas", 20, "https://picsum.photos/300", false)))
        exampleList.add(ListRowTypeItemModel(ItemModel("Vamos ahí", 20, "https://picsum.photos/300", false)))
        exampleList.add(ListRowTypeEndModel())

        itemsAdapter = MyListAdapter(this, exampleList, object : MyListAdapter.ItemClickListener {
            override fun onItemClick(listRowsRecyclerviewModel: ListRowsRecyclerviewModel) {
                Log.d("TAG", "l> Clickado un elemento.")
            }

            override fun onItemClickExpand(listRowTypeItemModel: ListRowTypeItemModel, position: Int) {
                Log.d("TAG", "l> Clickado un elemento para expandir.")
                listRowTypeItemModel.item.expand = !listRowTypeItemModel.item.expand
                itemsAdapter.notifyItemChanged(position)
            }
        })



        binding.rvItems.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = itemsAdapter
        }
    }
}