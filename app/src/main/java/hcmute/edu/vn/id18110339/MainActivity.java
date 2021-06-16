package hcmute.edu.vn.id18110339;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import hcmute.edu.vn.id18110339.DAO.CategoryDAO;
import hcmute.edu.vn.id18110339.DAO.ProductDAO;
import hcmute.edu.vn.id18110339.DAO.UserDAO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;

public class MainActivity extends AppCompatActivity {
    ImageButton SignUp, Login;
    UserDAO userDAO;
    EditText edUserName, edPassword;
    TextView ForgotPassword;
    ImageView SeePass;
    public UserDTO userDTO;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String USERNAME_KEY = "username";
    String PASSWORD_KEY = "password";
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /*DatabaseHandle db = new DatabaseHandle(this);
        db.onUpgrade(db.Open(), 4,5);*/

        //
        //insert data category
        CategoryDAO categoryDAO = new CategoryDAO(getApplicationContext());
        categoryDAO.AddCategory("Fruit");
        categoryDAO.AddCategory("Drink");
        categoryDAO.AddCategory("IceCream");
        categoryDAO.AddCategory("Cake");
        //
        //

        //
        //insert data user
        UserDAO userDAO_inset = new UserDAO(getApplicationContext());
        //userDAO_inset.AddUser("phuc","123","0333213812");
        //
        //
        //
        //insert data product
        ProductDAO productDAO = new ProductDAO(getApplicationContext());
        productDAO.AddProduct(1, "Aplle", 15000, R.drawable.apple);
        productDAO.AddProduct(1, "Banana", 23000, R.drawable.banana);
        productDAO.AddProduct(1, "Water melon", 10000, R.drawable.watermelon);
        //productDAO.AddProduct(1, "Orange", 20000, R.drawable.orange);
        productDAO.AddProduct(1, "Chery", 7000, R.drawable.chery);
        productDAO.AddProduct(1, "Mango", 12000, R.drawable.mango);
        //productDAO.AddProduct(1, "Avocado", 21000, R.drawable.avocado);
        productDAO.AddProduct(1, "Coconut", 1000, R.drawable.coconut);
        productDAO.AddProduct(1, "Kiwi", 25000, R.drawable.kiwi);
        //productDAO.AddProduct(1, "Grape", 27000, R.drawable.grape);
        //
        //productDAO.AddProduct(2, "Cocacola", 11000, R.drawable.cocacola);
        productDAO.AddProduct(2, "Pepsi", 12000, R.drawable.pepsi);
        productDAO.AddProduct(2, "String", 8000, R.drawable.sting);
        productDAO.AddProduct(2, "Revive", 8000, R.drawable.rivive);
        productDAO.AddProduct(2, "Fanta", 7000, R.drawable.fanta);
        //productDAO.AddProduct(2, "Mirinda", 12000, R.drawable.mirinda);
        productDAO.AddProduct(2, "Seven Up", 9000, R.drawable.sevenup);
        //
        productDAO.AddProduct(3, "Milk Cream", 15000, R.drawable.milkcream);
        productDAO.AddProduct(3, "Socola Cream", 23000, R.drawable.socolacream);
        productDAO.AddProduct(3, "Strawberry Cream", 10000, R.drawable.strawberrycream);
        //productDAO.AddProduct(3, "Mix Cream", 20000, R.drawable.mixcream);
        //
        productDAO.AddProduct(4, "Oreo", 15000, R.drawable.oreo);
        //productDAO.AddProduct(4, "AFC", 23000, R.drawable.afc);
        //productDAO.AddProduct(4, "Cosy", 10000, R.drawable.cosy);
        productDAO.AddProduct(4, "Gery", 20000, R.drawable.gery);
        //

        userDAO = new UserDAO(this);
        ForgotPassword = (TextView)findViewById(R.id.tvBackToLogin);
        SignUp = (ImageButton) findViewById(R.id.btnSignUp);
        Login = (ImageButton) findViewById(R.id.btnSignIn);
        SeePass = (ImageView)findViewById(R.id.imseepass);
        checkBox = (CheckBox) findViewById(R.id.checkBox) ;

        edUserName = (EditText)findViewById(R.id.edUserName);
        edPassword = (EditText)findViewById(R.id.edPhone);
        edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        final int[] flag = {0};
        sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        String s = sharedPreferences.getString(USERNAME_KEY,"phuc");
        if(s != null){
            edUserName.setText(sharedPreferences.getString(USERNAME_KEY,""));
            edPassword.setText(sharedPreferences.getString(PASSWORD_KEY,""));
            edUserName.setSelection(edUserName.length());
            edPassword.setSelection(edPassword.length());
        }


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Signup.class);
                startActivity(intent);
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edUserName.getText().toString();
                String password = edPassword.getText().toString();

                userDTO = userDAO.CheckLogin(username,password);
                if(userDTO == null){
                    Toast.makeText(getBaseContext(), "Sign In Fail",Toast.LENGTH_SHORT).show();
                }else {
                    if(checkBox.isChecked()){
                        editor = sharedPreferences.edit();
                        editor.putString(USERNAME_KEY, edUserName.getText().toString().trim());
                        editor.putString(PASSWORD_KEY, edPassword.getText().toString().trim());
                        editor.commit();
                    }
                    Intent intent = new Intent(getBaseContext(), ControlActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("user", userDTO);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Forgetpw.class);
                startActivity(intent);
            }
        });

        SeePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag[0] == 0){
                    edPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    SeePass.setImageResource(R.drawable.baseline_visibility_24);
                    edPassword.setSelection(edPassword.length());
                    flag[0] = 1 ;
                }
                else {
                    edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    SeePass.setImageResource(R.drawable.baseline_visibility_off_24);
                    edPassword.setSelection(edPassword.length());
                    flag[0] = 0;
                }
            }
        });
    }
}