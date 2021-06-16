package hcmute.edu.vn.id18110339;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import hcmute.edu.vn.id18110339.DAO.UserDAO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;

public class Signup extends AppCompatActivity {
    ImageButton SignUp;
    UserDAO userDAO;
    EditText edName, edpassword, edPhone, edConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        userDAO = new UserDAO(this);
        SignUp = (ImageButton) findViewById(R.id.btnSignUp);
        edName = (EditText)findViewById(R.id.edUserName);
        edpassword = (EditText)findViewById(R.id.edPassword);
        edPhone = (EditText)findViewById(R.id.edPhone) ;
        edConfirm = (EditText)findViewById(R.id.edConfirm) ;

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edName.getText().toString().trim();
                String password = edpassword.getText().toString().trim();
                String phonenumber = edPhone.getText().toString().trim();
                String confirm = edConfirm.getText().toString().trim();
                UserDTO userDTO = new UserDTO(username,password,phonenumber);
                if(!(userDTO.IsvalidUsername())){
                    Toast.makeText(Signup.this, "Please fill user name", Toast.LENGTH_SHORT).show();
                }
                else if(!(userDTO.IsvalidPhone())){
                    Toast.makeText(Signup.this, "Please fill phone number", Toast.LENGTH_SHORT).show();
                }
                else if(!(userDTO.IsvalidPassword())){
                    Toast.makeText(Signup.this, "Please fill phone password", Toast.LENGTH_SHORT).show();
                }
                else if(password.compareTo(confirm)!=0){
                    Toast.makeText(Signup.this, "The password not match", Toast.LENGTH_SHORT).show();
                }
                else {
                    long check = userDAO.AddUser(username, password,phonenumber);
                    if(check > 0){
                        Toast.makeText(Signup.this, "Create Account Success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getBaseContext(), MainActivity.class);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Signup.this, "Create Account Fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
