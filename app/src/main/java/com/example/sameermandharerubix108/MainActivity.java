package com.example.sameermandharerubix108;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Product>> listDataChild;
    List<Product> apple = new ArrayList<>();
    List<Product> samsung = new ArrayList<>();

    List<Product> productList = new ArrayList<>();
    List<Product> productList1 = new ArrayList<>();

    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expListView = findViewById(R.id.explst);
        db = new DatabaseHelper(this);

        // preparing list data


        addProducts();
        prepareListData();



        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_date) {

            Collections.sort(apple, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getDate().compareTo(t1.getDate());

                }
            });


            Collections.sort(samsung, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getDate().compareTo(t1.getDate());

                }
            });
            return true;
        }else if (id == R.id.action_quantity) {
            Collections.sort(apple, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getQuantity().compareTo(t1.getQuantity());

                }
            });

            Collections.sort(samsung, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getQuantity().compareTo(t1.getQuantity());

                }
            });
            return true;
        }else if (id == R.id.action_popularity) {
            Collections.sort(apple, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getRate().compareTo(t1.getRate());

                }
            });

            Collections.sort(samsung, new Comparator<Product>() {
                @Override
                public int compare(Product product, Product t1) {
                    listAdapter.notifyDataSetChanged();
                    return product.getRate().compareTo(t1.getRate());

                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Product>>();

        // Adding child data
        listDataHeader.add("Apple");
        listDataHeader.add("Samsung");


        Product product1 = new Product();
        product1.setName("IPhone 6");
        product1.setDate("2020-1-23");
        product1.setRate("3.5");
        product1.setQuantity("198");

        Product product2 = new Product();
        product2.setName("IPhone 6 s");
        product2.setDate("2020-4-13");
        product2.setRate("2.25");
        product2.setQuantity("138");


        Product product3 = new Product();
        product3.setName("IPhone 7");
        product3.setDate("2020-8-07");
        product3.setRate("2.25");
        product3.setQuantity("258");


        Product product4 = new Product();
        product4.setName("IPhone 8");
        product4.setDate("2010-8-07");
        product4.setRate("4.25");
        product4.setQuantity("345");


        Product product5 = new Product();
        product5.setName("IPhone X");
        product5.setDate("2018-4-27");
        product5.setRate("3.50");
        product5.setQuantity("675");

        Product product6 = new Product();
        product6.setName("IPhone XR");
        product6.setDate("2017-4-27");
        product6.setRate("4.50");
        product6.setQuantity("890");

        /*apple.add(product1);
        apple.add(product2);
        apple.add(product3);
        apple.add(product4);
        apple.add(product5);
        apple.add(product6);*/
        apple.addAll(db.getProduct("Apple"));
        samsung.addAll(db.getProduct("Samsung"));


//        productList.addAll(db.getProduct("apple"));
//        productList1.addAll(db.getProduct("samsung"));
        listDataChild.put(listDataHeader.get(0), apple); // Header, Child data
        listDataChild.put(listDataHeader.get(1), samsung);

    }
    private void addProducts(){


        Product product1 = new Product();
        product1.setBrand("Apple");
        product1.setName("IPhone 6");
        product1.setDate("2020-1-23");
        product1.setRate("3.5");
        product1.setQuantity("198");
        product1.setImg("https://static.toiimg.com/photo/54058303/Apple-iPhone-6-16GB.jpg");

        Product product2 = new Product();
        product2.setBrand("Apple");
        product2.setName("IPhone 6 s");
        product2.setDate("2020-4-13");
        product2.setRate("2.25");
        product2.setQuantity("138");
        product2.setImg("https://images-na.ssl-images-amazon.com/images/I/51S6zG2dEVL._SL1024_.jpg");


        Product product3 = new Product();
        product3.setBrand("Apple");
        product3.setName("IPhone 7");
        product3.setDate("2020-8-07");
        product3.setRate("2.25");
        product3.setQuantity("258");
        product3.setImg("https://images-na.ssl-images-amazon.com/images/I/41ClQ3J0gjL._SL1000_.jpg");


        Product product4 = new Product();
        product4.setBrand("Apple");
        product4.setName("IPhone 8");
        product4.setDate("2010-8-07");
        product4.setRate("4.25");
        product4.setQuantity("345");
        product4.setImg("https://st1.bgr.in/wp-content/uploads/2017/09/apple-iphone-8-plus-back.jpg");


        Product product5 = new Product();
        product5.setBrand("Apple");
        product5.setName("IPhone X");
        product5.setDate("2018-4-27");
        product5.setRate("3.50");
        product5.setQuantity("675");
        product5.setImg("https://store.storeimages.cdn-apple.com/4982/as-images.apple.com/is/refurb-iphoneX-silver_AV2?wid=1144&hei=1144&fmt=jpeg&qlt=80&op_usm=0.5,0.5&.v=1548459943718");

        Product product6 = new Product();
        product6.setBrand("Apple");
        product6.setName("IPhone XR");
        product6.setDate("2017-4-27");
        product6.setRate("4.50");
        product6.setQuantity("890");
        product6.setImg("https://s1.poorvikamobile.com/image/data/AAAAA/Apple/Iphone%20XR/red/New/Apple-iPhone-XR-BACK_ios.jpeg");

        Product product7 = new Product();
        product7.setBrand("Samsung");
        product7.setName("S7");
        product7.setDate("2015-5-27");
        product7.setRate("4.50");
        product7.setQuantity("890");
        product7.setImg("https://www.gizmochina.com/wp-content/uploads/2016/09/carousel-samsung-galaxy-s7-edge-silver-titanium-380x380-1-420x420.jpg");

        Product product8 = new Product();
        product8.setBrand("Samsung");
        product8.setName("S8");
        product8.setDate("2012-2-17");
        product8.setRate("2.25");
        product8.setQuantity("490");
        product8.setImg("https://images-na.ssl-images-amazon.com/images/I/61B0qTsNumL._SX679_.jpg");

        Product product9 = new Product();
        product9.setBrand("Samsung");
        product9.setName("S9");
        product9.setDate("2010-4-17");
        product9.setRate("3.75");
        product9.setQuantity("190");
        product9.setImg("https://s3b.cashify.in/gpro/uploads/2019/06/02182754/samsung-galaxy-s9-001.jpg");

        Product product10 = new Product();
        product10.setBrand("Samsung");
        product10.setName("S10");
        product10.setDate("2018-7-30");
        product10.setRate("5.0");
        product10.setQuantity("789");
        product10.setImg("https://i.gadgets360cdn.com/products/large/1550692389_635_samsung_galaxy_s10.jpg");

        Product product11 = new Product();
        product11.setBrand("Samsung");
        product11.setName("Note 7");
        product11.setDate("2019-6-01");
        product11.setRate("3.25");
        product11.setQuantity("234");
        product11.setImg("https://drop.ndtv.com/TECH/product_database/images/82201685704PM_635_samsung_galaxy_note7.jpeg");

        Product product12 = new Product();
        product12.setBrand("Samsung");
        product12.setName("Note 8");
        product12.setDate("2015-6-01");
        product12.setRate("3.50");
        product12.setQuantity("783");
        product12.setImg("https://www.91-img.com/pictures/111232-v1-samsung-galaxy-note-8-mobile-phone-large-1.jpg");

        Product product13 = new Product();
        product13.setBrand("Samsung");
        product13.setName("Note 9");
        product13.setDate("2016-6-21");
        product13.setRate("4.25");
        product13.setQuantity("782");
        product13.setImg("https://i.gadgets360cdn.com/products/large/1533829125_635_samsung_galaxy_note_9_stylus.jpg");

        Product product14 = new Product();
        product14.setBrand("Samsung");
        product14.setName("Note 10");
        product14.setDate("2020-6-01");
        product14.setRate("4.50");
        product14.setQuantity("586");
        product14.setImg("https://images-na.ssl-images-amazon.com/images/I/71QIWoR7EZL._SX522_.jpg");







        long id1 = db.insertProduct(product1);
        long id2 = db.insertProduct(product2);
        long id3 = db.insertProduct(product3);
        long id4 = db.insertProduct(product4);
        long id5 = db.insertProduct(product5);
        long id6 = db.insertProduct(product6);
        long id7 = db.insertProduct(product7);
        long id8 = db.insertProduct(product8);
        long id9 = db.insertProduct(product9);
        long id10 = db.insertProduct(product10);
        long id11 = db.insertProduct(product11);
        long id12 = db.insertProduct(product12);
        long id13 = db.insertProduct(product13);
        long id14 = db.insertProduct(product14);


        List<Product>products1 = db.getProduct("Apple");
        for(int i= 0; i<products1.size();i++) {
            Log.e("Brand", products1.get(i).getBrand());
            Log.e("Id", products1.get(i).getId() + "");
            Log.e("Quantity", products1.get(i).getQuantity());
            Log.e("Rate", products1.get(i).getRate());
        }
        // get the newly inserted note from db
//        Note n = db.getNote(id);
        List<Product>products = db.getProduct("Samsung");
        for(int i= 0; i<products.size();i++){
            Log.e("Brand",products.get(i).getBrand());
            Log.e("Id",products.get(i).getId()+"");
            Log.e("Quantity",products.get(i).getQuantity());
            Log.e("Rate",products.get(i).getRate());
//            Log.e("Image",products.get(i).getImg());

        }
    }
}