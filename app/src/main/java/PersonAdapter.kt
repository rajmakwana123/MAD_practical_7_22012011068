package com.example.madpractical_7_22012011068

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_practical_7_22012011068.R

class PersonAdapter(private val personList: List<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val emailTextView: TextView = itemView.findViewById(R.id.email)
        val phoneTextView:TextView=itemView.findViewById(R.id.phone_no)
        val addressTextView:TextView=itemView.findViewById(R.id.address)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = personList[position]
        holder.nameTextView.text = person.name
        holder.emailTextView.text = person.emailId
    }

    override fun getItemCount(): Int {
        return personList.size
    }
}