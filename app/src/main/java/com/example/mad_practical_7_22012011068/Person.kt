package com.example.madpractical_7_22012011068

import org.json.JSONObject
import java.io.Serializable

data class Person(
    var id: String,
    var name: String,
    var emailId: String,
    var address: String,
    var phone: Long,
    var latitude: Double,
    var longitude: Double
) : Serializable {

    // Secondary constructor to create a Person object from a JSON object
    constructor(jsonObject: JSONObject) : this(
        id = jsonObject.optString("id", ""),
        name = jsonObject.optString("name", ""),
        emailId = jsonObject.optString("email", ""),
        address = jsonObject.optString("address", ""),
        phone = jsonObject.optLong("phone", 0),
        latitude = jsonObject.optDouble("latitude", 0.0),
        longitude = jsonObject.optDouble("longitude", 0.0)
    )
}