package hcmute.edu.vn.id18110339;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.FragmentApp.DetailProductFragment;
import hcmute.edu.vn.id18110339.FragmentApp.InfoFragment;

public class ControlActivity extends AppCompatActivity {

    private AHBottomNavigation ahBottomNavigation;
    private AHBottomNavigationViewPager ahBottomNavigationViewPager;
    private ViewPagerAdapter adapter;
    EditText editText;

    private String mName;
    private String mNumberphone;
    private String mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        ahBottomNavigation = findViewById(R.id.AHBottomNavigation);
        ahBottomNavigationViewPager = findViewById(R.id.AHBottomNavigationViewPager);

        adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        ahBottomNavigationViewPager.setAdapter(adapter);


        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.tab_1, R.drawable.baseline_home_24, R.color.teal_200);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.tab_2, R.drawable.baseline_favorite_24, R.color.teal_200);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.tab_3, R.drawable.baseline_shopping_basket_24, R.color.teal_200);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.tab_4, R.drawable.ic_baseline_person_24, R.color.teal_200);

        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        editText = findViewById(R.id.info_edUserName);
        Intent intent = getIntent();
        UserDTO userDTO = (UserDTO) intent.getSerializableExtra("user");


        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                adapter.notifyDataSetChanged();
                ahBottomNavigationViewPager.setCurrentItem(position);
                /*if(position == 3){

                    mName = userDTO.get_UserName();
                    mNumberphone = userDTO.get_UserPhone();
                    mPassword = userDTO.get_Password();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frinfo, new InfoFragment());
                    fragmentTransaction.commit();

                }*/
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
    }

    public  String getmName(){
        return mName;
    }
    public String getmNumberphone(){
        return mNumberphone;
    }
    public String getmPassword(){
        return mPassword;
    }
    public void seeDetailProduct(ProductDTO productDTO) {
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        DetailProductFragment detailProductFragment=new DetailProductFragment();
        Bundle bundle=new Bundle();

        bundle.putSerializable("PRODUCT",productDTO);
        detailProductFragment.setArguments(bundle);

        fragmentTransaction.replace(R.id.frhome,detailProductFragment);
        fragmentTransaction.addToBackStack(detailProductFragment.getClass().getName());
        fragmentTransaction.commit();
    }
}