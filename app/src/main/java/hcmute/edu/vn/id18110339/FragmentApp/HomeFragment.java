package hcmute.edu.vn.id18110339.FragmentApp;

import android.os.Bundle;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import hcmute.edu.vn.id18110339.ProductAdapter;
import hcmute.edu.vn.id18110339.R;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private RecyclerView rcvProduct;
    private RecyclerView rcvDrink;
    private ProductAdapter productAdapter;
    private RecyclerView rcvIceCream;
    private RecyclerView rcvCake;
    private ImageButton btn_Fruit;
    private ImageButton btn_Drink;
    private ImageButton btn_IceCream;
    private ImageButton btn_Cake;
    private LinearLayoutManager linaerQL;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        //btn
        btn_Fruit = (ImageButton)view.findViewById(R.id.frhome_btnFruit);
        btn_Drink = (ImageButton)view.findViewById(R.id.frhome_btnDrink);
        btn_IceCream = (ImageButton)view.findViewById(R.id.frhome_btnIcecream);
        btn_Cake = (ImageButton)view.findViewById(R.id.frhome_btnCake);

        btn_Cake.setOnClickListener(this);


        rcvProduct = view.findViewById(R.id.rcv_product);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvProduct.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this.getContext(), 5);
        rcvProduct.setFocusable(false);
        rcvProduct.setNestedScrollingEnabled(false);

        rcvProduct.setAdapter(productAdapter);

        rcvDrink = view.findViewById(R.id.frhome_recyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvDrink.setLayoutManager(layoutManager2);
        rcvDrink.setFocusable(false);
        rcvDrink.setNestedScrollingEnabled(false);

        rcvDrink.setAdapter(productAdapter);

        rcvIceCream = view.findViewById(R.id.frhome_recyclerView3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvIceCream.setLayoutManager(layoutManager3);
        rcvIceCream.setFocusable(false);
        rcvIceCream.setNestedScrollingEnabled(false);

        rcvIceCream.setAdapter(productAdapter);

        rcvCake = view.findViewById(R.id.frhome_recyclerView4);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvCake.setLayoutManager(layoutManager4);
        rcvCake.setFocusable(false);
        rcvCake.setNestedScrollingEnabled(false);

        rcvCake.setAdapter(productAdapter);



        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.frhome_btnFruit:
                //
                //
                break;
            case R.id.frhome_btnDrink:
                //
                //
                break;
            case R.id.frhome_btnIcecream:
                //
                //
                break;
            case R.id.frhome_btnCake:
                //
                //
                break;
        }
    }
}