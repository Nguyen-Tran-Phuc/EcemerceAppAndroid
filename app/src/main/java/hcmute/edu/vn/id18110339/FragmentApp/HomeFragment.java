package hcmute.edu.vn.id18110339.FragmentApp;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.ArrayList;
import hcmute.edu.vn.id18110339.DAO.ProductDAO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;
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

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ProductDAO productDAO = new ProductDAO(getContext());
        ArrayList<ProductDTO> ListFruit = new ArrayList<>();
        ListFruit = productDAO.productDTOS(1);

        ProductDAO productDAO1 = new ProductDAO(getContext());
        ArrayList<ProductDTO> productDTOS1 = new ArrayList<>();
        productDTOS1 = productDAO1.productDTOS(2);

        ProductDAO productDAO2 = new ProductDAO(getContext());
        ArrayList<ProductDTO> productDTOS2 = new ArrayList<>();
        productDTOS2 = productDAO2.productDTOS(3);

        ProductDAO productDAO3 = new ProductDAO(getContext());
        ArrayList<ProductDTO> productDTOS3 = new ArrayList<>();
        productDTOS3 = productDAO3.productDTOS(4);

        //btn
        btn_Fruit = (ImageButton)view.findViewById(R.id.frhome_btnFruit);
        btn_Drink = (ImageButton)view.findViewById(R.id.frhome_btnDrink);
        btn_IceCream = (ImageButton)view.findViewById(R.id.frhome_btnIcecream);
        btn_Cake = (ImageButton)view.findViewById(R.id.frhome_btnCake);

        btn_Cake.setOnClickListener(this);


        rcvProduct = view.findViewById(R.id.rcv_product);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvProduct.setLayoutManager(layoutManager);
        productAdapter = new ProductAdapter(this.getContext(), ListFruit);
        rcvProduct.setFocusable(false);
        rcvProduct.setNestedScrollingEnabled(false);

        rcvProduct.setAdapter(productAdapter);

        rcvDrink = view.findViewById(R.id.frhome_recyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvDrink.setLayoutManager(layoutManager2);
        productAdapter = new ProductAdapter(this.getContext(), productDTOS1);
        rcvDrink.setFocusable(false);
        rcvDrink.setNestedScrollingEnabled(false);

        rcvDrink.setAdapter(productAdapter);

        rcvIceCream = view.findViewById(R.id.frhome_recyclerView3);
        LinearLayoutManager layoutManager3 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvIceCream.setLayoutManager(layoutManager3);
        productAdapter = new ProductAdapter(this.getContext(), productDTOS2);
        rcvIceCream.setFocusable(false);
        rcvIceCream.setNestedScrollingEnabled(false);

        rcvIceCream.setAdapter(productAdapter);

        rcvCake = view.findViewById(R.id.frhome_recyclerView4);
        LinearLayoutManager layoutManager4 = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        rcvCake.setLayoutManager(layoutManager4);
        productAdapter = new ProductAdapter(this.getContext(), productDTOS3);
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