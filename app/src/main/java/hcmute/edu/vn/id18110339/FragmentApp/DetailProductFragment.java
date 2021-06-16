package hcmute.edu.vn.id18110339.FragmentApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import hcmute.edu.vn.id18110339.ControlActivity;
import hcmute.edu.vn.id18110339.DAO.OrderDAO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.R;

public class DetailProductFragment extends Fragment {

    private TextView productname;
    private TextView productprice;
    private ImageView productimage;
    private TextView productcategory, quantitynumber;
    private ImageButton btn_Plus, btn_Minus;
    private int quantity = 1;
    private Button btn_AddToCart;
    private ControlActivity controlActivity;

    public DetailProductFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail_product, container, false);
        productname = (TextView) view.findViewById(R.id.drinkNameinInfo);
        productprice = (TextView) view.findViewById(R.id.coffeePrice) ;
        productimage =(ImageView) view.findViewById(R.id.imageViewInfo);
        productcategory = (TextView)view.findViewById(R.id.tv_CategoryProduct) ;
        quantitynumber = (TextView)view.findViewById(R.id.tv_quantity) ;
        btn_Plus = (ImageButton) view.findViewById(R.id.btn_AddQuantity) ;
        btn_Minus = (ImageButton) view.findViewById(R.id.btn_DecreaseQuantity);
        btn_AddToCart = (Button) view.findViewById(R.id.btn_AddToCart) ;
        Button bntBack = view.findViewById(R.id.btn_Back);

        controlActivity = (ControlActivity)getActivity();

        ProductDTO productDTO  = (ProductDTO) getArguments().get("PRODUCT");
        productname.setText(productDTO.get_ProductName());
        productprice.setText(String.valueOf(productDTO.get_ProductPrice()));
        productimage.setImageResource(productDTO.get_ProductImage());

        UserDTO userDTO = (UserDTO) getArguments().get("user");
        String categoryname;
        int categoryId = productDTO.get_ProductCategoryId();
        switch(categoryId){
            case 1:
                categoryname = "Fruit";
                break;
            case 2:
                categoryname = "Drink";
                break;
            case 3:
                categoryname = "Ice Cream";
                break;
            case 4:
                categoryname = "Cake";
                break;
            default: categoryname="Fruit";
        }
        productcategory.setText(categoryname);


        bntBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getActivity().getSupportFragmentManager()!=null){
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack();
                }
            }
        });

        btn_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = productDTO.get_ProductPrice();
                quantity++;
                displayQuantity();
                int ProductPrice = basePrice * quantity;
                String setnewPrice = String.valueOf(ProductPrice);
                productprice.setText(setnewPrice);
            }
        });

        btn_Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int basePrice = productDTO.get_ProductPrice();
                if (quantity == 1) {
                    Toast.makeText(getContext(), "Cant reduce the quantity < 1", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    displayQuantity();
                    int ProductPrice = basePrice * quantity;
                    String setnewPrice = String.valueOf(ProductPrice);
                    productprice.setText(setnewPrice);
                }
            }
        });

        btn_AddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDAO orderDAO = new OrderDAO(getContext());
                long check = orderDAO.AddOrder(0,userDTO.get_UserId(),productDTO.get_ProductName(), quantity, quantity*productDTO.get_ProductPrice(), productDTO.get_ProductImage());
                if(check > 0){
                    Toast.makeText(getContext(), "Order Success", Toast.LENGTH_SHORT).show();
                    controlActivity.display();
                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
                    fragmentManager.popBackStack();
                }
                else {
                    Toast.makeText(getContext(), "Order Fail", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return  view;
    }
    public void displayQuantity(){
        quantitynumber.setText(String.valueOf(quantity));
    }
}