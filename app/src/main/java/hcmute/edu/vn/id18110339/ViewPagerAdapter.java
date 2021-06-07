package hcmute.edu.vn.id18110339;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import hcmute.edu.vn.id18110339.FragmentApp.CartFragment;
import hcmute.edu.vn.id18110339.FragmentApp.FavoriteFragment;
import hcmute.edu.vn.id18110339.FragmentApp.HomeFragment;
import hcmute.edu.vn.id18110339.FragmentApp.InfoFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new FavoriteFragment();
            case 2:
                return new CartFragment();
            case 3:
                return new InfoFragment();

            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
