package hcmute.edu.vn.id18110339.FragmentApp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import java.util.ArrayList;
import hcmute.edu.vn.id18110339.DAO.OrderDAO;
import hcmute.edu.vn.id18110339.DTO.OrderDTO;
import hcmute.edu.vn.id18110339.DTO.UserDTO;
import hcmute.edu.vn.id18110339.OrderAdapter;
import hcmute.edu.vn.id18110339.R;

public class FavoriteFragment extends Fragment implements View.OnClickListener{
    private RecyclerView rcvOrder;
    private OrderAdapter orderAdapter;
    private UserDTO user;

    public FavoriteFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        user = (UserDTO) getArguments().getSerializable("user");

        OrderDAO orderDAO = new OrderDAO(getContext());
        ArrayList<OrderDTO> ListOrder = new ArrayList<>();
        ListOrder = orderDAO.ListOrder(user.get_UserId(),0);


        rcvOrder = view.findViewById(R.id.frfavorite_recyclerVieworder);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        rcvOrder.setLayoutManager(layoutManager);
        orderAdapter = new OrderAdapter(this.getContext(), ListOrder, this.getClass());
        if(ListOrder == null){
            Toast.makeText(getContext(),"no order", Toast.LENGTH_SHORT).show();
        }
        else{
            rcvOrder.setAdapter(orderAdapter);
        }

        return view;
    }

    @Override
    public void onClick(View v) {

    }
}