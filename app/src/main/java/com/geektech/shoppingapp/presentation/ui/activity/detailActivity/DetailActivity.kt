package com.geektech.shoppingapp.presentation.ui.activity.detailActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.shoppingapp.R
import com.geektech.shoppingapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(R.layout.activity_detail) {

    private val binding: ActivityDetailBinding by viewBinding(ActivityDetailBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnAddItem.setOnClickListener {
            val intent = Intent()
            intent.putExtra("detailName", binding.etName.text.toString())
            intent.putExtra("detailCount", binding.etCount.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}
