package hcmute.edu.vn.id18110339;

import android.content.Context;
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
import hcmute.edu.vn.id18110339.FragmentApp.CartFragment;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private Context mContext;
    private List<OrderDTO> ListOrderDTO;
    private ControlActivity controlActivity;
    private Class fragmentClass;

    public OrderAdapter(Context mContext, List<OrderDTO> listOrderDTO, Class fragmentClass) {
        this.mContext = mContext;
        this.ListOrderDTO = listOrderDTO;
        this.fragmentClass = fragmentClass;
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
                Toast.makeText(mContext, "Payment Success", Toast.LENGTH_SHORT).show();
                ListOrderDTO.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                controlActivity.display();
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
                controlActivity.display();
            }
        });

        if (fragmentClass == CartFragment.class) {
            holder.btn_delete.setVisibility(View.GONE);
            holder.btn_payment.setVisibility(View.GONE);
            holder.textdelete.setVisibility(View.GONE);
            holder.textpayment.setVisibility(View.GONE);
        }


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
        private TextView textpayment;
        private TextView textdelete;
        private TextView productquantity;
        private ImageView productImage;
        private ImageButton btn_payment, btn_delete;
        public ViewHolder(View itemView) {
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.order_name);
            productquantity = (TextView) itemView.findViewById(R.id.order_quantity);
            productcost = (TextView) itemView.findViewById(R.id.order_cost);
            productImage = (ImageView) itemView.findViewById(R.id.order_image);
            btn_payment = (ImageButton) itemView.findViewById(R.id.btn_pay);
            btn_delete = (ImageButton) itemView.findViewById(R.id.btn_delete);
            textpayment = (TextView) itemView.findViewById(R.id.tv_payment);
            textdelete = (TextView) itemView.findViewById(R.id.tv_delete);
        }
    }
}
