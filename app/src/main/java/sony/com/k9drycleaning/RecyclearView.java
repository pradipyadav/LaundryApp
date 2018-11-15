package sony.com.k9drycleaning;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclearView extends AppCompatActivity {


    RecyclerView recyclearView;
    ProductAdapter adapter;

    List<Product> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclear_view);

        productList=new ArrayList<>();

       recyclearView=findViewById(R.id.recyclearView);
       recyclearView.setHasFixedSize(true);

       recyclearView.setLayoutManager(new LinearLayoutManager(this));

//       ================================================================


//        Add Product Here....


//        ==================================================================

        adapter=new ProductAdapter(this,productList);
        recyclearView.setAdapter(adapter);
    }
}
