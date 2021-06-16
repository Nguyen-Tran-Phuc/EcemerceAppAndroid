package hcmute.edu.vn.id18110339;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;
import com.aurelhubert.ahbottomnavigation.notification.AHNotification;

import java.util.ArrayList;

import hcmute.edu.vn.id18110339.DAO.OrderDAO;
import hcmute.edu.vn.id18110339.DTO.OrderDTO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.FragmentApp.DetailProductFragment;
import hcmute.edu.vn.id18110339.FragmentApp.InfoFragment;

public class ControlActivity extends AppCompatActivity {

    private AHBottomNavigation ahBottomNavigation;
    private AHBottomNavigationViewPager ahBottomNavigationViewPager;
    private ViewPagerAdapter adapter;
    EditText editText;
    public UserDTO userDTO ;
    private int mCountItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ahBottomNavigation = findViewById(R.id.AHBottomNavigation);
        ahBottomNavigationViewPager = findViewById(R.id.AHBottomNavigationViewPager);

        userDTO = (UserDTO) getIntent().getExtras().get("user");
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, userDTO);

        ahBottomNavigationViewPager.setAdapter(adapter);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.baseline_home_24, R.color.teal_200);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.baseline_shopping_basket_24, R.color.teal_200);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.ic_payments_black_24dp, R.color.teal_200);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_baseline_person_24, R.color.teal_200);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        editText = findViewById(R.id.info_edUserName);


        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                adapter.notifyDataSetChanged();
                Bundle bundle = new Bundle();
                bundle.putString("edttext", "From Activity");
                InfoFragment fragobj = new InfoFragment();
                fragobj.setArguments(bundle);
                ahBottomNavigationViewPager.setCurrentItem(position);
                return true;
            }
        });

        ahBottomNavigationViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ahBottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        display();
    }
    public void seeDetailProduct(ProductDTO productDTO) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        DetailProductFragment detailProductFragment=new DetailProductFragment();
        Bundle bundle=new Bundle();

        bundle.putSerializable("PRODUCT",productDTO);
        bundle.putSerializable("user", userDTO);
        detailProductFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.frhome,detailProductFragment);
        fragmentTransaction.addToBackStack(detailProductFragment.getClass().getName());
        fragmentTransaction.commit();
    }
    public  void display(){
        OrderDAO orderDAO = new OrderDAO(getBaseContext());
        mCountItem = orderDAO.NumberOfOrder(userDTO.get_UserId(),0);
        if(mCountItem != 0){
            AHNotification notification = new AHNotification.Builder()
                    .setText(String.valueOf(mCountItem))
                    .setBackgroundColor(ContextCompat.getColor(ControlActivity.this, R.color.teal_200))
                    .setTextColor(ContextCompat.getColor(ControlActivity.this, R.color.white))
                    .build();
            ahBottomNavigation.setNotification(notification, 1);
        }
        else {
            ahBottomNavigation.setNotification("",1);
        }
    }
}