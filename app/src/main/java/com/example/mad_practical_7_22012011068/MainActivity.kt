package com.example.madpractical_7_22012011068

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mad_practical_7_22012011068.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var personAdapter: PersonAdapter
    private lateinit var recyclerView: RecyclerView
    private val personList = mutableListOf<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        personAdapter = PersonAdapter(personList)
        recyclerView.adapter = personAdapter

        // Fetch data and update UI
        fetchData()
    }

    private fun fetchData() {
        CoroutineScope(Dispatchers.IO).launch {
            // TODO: Replace with your actual API call logic
            val fetchedPersons = fetchPersonsFromApi()

            // Update the person list and notify adapter on the main thread
            runOnUiThread {
                personList.clear()
                personList.addAll(fetchedPersons)
                personAdapter.notifyDataSetChanged()
            }
        }
    }

    // Sample function to fetch data from API (replace with actual API call)
    private fun fetchPersonsFromApi(): List<Person> {
        // Simulate fetching data from an API
        return listOf(
            Person("1", "John Doe", "johndoe@example.com", "123 Main St", 1234567890, 37.7749, -122.4194),
            Person("2", "Jane Smith", "janesmith@example.com", "456 Park Ave", 9876543210, 34.0522, -118.2437)
        )
    }
}