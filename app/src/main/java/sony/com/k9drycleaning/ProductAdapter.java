package sony.com.k9drycleaning;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{

    CartActivity data;

    private Context mCtx;
    private List<Product> productList;

    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
       this.productList=productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view=inflater.inflate(R.layout.activity_cart, null);
        ProductViewHolder holder = new ProductViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int position) {

        Product product=productList.get(position);

        productViewHolder.textViewTitle.setText(product.getTitle());
        productViewHolder.textViewQuantity.setText(product.getQuantity());
        productViewHolder.textViewPrice.setText(product.gettPrice());
        productViewHolder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewTitle,textViewQuantity,textViewPrice;
        String stShirt,stPrice,stCount;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.imageView);
            textViewTitle=itemView.findViewById(R.id.shirt);
            textViewQuantity=itemView.findViewById(R.id.quantityshirt);
            textViewPrice=itemView.findViewById(R.id.totalpriceshirt);

//
//            SharedPreferences result =getSharedPreferences("Add",Context.MODE_PRIVATE);
//            int pic=result.getInt("image",0);
//            stShirt= result.getString("shirt","");
//            stPrice=result.getString("price","");
//            stCount=result.getString("count","");
//
//            imageView.setImageResource(pic);
//            textViewTitle.setText(stShirt);
//            textViewQuantity.setText("Quantity: "+stCount);
//            textViewPrice.setText("Total Price: "+stPrice);






        }
    }
}
