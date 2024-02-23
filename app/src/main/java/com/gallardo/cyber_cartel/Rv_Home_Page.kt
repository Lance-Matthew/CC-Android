package com.gallardo.cyber_cartel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Rv_Home_Page : AppCompatActivity() {


    private var recyclerView : RecyclerView? = null
    private var rv_homepage_Adapter : rv_homepage_Adapter? = null
    private var productList = mutableListOf<Rv_hompage_dataclass>()

    //CATEGORIES PART
    private lateinit var homepagecategoriesRV : RecyclerView
    private var categories_dataClass = mutableListOf<home_page_categories_DC>()
    private var home_page_categories_adapter : home_page_categories_adapter? = null

    private lateinit var amdlogo : ImageView
    private lateinit var intellogo : ImageView
    private lateinit var cartlogo : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv_home_page)

        amdlogo = findViewById(R.id.img_amd_builder)
        intellogo = findViewById(R.id.img_intel_builder)
        cartlogo = findViewById(R.id.img_cart_homepage)

        amdlogo.setOnClickListener(){
            val intent = Intent(this, Rv_amd_build::class.java)
            startActivity(intent)
        }

        intellogo.setOnClickListener(){
            val intent = Intent(this, Rv_intel_build::class.java)
            startActivity(intent)
        }
        cartlogo.setOnClickListener(){
            val intent = Intent(this, Rv_cart::class.java)
            startActivity(intent)
        }


        productList = ArrayList()
       categories_dataClass = ArrayList()

        homepagecategoriesRV = findViewById<View>(R.id.recyclerView_Categories) as RecyclerView
        home_page_categories_adapter = home_page_categories_adapter(this@Rv_Home_Page,categories_dataClass )
        val catlayoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this,RecyclerView.HORIZONTAL,false)
        homepagecategoriesRV!!.layoutManager = catlayoutManager
        homepagecategoriesRV!!.adapter = home_page_categories_adapter

        prepareiconListData()


        recyclerView= findViewById<View>(R.id.mainContainer) as RecyclerView
        rv_homepage_Adapter = rv_homepage_Adapter(this@Rv_Home_Page,productList)
        val layoutManager : RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recyclerView!!.layoutManager = layoutManager
        recyclerView!!.adapter = rv_homepage_Adapter

        prepareProductData()
        
    }

    private fun prepareiconListData() {
       var icon = home_page_categories_DC(R.drawable.cpubg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.gpubg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.hddbg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.mobobg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.psubg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.rambg)
        categories_dataClass.add(icon)
        icon = home_page_categories_DC(R.drawable.ssdbg)
        categories_dataClass.add(icon)
    }


    private fun prepareProductData() {
        var product = Rv_hompage_dataclass("CPU", "10,000P",R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)
        product = Rv_hompage_dataclass("CPU", "10,000P", R.drawable.cpu_product1)
        productList.add(product)


    }
}