package hcmute.edu.vn.id18110339.FragmentApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hcmute.edu.vn.id18110339.ProductAdapter;
import hcmute.edu.vn.id18110339.R;

public class HomeFragment extends Fragment {

    private RecyclerView rcvProduct;
    private ProductAdapter productAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rcvProduct = view.findViewById(R.id.rcv_product);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvProduct.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this.getContext(), 5);

        rcvProduct.setAdapter(productAdapter);



        return view;
    }
}