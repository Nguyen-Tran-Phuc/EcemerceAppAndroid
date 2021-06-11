package hcmute.edu.vn.id18110339.FragmentApp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;

import hcmute.edu.vn.id18110339.DAO.OrderDAO;
import hcmute.edu.vn.id18110339.DAO.ProductDAO;
import hcmute.edu.vn.id18110339.DTO.OrderDTO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.OrderAdapter;
import hcmute.edu.vn.id18110339.ProductAdapter;
import hcmute.edu.vn.id18110339.R;

public class FavoriteFragment extends Fragment implements View.OnClickListener{
    private RecyclerView rcvOrder;
    private OrderAdapter orderAdapter;

    public FavoriteFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);

        OrderDAO orderDAO = new OrderDAO(getContext());
        ArrayList<OrderDTO> ListOrder = new ArrayList<>();
        ListOrder = orderDAO.ListOrder(1,0);


        rcvOrder = view.findViewById(R.id.frfavorite_recyclerVieworder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        rcvOrder.setLayoutManager(layoutManager);
        orderAdapter = new OrderAdapter(this.getContext(), ListOrder);
        if(ListOrder == null){
            Toast.makeText(getContext(),"no order", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getContext(),String.valueOf(ListOrder.size()), Toast.LENGTH_SHORT).show();
            rcvOrder.setAdapter(orderAdapter);
        }

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}