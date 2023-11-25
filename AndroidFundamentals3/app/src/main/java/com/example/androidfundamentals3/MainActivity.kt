package com.example.androidfundamentals3

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.androidfundamentals3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var receiver: AriplaneModeChangedReceiver
    val CHANNEL_ID = "channelId"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_Id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val sharedPref = getPreferences(Context.MODE_PRIVATE)
//        val sharedPref = getSharedPreferences("userData", Context.MODE_PRIVATE)
//        val editor = sharedPref.edit()
//
//        binding.btnSave.setOnClickListener {
//            val age = binding.etAge.text.toString().toInt()
//            val name = binding.etName.text.toString()
//            val gender = binding.cbMale.isChecked
//
//            editor.apply {
//                putInt("age", age)
//                putString("name", name)
//                putBoolean("gender", gender)
//                apply()
//            }
//        }
//
//        binding.btnLoad.setOnClickListener {
//            val age = sharedPref.getInt("age", 0)
//            val name = sharedPref.getString("name", "")
//            val gender = sharedPref.getBoolean("gender", false)
//
//            binding.etAge.setText(age.toString())
//            binding.etName.setText(name)
//            binding.cbMale.isChecked = gender
//        }

//        ecreateNotificationChannel()

//        val intent = Intent(this, MainActivity::class.java)
//        val pendingIntent = TaskStackBuilder.create(this).run {
//            addNextIntentWithParentStack(intent)
//            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
//        }

//        val notificatoin = NotificationCompat.Builder(this, CHANNEL_ID)
//            .setContentTitle("Sus")
//            .setContentText("Amogus sussy baky")
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setPriority(NotificationCompat.PRIORITY_HIGH)
////            .setContentIntent(pendingIntent)
//            .build()
//
//        val notificationManager = NotificationManagerCompat.from(this)
//
//        binding.btnLoad.setOnClickListener {
//            if (ActivityCompat.checkSelfPermission(
//                    this,
//                    Manifest.permission.POST_NOTIFICATIONS
//                ) != PackageManager.PERMISSION_GRANTED
//            ) {
//                ActivityCompat.requestPermissions(
//                    this,
//                    arrayOf(Manifest.permission.POST_NOTIFICATIONS),
//                    1
//                )
////                return@setOnClickListener
//            }
//            notificationManager.notify(NOTIFICATION_Id, notificatoin)
//        }

//        binding.btnStart.setOnClickListener {
//            Intent(this, MyIntentService::class.java).also { intent ->
//                startService(intent)
//                binding.textView.text = "Service is running"
//            }
//        }
//
//        binding.btnStop.setOnClickListener {
//            MyIntentService.stopService()
//            binding.textView.text = "Service is stopped"
//        }

//        binding.btnStart.setOnClickListener {
//            Intent(this, MyService::class.java).also { intent ->
//                startService(intent)
//                binding.textView.text = "Service is running"
//            }
//        }
//
//        binding.btnStop.setOnClickListener {
//            Intent(this, MyService::class.java).also { intent ->
//                stopService(intent)
//                binding.textView.text = "Service is stopped"
//            }
//        }
//
//        binding.btnSendData.setOnClickListener {
//            Intent(this, MyService::class.java).also { intent ->
//                intent.putExtra("EXTRA_DATA", "Hello from MainActivity")
//                startService(intent)
//            }
//        }

//        binding.llTop.setOnDragListener(dragListener)
//        binding.llBottom.setOnDragListener(dragListener)
//
//        binding.dragView.setOnLongClickListener {
//            val clipText = "Hello from dragView"
//            Toast.makeText(this, clipText, Toast.LENGTH_SHORT).show()
//            val item = ClipData.Item(clipText)
//            val mimeType = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
//            val data = ClipData(clipText, mimeType, item)
//
//            val dragShadowBuilder = View.DragShadowBuilder(it)
//            it.startDragAndDrop(data, dragShadowBuilder, it, 0)
//
//            it.visibility = View.INVISIBLE
//            true
//        }

        receiver = AirplaneModeChangedReceiver()

        IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED).also {
            registerReceiver(AriplaneModeChangedReceiver(), it)
        }
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }

    val dragListener = View.OnDragListener {view, event ->
        when(event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }

            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }

            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }

            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup

                owner.removeView(v)

                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }

            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }

            else -> false

        }
    }

//    fun createNotificationChannel() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(
//                CHANNEL_ID,
//                CHANNEL_NAME,
//                NotificationManager.IMPORTANCE_DEFAULT
//            ).apply {
//                lightColor = Color.GREEN
//                enableLights(true)
//            }
//            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//            manager.createNotificationChannel(channel)
//        }
//    }
}