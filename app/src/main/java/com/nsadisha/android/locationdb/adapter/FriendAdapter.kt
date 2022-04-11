package com.nsadisha.android.locationdb.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.PopupMenu
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.nsadisha.android.locationdb.R
import com.nsadisha.android.locationdb.models.FriendViewModel

class FriendAdapter(private val mList: List<FriendViewModel>, private val activity: Activity?) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        holder.imageView.setImageResource(ItemsViewModel.image)

        // sets the text to the textview from our itemHolder class
        holder.name.text = itemsViewModel.name
        holder.lat.text = "Lat: "+itemsViewModel.lat
        holder.lgt.text = "Lgt: "+itemsViewModel.lgt

        holder.menuBtn.setOnClickListener {
//            holder.name.text = itemsViewModel.name + " - clicked"
            showPopup(holder.menuBtn)
        }

        holder.card.setOnClickListener {

        }
    }

    private fun showPopup(view: View) {

        val popup = PopupMenu(this.activity, view)
        popup.inflate(R.menu.menu_friend_options)

        popup.setOnMenuItemClickListener{ item: MenuItem? ->

            when (item!!.itemId) {
                R.id.action_edit -> {
                    //Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
                R.id.action_delete -> {
                    //Toast.makeText(this@MainActivity, item.title, Toast.LENGTH_SHORT).show()
                }
            }

            true
        }

        popup.show()
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val card: CardView = itemView.findViewById(R.id.friend_card)
        val name: TextView = itemView.findViewById(R.id.name)
        val lat: TextView = itemView.findViewById(R.id.lat)
        val lgt: TextView = itemView.findViewById(R.id.lgt)
        val menuBtn: ImageButton = itemView.findViewById(R.id.menu_btn)
    }
}
