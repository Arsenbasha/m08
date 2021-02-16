package com.arsenbasha.testeo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.arsenbasha.testeo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val viewModel = makeApicall()
        setupBinding(viewModel)
    }

    fun setupBinding(viewModel: Model) {
        val activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        activityMainBinding.setVariable(BR.viewModel, viewModel)
        activityMainBinding.executePendingBindings()
        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(this@MainActivity, VERTICAL)
            addItemDecoration(decoration)
        }

    }

    fun makeApicall(): Model {
        val viewModel = ViewModelProviders.of(this).get(Model::class.java)
        viewModel.getRecyclerListDataObeserver().observe(this, Observer<RecycleViewList> {
            findViewById<ProgressBar>(R.id.progressbar).visibility= GONE

            if (it != null) {
                //update the adapter
                viewModel.setAdapterData(it.item)
            } else {
                Toast.makeText(this@MainActivity, "Error in fetching data", Toast.LENGTH_LONG)
                    .show()
            }
        })
        viewModel.makeApi("newyork")

        return viewModel
    }
}