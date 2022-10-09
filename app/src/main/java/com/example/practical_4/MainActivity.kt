package com.example.practical_4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn_ref_browser: Button
    lateinit var btn_ref_map: Button
    lateinit var btn_ref_Camera: Button
    lateinit var btn_ref_gallery: Button
    lateinit var btn_ref_contact: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_ref_browser = findViewById(R.id.btn_browser)
        btn_ref_map = findViewById(R.id.btn_map)
        btn_ref_Camera = findViewById(R.id.btn_Camera)
        btn_ref_gallery = findViewById(R.id.btn_Gallery)
        btn_ref_contact = findViewById(R.id.btn_contact)
        ImplicitIntent()
    }

    fun ImplicitIntent() {
        btn_ref_browser.setOnClickListener {
            Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")).also {
                startActivity(it)
            }
        }
        btn_ref_map.setOnClickListener {
            val addUri: Uri = Uri.parse("geo:0,0??=+GOA")
            val i1 = Intent(Intent.ACTION_VIEW, addUri)
            startActivity(i1)
        }
        btn_ref_Camera.setOnClickListener {
            Intent(MediaStore.ACTION_IMAGE_CAPTURE).also {
                startActivity(it)
            }
        }
        btn_ref_gallery.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType("IMAGE/").also {
                startActivity(it)
            }
        }
        btn_ref_contact.setOnClickListener {
            Intent(Intent.ACTION_VIEW).setType(ContactsContract.Contacts.CONTENT_TYPE).also {
                startActivity(it)
            }
        }
    }
}