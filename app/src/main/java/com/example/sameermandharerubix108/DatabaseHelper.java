package com.example.sameermandharerubix108;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "products_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Product.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Drop older table if existed
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Product.TABLE_NAME);

        // Create tables again
        onCreate(sqLiteDatabase);

    }

    public long insertProduct(Product product){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Product.COLUMN_BRAND,product.getBrand());
        values.put(Product.COLUMN_MODEL,product.getName());
        values.put(Product.COLUMN_DATE,product.getDate());
        values.put(Product.COLUMN_QUANTITY,product.getQuantity());
        values.put(Product.COLUMN_RATE,product.getRate());
        values.put(Product.COLUMN_IMAGE,product.getImg());


        long id = db.insert(Product.TABLE_NAME,null,values);
        // close db connection
        db.close();

        return id;
    }

    List<Product> getProduct(String name){
        List<Product> products = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Product.TABLE_NAME,
                new String[]{Product.COLUMN_ID, Product.COLUMN_BRAND,
                        Product.COLUMN_MODEL,
                        Product.COLUMN_DATE,
                        Product.COLUMN_QUANTITY,
                        Product.COLUMN_RATE,
                        Product.COLUMN_IMAGE,
                        Product.COLUMN_TIMESTAMP},
                Product.COLUMN_BRAND + "=?",
                new String[]{name}, null, null, null, null);


        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Product product = new Product();
                product.setId(cursor.getInt(cursor.getColumnIndex(Product.COLUMN_ID)));
                product.setBrand(cursor.getString(cursor.getColumnIndex(Product.COLUMN_BRAND)));
                product.setName(cursor.getString(cursor.getColumnIndex(Product.COLUMN_MODEL)));
                product.setDate(cursor.getString(cursor.getColumnIndex(Product.COLUMN_DATE)));
                product.setRate(cursor.getString(cursor.getColumnIndex(Product.COLUMN_RATE)));
                product.setQuantity(cursor.getString(cursor.getColumnIndex(Product.COLUMN_QUANTITY)));
                product.setImg(cursor.getString(cursor.getColumnIndex(Product.COLUMN_IMAGE)));
                product.setTimestamp(cursor.getString(cursor.getColumnIndex(Product.COLUMN_TIMESTAMP)));
                products.add(product);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();
        return products;

    }
}
