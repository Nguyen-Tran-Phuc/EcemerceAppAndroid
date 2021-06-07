package hcmute.edu.vn.id18110339;

import java.util.ArrayList;

public class product {
    int _ProductId;
    int _ProductPrice;
    int _ProductCategoryId;
    String _ProductName;
    public product(){   }
    public product(int id,int price,int ProCateId,  String name){
        this._ProductId = id;
        this._ProductPrice = price;
        this._ProductCategoryId = ProCateId;
        this._ProductName = name;
    }

    public int get_ProductId(){
        return this._ProductId;
    }

    public void set_ProductId(int id){
        this._ProductId = id;
    }

    public  int get_ProductPrice(){
        return this._ProductPrice;
    }

    public void set_ProductPrice(int price){
        this._ProductPrice = price;
    }

    public  int get_ProductCategoryId(){
        return this._ProductCategoryId;
    }

    public void set_ProductCategoryId(int ProcateId){
        this._ProductCategoryId = ProcateId;
    }

    public String get_ProductName(){
        return this._ProductName;
    }

    public void set_ProductName(String name){
        this._ProductName = name;
    }

    public static ArrayList<product> createProductList(int numProduct){
        ArrayList<product> products = new ArrayList<product>();
        for (int i = 0;i< numProduct;i++){
            products.add(new product(i,1000,i,"cocacola"));
        }
        return  products;
    }
}
