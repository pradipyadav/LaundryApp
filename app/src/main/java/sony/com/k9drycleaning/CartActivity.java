package sony.com.k9drycleaning;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

public class CartActivity extends AppCompatActivity {
    TextView txtShirt,txtQuantity,txtTotalPrice,pant,quantityPant,totalPricePant;

    ImageView imageView2,imageViewPant;
    String stShirt,stPrice,stCount,stPant,stQpant,stRPant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        txtShirt=findViewById(R.id.shirt);
        imageView2=findViewById(R.id.imageView);
        txtQuantity=findViewById(R.id.quantityshirt);
        txtTotalPrice=findViewById(R.id.totalpriceshirt);

//        pant=findViewById(R.id.pant);
//        imageViewPant=findViewById(R.id.imageViewPant);
//        quantityPant=findViewById(R.id.quantitypant);
//        totalPricePant=findViewById(R.id.totalpricepant);


        SharedPreferences result =getSharedPreferences("Add",Context.MODE_PRIVATE);
        int pic=result.getInt("image",0);
        stShirt= result.getString("shirt","");
        stPrice=result.getString("price","");
        stCount=result.getString("count","");

        imageView2.setImageResource(pic);
        txtShirt.setText(stShirt);
        txtQuantity.setText("Quantity: "+stCount);
        txtTotalPrice.setText("Total Price: "+stPrice);



//        Bundle bundle=this.getIntent().getExtras();
//        int pic=bundle.getInt("image");
//        imageView2.setImageResource(pic);
//
//        stShirt=bundle.getString("shirt");
//        txtShirt.setText(stShirt);
//
//        stQuantity=bundle.getString("count");
//        txtQuantity.setText("Quantity: "+stQuantity);
//
//        stTotalPrice=bundle.getString("price");
//        txtTotalPrice.setText("Total Price: "+stTotalPrice);



//        Bundle bundlepant=this.getIntent().getExtras();
//        int picpant=bundle.getInt("pimage");
//        imageViewPant.setImageResource(picpant);
//
//        stPant=bundlepant.getString("pant");
//        pant.setText(stPant);
//
//        stQpant=bundlepant.getString("pcount");
//        quantityPant.setText("Quantity: "+stQpant);
//
//        stRPant=bundlepant.getString("pprice");
//        totalPricePant.setText("Total Price: "+stRPant);



    }
}
