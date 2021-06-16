package hcmute.edu.vn.id18110339.FragmentApp;


import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.edu.vn.id18110339.DAO.UserDAO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.MainActivity;
import hcmute.edu.vn.id18110339.R;

public class InfoFragment extends Fragment {
    private UserDTO user;

    private ImageButton btn_edit, btn_logout;
    private int flag = 0;
    private TextView tv_edit_save;

    public InfoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        user = (UserDTO) getArguments().getSerializable("user");


        EditText editText = view.findViewById(R.id.info_edUserName);
        editText.setText(user.get_UserName());
        editText.setEnabled(false);
        EditText phone = view.findViewById(R.id.info_edPhone);
        phone.setText(user.get_UserPhone());
        phone.setEnabled(false);
        EditText password = view.findViewById(R.id.info_edpassword);
        password.setText(user.get_Password());
        password.setEnabled(false);

        btn_edit = (ImageButton) view.findViewById(R.id.btnEdit);
        btn_logout = (ImageButton) view.findViewById(R.id.btnLogout);
        tv_edit_save = (TextView) view.findViewById(R.id.tv_edit);

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 0){
                    editText.setEnabled(true);
                    phone.setEnabled(true);
                    password.setEnabled(true);
                    tv_edit_save.setText("Save Change");
                    flag = 1;
                }
                else {
                    editText.setEnabled(false);
                    phone.setEnabled(false);
                    password.setEnabled(false);
                    tv_edit_save.setText("Edit");
                    UserDAO userDAO = new UserDAO(getContext());
                    long check = userDAO.update(editText.getText().toString().trim(), phone.getText().toString().trim(), password.getText().toString().trim(), user.get_UserId());
                    if(check == 1){
                        Toast.makeText(getContext(), "Update success", Toast.LENGTH_SHORT).show();
                    }
                    flag = 0;
                }
            }
        });

        return view;
    }
}