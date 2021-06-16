package hcmute.edu.vn.id18110339.DTO;

import java.io.Serializable;
import java.util.ArrayList;

public class ProductDTO implements Serializable {
    int _ProductId;
    int _ProductPrice;
    int _ProductCategoryId;
    String _ProductName;
    int _ProductImage;

    public  ProductDTO(){}
    public ProductDTO(int _ProductPrice, int _ProductCategoryId, String _ProductName) {
        this._ProductPrice = _ProductPrice;
        this._ProductCategoryId = _ProductCategoryId;
        this._ProductName = _ProductName;
    }

    public int get_ProductId() {
        return _ProductId;
    }

    public void set_ProductId(int _ProductId) {
        this._ProductId = _ProductId;
    }

    public int get_ProductPrice() {
        return _ProductPrice;
    }

    public void set_ProductPrice(int _ProductPrice) {
        this._ProductPrice = _ProductPrice;
    }

    public int get_ProductCategoryId() {
        return _ProductCategoryId;
    }

    public void set_ProductCategoryId(int _ProductCategoryId) {
        this._ProductCategoryId = _ProductCategoryId;
    }

    public String get_ProductName() {
        return _ProductName;
    }

    public void set_ProductName(String _ProductName) {
        this._ProductName = _ProductName;
    }

    public int get_ProductImage(){
        return _ProductImage;
    }

    public void set_ProductImage(int _ProductImage){
        this._ProductImage = _ProductImage;
    }

}
