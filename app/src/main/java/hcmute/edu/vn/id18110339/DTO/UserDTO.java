package hcmute.edu.vn.id18110339.DTO;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;

import java.io.Serializable;

public class UserDTO implements Serializable {
    SQLiteDatabase database;
    int _UserId;
    String _UserName;
    String _Password;
    String _UserPhone;
    public UserDTO(){   }
    public UserDTO(String name, String password, String phonenumber){
        this._UserName = name;
        this._Password = password;
        this._UserPhone = phonenumber;
    }

    public int get_UserId(){
        return this._UserId;
    }

    public void set_UserId(int id){
        this._UserId = id;
    }

    public String get_UserName(){
        return this._UserName;
    }

    public void set_UserName(String name){
        this._UserName = name;
    }

    public String get_UserPhone(){
        return this._UserPhone;
    }

    public void set_UserPhone(String phone_number){
        this._UserPhone = phone_number;
    }

    public String get_Password(){
        return  this._Password;
    }

    public void set_Password(String password){
        this._Password = password;
    }

    public boolean IsvalidUsername(){
        return !TextUtils.isEmpty(_UserName);
    }

    public boolean IsvalidPassword(){
        return !TextUtils.isEmpty(_Password);
    }

    public boolean IsvalidPhone(){
        return !TextUtils.isEmpty(_UserPhone);
    }

}
