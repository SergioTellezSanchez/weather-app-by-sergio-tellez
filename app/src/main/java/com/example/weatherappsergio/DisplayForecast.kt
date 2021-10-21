package com.example.weatherappsergio

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.weatherappsergio.constants.SELECTED_CITY
import com.example.weatherappsergio.databinding.ActivityDisplayForecastBinding
import com.example.weatherappsergio.viewmodels.DisplayForecastViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DisplayForecast : AppCompatActivity() {

    private val viewModel: DisplayForecastViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityDisplayForecastBinding>(this, R.layout.activity_display_forecast)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.view = this
        val city = intent.getStringExtra(SELECTED_CITY).toString()
        viewModel.city = city
        viewModel.getForecastForSelectedCity()
    }

    fun displayForecastDetails(city: String?) {
        val intent = Intent(this, DisplayForecastDetails::class.java).apply {
            putExtra(SELECTED_CITY, city)
        }
        startActivity(intent)
    }
}