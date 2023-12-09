package com.example.sqlite.db.entity;

public class Contact {

    // constants for database
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_NAME = "name";

    // variables
    private String name;
    private String email;
    private int id;

    // constructors
    public Contact() {
    }

    public Contact(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // sql query to create table
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_EMAIL + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";
}
