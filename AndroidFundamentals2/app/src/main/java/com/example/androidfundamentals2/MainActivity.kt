package com.example.androidfundamentals2

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.datastore.core.DataStore
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.androidfundamentals2.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.util.prefs.Preferences

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var dataStore: DataStore<androidx.datastore.preferences.core.Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
//        val getImage = registerForActivityResult(
//            ActivityResultContracts.GetContent(),
//            {
//                binding.ivPhoto.setImageURI(it)
//            }
//        )
//
//        binding.btnChoosePhoto.setOnClickListener {
//            getImage.launch("image/*")
//        }

//        setSupportActionBar(binding.myToolbar)

//        val addContactDialog = AlertDialog.Builder(this)
//            .setTitle("Add contact")
//            .setMessage("Do you want to add a new contact?")
//            .setIcon(R.drawable.ic_add_contact)
//            .setPositiveButton("Yes") { _, _ ->
//                Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show()
//            }
//            .setNegativeButton("No") { _, _ ->
//                Toast.makeText(this, "Contact not added", Toast.LENGTH_SHORT).show()
//            }.create()
//
//        binding.button3.setOnClickListener {
//            addContactDialog.show()
//        }
//
//        val options = arrayOf("Call", "Send SMS", "Send Email")
//        val singleChoiceDialog = AlertDialog.Builder(this)
//            .setTitle("Choose an option")
//            .setSingleChoiceItems(options, 0) { _, which ->
//                Toast.makeText(this, "You selected ${options[which]}", Toast.LENGTH_SHORT).show()
//            }
//            .setPositiveButton("OK") { _, _ ->
//                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
//            }
//            .setNegativeButton("Cancel") { _, _ ->
//                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
//            }.create()
//
//        binding.button4.setOnClickListener {
//            singleChoiceDialog.show()
//        }
//
//        val multiChoiceDialog = AlertDialog.Builder(this)
//            .setTitle("Choose an option")
//            .setMultiChoiceItems(
//                options,
//                booleanArrayOf(false, false, false)
//            ) { _, which, isChecked ->
//                if (isChecked)
//                    Toast.makeText(this, "You selected ${options[which]}", Toast.LENGTH_SHORT)
//                        .show()
//                else
//                    Toast.makeText(this, "You unselected ${options[which]}", Toast.LENGTH_SHORT)
//                        .show()
//            }
//            .setPositiveButton("OK") { _, _ ->
//                Toast.makeText(this, "OK", Toast.LENGTH_SHORT).show()
//            }
//            .setNegativeButton("Cancel") { _, _ ->
//                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
//            }.create()
//
//        binding.button5.setOnClickListener {
//            multiChoiceDialog.show()
//        }

//        val customList = listOf("Amogus", "Sus", "Imposter", "Crewmate")
//        val customAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, customList)
//        binding.spMonths.adapter = customAdapter
//
//        binding.spMonths.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onItemSelected(
//                adapterView: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                Toast.makeText(this@MainActivity, "You selected ${adapterView?.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//        }

//        var todos = mutableListOf<Todo>(
//            Todo(
//                "Learn Kotlin", true
//            ), Todo(
//                "Learn Android", true
//            ), Todo(
//                "Build Android Apps", false
//            ), Todo(
//                "Publish Apps on Play Store", false
//            ), Todo(
//                "Become a Billionaire", false
//            ), Todo(
//                "Buy a Tesla", false
//            ), Todo(
//                "Buy a Mansion", false
//            ), Todo(
//                "Buy a Yacht", false
//            ), Todo(
//                "Buy a Private Jet", false
//            ), Todo(
//                "Buy a Rocket", false
//            ), Todo(
//                "Buy a Spaceship", false
//            ), Todo(
//                "Buy a Planet", false
//            ), Todo(
//                "Buy a Galaxy", false
//            )
//        )
//
//        val adapter = TodoAdapter(todos)
//        binding.rvTodos.adapter = adapter
//        binding.rvTodos.layoutManager = LinearLayoutManager(this)
//
//        binding.btnAddTodo.setOnClickListener {
//            val title = binding.etTodo.text.toString()
//            val todo = Todo(title, false)
//            todos.add(todo)
//            adapter.notifyItemInserted(todos.size - 1)
//        }

//        val firstFragment = FirstFragment()
//        val secondFragment = SecondFragment()
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flFragment, firstFragment)
//            commit()
//        }
//
//        binding.button.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.flFragment, firstFragment)
//                addToBackStack(null)
//                commit()
//            }
//        }
//
//        binding.button2.setOnClickListener {
//            supportFragmentManager.beginTransaction().apply {
//                replace(R.id.flFragment, secondFragment)
//                addToBackStack(null)
//                commit()
//            }
//        }

//        val firstFragment = FirstFragment()
//        val secondFragment = SecondFragment()
//        val thirdFragment = ThirdFragment()
//
//        setCurrentFragment(firstFragment)
//
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when(it.itemId) {
//                R.id.miHome -> setCurrentFragment(firstFragment)
//                R.id.miMessages -> setCurrentFragment(secondFragment)
//                R.id.miProfile -> setCurrentFragment(thirdFragment)
//            }
//            true
//        }
//
//        binding.bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
//            number = 10
//            isVisible = true
//        }

//        val images = listOf(
//            R.drawable.img0,
//            R.drawable.img1,
//            R.drawable.img2,
//            R.drawable.img3,
//            R.drawable.img4,
//            R.drawable.img5
//        )
//
//        val adapter = ViewPagerAdapter(images)
//        binding.viewPager.adapter = adapter
//        binding.viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL
//        binding.viewPager.beginFakeDrag()
//        binding.viewPager.fakeDragBy(-40f)
//        binding.viewPager.endFakeDrag()

//        TabLayoutMediator(binding.tlImages, binding.viewPager) {tab, position ->
//            tab.text = "Tab ${position + 1}"
//        }.attach()
//
//        binding.tlImages.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, " ${tab?.text} selected", Toast.LENGTH_SHORT).show()
//
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, " ${tab?.text} unselected", Toast.LENGTH_SHORT).show()
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, " ${tab?.text} reselected", Toast.LENGTH_SHORT).show()
//            }
//        })

//        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
//        binding.drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//        binding.navView.setNavigationItemSelectedListener {
//            when(it.itemId) {
//                R.id.miHome -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
//                R.id.miMessages -> Toast.makeText(this, "Messages", Toast.LENGTH_SHORT).show()
//                R.id.miProfile -> Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
//            }
//            true
//        }

//        drawerLayout = findViewById(R.id.drawerLayout)
//
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//
//        val navigationView = findViewById<NavigationView>(R.id.nav_view)
//        navigationView.setNavigationItemSelectedListener(this)
//
//        val toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment()).commit()
//            navigationView.setCheckedItem(R.id.miHome)
//        }
*/
        dataStore = createDataStore(name = "settings")

        binding.btnSave.setOnLongClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toInt()
            val isAdult = binding.cbAdult.isChecked

            with (sharedPref.edit()) {
                putInt("age", age)
                apply()
            }

        }

        binding.btnLoad.setOnClickListener {
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult", false)

            binding.etName.setText(name)
            binding.etAge.setText(age.toString())
            binding.cbAdult.isChecked = isAdult
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.miHome -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment()).commit()
            R.id.miProfile -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ThirdFragment()).commit()
            R.id.miMessages -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SecondFragment()).commit()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

//    override fun onBackPressed() {
//        if(drawerLayout.isDrawerOpen(GravityCompat.START))
//            drawerLayout.closeDrawer(GravityCompat.START)
//        else
//            onBackPressedDispatcher.onBackPressed()
//    }

//    private fun setCurrentFragment(fragment: Fragment) =
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.flFragment, fragment)
//            commit()
//        }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.app_bar_menu, menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId) {
//            R.id.miAddContact -> Toast.makeText(this, "Add Contact", Toast.LENGTH_SHORT).show()
//            R.id.miFavorites -> Toast.makeText(this, "Favorites", Toast.LENGTH_SHORT).show()
//            R.id.miSettings -> Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show()
//            R.id.miClose -> finish()
//            R.id.miFeedback -> Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT).show()
//        }
//        return true
//    }
}