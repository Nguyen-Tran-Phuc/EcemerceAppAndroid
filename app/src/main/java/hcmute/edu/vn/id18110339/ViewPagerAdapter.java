package hcmute.edu.vn.id18110339;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.FragmentApp.CartFragment;
import hcmute.edu.vn.id18110339.FragmentApp.FavoriteFragment;
import hcmute.edu.vn.id18110339.FragmentApp.HomeFragment;
import hcmute.edu.vn.id18110339.FragmentApp.InfoFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private UserDTO userDTO;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior, UserDTO userDTO) {
        super(fm, behavior);
        this.userDTO = userDTO;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                Fragment favoriteFragment = new FavoriteFragment();
                Log.e("tesst",userDTO.get_UserName());
                Bundle bundle1  = new Bundle();
                bundle1.putSerializable("user", userDTO);
                favoriteFragment.setArguments(bundle1);
                return favoriteFragment;
            case 2:
                Fragment cartFragment = new CartFragment();
                Log.e("tesst",userDTO.get_UserName());
                Bundle bundle2  = new Bundle();
                bundle2.putSerializable("user", userDTO);
                cartFragment.setArguments(bundle2);
                return cartFragment;
            case 3:
                Fragment infoFragment = new InfoFragment();
                Log.e("tesst",userDTO.get_UserName());
                Bundle bundle  = new Bundle();
                bundle.putSerializable("user", userDTO);
                infoFragment.setArguments(bundle);
                return infoFragment;

            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }
}
