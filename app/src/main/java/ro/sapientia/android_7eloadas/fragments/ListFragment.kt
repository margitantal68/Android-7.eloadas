package ro.sapientia.android_7eloadas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ro.sapientia.android_7eloadas.R
import ro.sapientia.android_7eloadas.adapter.DataAdapter
import ro.sapientia.android_7eloadas.adapter.OnItemClickListener
import ro.sapientia.android_7eloadas.model.Item
import ro.sapientia.android_7eloadas.util.Utils


class ListFragment : Fragment(),
                     OnItemClickListener{ // List Item event handling
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    lateinit var list: List<Item>
    lateinit var adapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = Utils().generateDummyList(100)

        val recycler_view: RecyclerView = view.findViewById(R.id.recycler_view)
        // 1. No event handling
        // recycler_view.adapter = DataAdapter(list)
        // 2. Event handling - pass fragment (this) to data adapter
        adapter = DataAdapter(list, this)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this.context)
        recycler_view.setHasFixedSize(true)

    }

    override fun onItemClick(position: Int) {
        var clickedItem : Item = list[position]
        clickedItem.text2 = "Clicked"
        adapter.notifyItemChanged(position)

    }
}