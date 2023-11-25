package com.example.androidfundamentals

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.example.androidfundamentals.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        binding.btnSubmit.setOnClickListener {
//            val firstName = binding.etFirstName.text.toString()
//            val lastName = binding.etLastName.text.toString()
//            val birthDate = binding.etBirthDate.text.toString()
//            val country = binding.etCountry.text.toString()
//            Log.d("MainActivity", "First name: $firstName, Last name: $lastName, Birth date: $birthDate, Country: $country")
//        }

//        var count = 0
//        binding.btnCount.setOnClickListener {
//            val count = binding.tvCount.text.toString().toInt()
//            binding.tvCount.text = (count + 1).toString()
//        }

//        binding.btnAdd.setOnClickListener {
//            val firstNumber = binding.etNum1.text.toString().toInt()
//            val secondNumber = binding.etNum2.text.toString().toInt()
//            val result = firstNumber + secondNumber
//            binding.tvResult.text = result.toString()
//        }

//        binding.btnAddImage.setOnClickListener {
//            binding.ivWolf.setImageResource(R.drawable.wolf)
//        }

//        binding.btnOrder.setOnClickListener {
//            val checkedMeatRadioButtonId = binding.rgMeat.checkedRadioButtonId
//            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)
//            val cheese = binding.cbCheese.isChecked
//            val onions = binding.cbOnion.isChecked
//            val salad = binding.cbSalad.isChecked
//
//            val orderString = "You ordered a burger with:\n" +
//                    "${meat.text}" +
//                    (if (cheese) "\nCheese" else "") +
//                    (if (onions) "\nOnions" else "") +
//                    (if (salad) "\nSalad" else "")
//
//            binding.tvOrder.text = orderString
//            Toast.makeText(this, orderString, Toast.LENGTH_SHORT).show()
////            Toast(this).apply {
////                duration = Toast.LENGTH_LONG
////                view = layoutInflater.inflate(R.layout.custom_toast, binding.root)
////                show()
//            }
//        }

//        binding.btnStart.setOnClickListener {
//            Intent(this, SecondActivity::class.java).also {
//                startActivity(it)
//            }
//        }

//        binding.btnApply.setOnClickListener {
//            val name = binding.etName.text.toString()
//            val age = binding.etAge.text.toString().toInt()
//
//            val person = Person(name, age)
//
//            Intent(this, ThirdActivity::class.java).also {
//                it.putExtra("PERSON", person)
//                startActivity(it)
//            }
//        }

//        binding.btnRequestPermission.setOnClickListener{
//            Toast.makeText(this, "Requesting permission", Toast.LENGTH_SHORT).show()
//            requestPermissions()
//        }

        binding.btnTakePhoto.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode  == Activity.RESULT_OK && requestCode == 0) {
            val uri = data?.data
            binding.ivPhoto.setImageURI(uri)
        }
    }
//
//    private fun hasWriteExternalStoragePermission() =
//        ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.WRITE_EXTERNAL_STORAGE
//        ) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasLocationForegroundPermission() =
//        ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_COARSE_LOCATION
//        ) == PackageManager.PERMISSION_GRANTED
//
//    private fun hasLocationBackgroundPermission() =
//        ActivityCompat.checkSelfPermission(
//            this,
//            Manifest.permission.ACCESS_BACKGROUND_LOCATION
//        ) == PackageManager.PERMISSION_GRANTED
//
//    private fun requestPermissions() {
//        var permissionsToRequest = mutableListOf<String>()
//        if(!hasWriteExternalStoragePermission()) {
//            permissionsToRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE)
//        }
//        if(!hasLocationForegroundPermission()) {
//            permissionsToRequest.add(Manifest.permission.ACCESS_COARSE_LOCATION)
//        }
//        if(!hasLocationBackgroundPermission() && hasLocationForegroundPermission()) {
//            permissionsToRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
//        }
//
//        if(permissionsToRequest.isNotEmpty()) {
//            ActivityCompat.requestPermissions(
//                this,
//                permissionsToRequest.toTypedArray(),
//                0
//            )
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//       super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(requestCode == 0 && grantResults.isNotEmpty()) {
//            for (i in permissions.indices) {
//                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) {
//                    Log.d("PermissionRequest", "${permissions[i]} granted.")
//                }
//            }
//        }
//    }
}