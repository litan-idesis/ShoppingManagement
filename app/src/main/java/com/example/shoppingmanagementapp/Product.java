package com.example.shoppingmanagementapp;

public class Product {
    private String name;
    private int quantity;
    private boolean isSelected;  // שדה לבחירת מחיקה

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.isSelected = false;  // מוצר חדש לא מסומן למחיקה
    }

    // גטרים וסטרים
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public boolean isSelected() { return isSelected; }
    public void setSelected(boolean selected) { isSelected = selected; }
}
