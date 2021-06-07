package hcmute.edu.vn.id18110339;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

import hcmute.edu.vn.id18110339.DAO.UserDAO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.Database.DatabaseHandle;
import hcmute.edu.vn.id18110339.FragmentApp.HomeFragment;

public class MainActivity extends AppCompatActivity {
    ImageButton SignUp, Login;
    UserDAO userDAO;
    EditText edUserName, edPassword;
    TextView ForgotPassword;
    ImageView SeePass;
    public int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        /*DatabaseHandle db = new DatabaseHandle(this);
        db.onUpgrade(this, 1,2);*/

        userDAO = new UserDAO(this);
        ForgotPassword = (TextView)findViewById(R.id.tvBackToLogin);
        SignUp = (ImageButton) findViewById(R.id.btnSignUp);
        Login = (ImageButton) findViewById(R.id.btnSignIn);
        SeePass = (ImageView)findViewById(R.id.imseepass);

        edUserName = (EditText)findViewById(R.id.edUserName);
        edPassword = (EditText)findViewById(R.id.edPhone);
        edPassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        final int[] flag = {0};


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

                UserDAO userDAO = new UserDAO(getApplicationContext());
                UserDTO userDTO = userDAO.CheckLogin(username,password);
                id = userDTO.get_UserId();
                //Toast.makeText(MainActivity.this, userDTO.get_UserName(), Toast.LENGTH_SHORT).show();
                if(userDTO == null){

                }else {
                    Intent intent = new Intent(getBaseContext(), ControlFragment.class);
                    intent.putExtra("user",userDTO);
                    startActivity(intent);
                }
                /*UserDTO userDTO = new UserDTO(username, password,null);
                if(userDTO.IsvalidPassword() && userDTO.IsvalidUsername()){
                    boolean check = userDAO.CheckLogin(username,password);
                    if(check){
                        Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), ControlFragment.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }*/
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