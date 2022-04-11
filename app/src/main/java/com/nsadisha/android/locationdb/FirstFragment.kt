package com.nsadisha.android.locationdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.nsadisha.android.locationdb.adapter.FriendAdapter
import com.nsadisha.android.locationdb.databinding.FragmentFirstBinding
import com.nsadisha.android.locationdb.models.FriendViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        // getting the recyclerview by its id
        val recyclerview = binding.friendList

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(activity)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<FriendViewModel>()

        // This loop will create 20 Views containing
        // the image with the count of view
        //for (i in 1..2) {
            data.add(FriendViewModel("Sadisha Nimsara", 14.32f, 12.54f))
            data.add(FriendViewModel("Hasini Kavisha", 14.32f, 12.54f))
            data.add(FriendViewModel("Asdfhh Erghn", 14.32f, 12.54f))
        //}

        // This will pass the ArrayList to our Adapter
        val adapter = FriendAdapter(data, requireActivity().parent)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}