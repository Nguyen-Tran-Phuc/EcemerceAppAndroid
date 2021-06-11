package hcmute.edu.vn.id18110339;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.id18110339.DAO.OrderDAO;
import hcmute.edu.vn.id18110339.DTO.OrderDTO;
import hcmute.edu.vn.id18110339.DTO.ProductDTO;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context mContext;
    private List<OrderDTO> ListOrderDTO;
    private ControlActivity controlActivity;

    public OrderAdapter(Context mContext, List<OrderDTO> listOrderDTO) {
        this.mContext = mContext;
        this.ListOrderDTO = listOrderDTO;
    }

    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.orderitem, parent, false);
        OrderAdapter.ViewHolder viewHolder = new OrderAdapter.ViewHolder(heroView);
        controlActivity = (ControlActivity)parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder holder, int position) {
        OrderDTO orderDTO = ListOrderDTO.get(position);
        int price = ListOrderDTO.get(position).getCost();
        holder.btn_payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDAO orderDAO = new OrderDAO(mContext);
                orderDAO.Payment_Cancel(orderDTO.getOderId(),1);
                Toast.makeText(mContext, "Pay Success", Toast.LENGTH_SHORT).show();
                ListOrderDTO.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OrderDAO orderDAO = new OrderDAO(mContext);
                orderDAO.Payment_Cancel(orderDTO.getOderId(),2);
                Toast.makeText(mContext, "Delete Success", Toast.LENGTH_SHORT).show();
                ListOrderDTO.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
        holder.productname.setText(String.valueOf(orderDTO.getProductId()));
        holder.productImage.setImageResource(orderDTO.getProductImage());
        holder.productcost.setText(String.valueOf(orderDTO.getCost()));
        holder.productquantity.setText(String.valueOf(orderDTO.getQuantity()));
    }

    @Override
    public int getItemCount() {
        return ListOrderDTO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productname;
        private TextView productcost;
        private TextView productquantity;
        private ImageView productImage;
        private ImageButton btn_payment, btn_delete;
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.order_name);
            productquantity = (TextView) itemView.findViewById(R.id.order_quantity);
            productcost = (TextView) itemView.findViewById(R.id.order_cost);
            productImage = (ImageView) itemView.findViewById(R.id.order_image);
            btn_payment = (ImageButton) itemView.findViewById(R.id.btn_pay);
            btn_delete = (ImageButton) itemView.findViewById(R.id.btn_delete);
        }
    }
}
