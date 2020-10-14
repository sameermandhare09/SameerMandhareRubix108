package com.example.sameermandharerubix108;

public class Product {

    String img = null;
    String date = null;
    String name = null;
    String brand = null;
    String quantity = null;
    String rate = "0.0";
    private String timestamp;
    private int id;

    public Product() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }


    public static final String COLUMN_ID = "id";
    public static final String COLUMN_BRAND = "brand";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_QUANTITY = "quantity";
    public static final String COLUMN_RATE = "rate";
    public static final String COLUMN_MODEL = "model";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_DATE= "date";

    public static final String TABLE_NAME = "products";



    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_BRAND + " TEXT,"
                    + COLUMN_QUANTITY + " TEXT,"
                    + COLUMN_RATE + " TEXT,"
                    + COLUMN_MODEL + " TEXT,"
                    + COLUMN_IMAGE + " TEXT,"
                    + COLUMN_DATE + " TEXT,"
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";


    public Product(String img, String date, String name, String quantity, String rate, String timestamp, int id) {
        this.img = img;
        this.date = date;
        this.name = name;
        this.quantity = quantity;
        this.rate = rate;
        this.timestamp = timestamp;
        this.id = id;
    }
}
