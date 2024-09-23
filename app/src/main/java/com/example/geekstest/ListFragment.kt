package com.example.geekstest

import Cars
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



private lateinit var carArrayList: ArrayList<Cars>
lateinit var imageList : Array<String>
lateinit var nameList : Array<String>
lateinit var yearList: Array<Int>

class ListFragment : Fragment(),CarAdapter.ClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: CarAdapter
    private lateinit var recyclerView: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataset()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager= layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CarAdapter(this, this, carArrayList)
    }

    override fun clickedCar(cars: Cars) {

        val bundle = Bundle()
        bundle.putString("NameCar", cars.name)
        bundle.putString("ImageCar", cars.image)
        var carDetailFragment = CarDetailFragment()
        carDetailFragment.arguments = bundle



        parentFragmentManager.beginTransaction().replace(
            R.id.frame_show, carDetailFragment).addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            .commit()
    }

    }

    private fun dataset(){
        carArrayList = arrayListOf<Cars>()

        imageList = arrayOf(
            "https://www.volvocars.com/images/cs/v3/assets/blt0feaa88e629251fc/blta0fd6a077" +
                    "588ec53/66aca9e9e6f602484de3767b/s90-grid-gallery-1-1x1.jpg?branch=prod_alias&auto=webp&h=1080&iar=0&w=1080",
            "https://content.presspage.com/uploads/1850/1920_stillimage4-1x1.jpg?10000",
            "https://www.volvocars.com/images/cs/v3/assets/blt0feaa88e629251fc/blta0fd6a077" +
                    "588ec53/66aca9e9e6f602484de3767b/s90-grid-gallery-1-1x1.jpg?branch=prod_alias&auto=webp&h=1080&iar=0&w=1080",
            "https://content.presspage.com/uploads/1850/1920_stillimage4-1x1.jpg?10000",
            "https://www.volvocars.com/images/cs/v3/assets/blt0feaa88e629251fc/blta0fd6a077" +
                    "588ec53/66aca9e9e6f602484de3767b/s90-grid-gallery-1-1x1.jpg?branch=prod_alias&auto=webp&h=1080&iar=0&w=1080",
            "https://content.presspage.com/uploads/1850/1920_stillimage4-1x1.jpg?10000",
            "https://www.volvocars.com/images/cs/v3/assets/blt0feaa88e629251fc/blta0fd6a077" +
                    "588ec53/66aca9e9e6f602484de3767b/s90-grid-gallery-1-1x1.jpg?branch=prod_alias&auto=webp&h=1080&iar=0&w=1080",
            "https://i.okcdn.ru/i?r=BYCB6ChSgrN_ue8jwWXbvkrgFU4gErbhm3HeiCf9MV_MYLBZ-Gf_m4mXZKKIoCyt65oAf_Z7MdTw1OrsdQruh1yZLuDDFXsOTXRDe7UF5jFnjSu9UAqPv-HBuYJw-hpDkoTR4iuT4xCniJBC3XAkGY-2cSUHSUqX5fivC3Q2Vfgc3o4&dpr=2"
        )
        nameList = arrayOf(
            "Volvo",
            "Lexus",
            "Dodge",
            "Ford",
            "Toyota",
            "Geely",
            "Matis",
            "BMW"
        )
        yearList = arrayOf(
            2024,
            2019,
            2012,
            1244,
            1999,
            2000,
            2014,
            1989
        )
        for (i in imageList.indices){
            val cars = Cars(imageList[i], nameList[i], yearList[i])
            carArrayList.add(cars)
        }
}