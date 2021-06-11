package hcmute.edu.vn.id18110339;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.edu.vn.id18110339.DTO.ProductDTO;
import hcmute.edu.vn.id18110339.FragmentApp.CartFragment;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{
    private Context mContext;
    private List<ProductDTO> ListProductDTO;
    private ControlActivity controlActivity;
    private String a;


    public ProductAdapter(Context mContext, List<ProductDTO> listProductDTO) {
        this.mContext = mContext;
        this.ListProductDTO = listProductDTO;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View heroView = inflater.inflate(R.layout.product, parent, false);
        ViewHolder viewHolder = new ViewHolder(heroView);
        controlActivity = (ControlActivity)parent.getContext();
        a = parent.getContext().toString();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {
        ProductDTO productDTO = ListProductDTO.get(position);
        int price = ListProductDTO.get(position).get_ProductPrice();

        holder.productImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.productprice.setText(String.valueOf(position));
                Log.e("haha",a);
                controlActivity.seeDetailProduct(productDTO);
            }
        });
        holder.productname.setText(productDTO.get_ProductName());
        holder.productprice.setText(String.valueOf(price));
        holder.productImage.setImageResource(productDTO.get_ProductImage());
    }

    @Override
    public int getItemCount() {
        return ListProductDTO.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productname;
        private TextView productprice;
        private ImageView productImage;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);
            productname = (TextView) itemView.findViewById(R.id.itemproduct_name);
            productprice = (TextView) itemView.findViewById(R.id.itemproduct_price);
            productImage = (ImageView) itemView.findViewById(R.id.imageView2);
        }
    }
}
