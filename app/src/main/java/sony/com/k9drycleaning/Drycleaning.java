package sony.com.k9drycleaning;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Drycleaning extends AppCompatActivity {

    TextView qDryShirt, qDryPant, qDryShirtStarch, qDryPantStarch, qDryKurta, qDryKurta2piece, qDryTop,
            qDrySalwar, qDryDupatta, qDrySaree, qDryShaluPaithani, qDryNavwari, qDryBlause, qDryPunjabiSuit,
            qDryDhotarSohale, qDryCoat, qDrySherwani, qDrySweater, qDrybedsheetSingle, qDrybedsheetDouble,
            qDrySolaSingChadar, qDrySolaDoubleChadar, qDryBlanketSingle, qDryBlanketDouble, qDryCarSeatCover,
            qDrySchoolBag, qDryCarpet, qDryColor, qDryTotal, rDryTotal;
    //
    TextView rDryShirt, rDryPant, rDryShirtStarch, rDryPantStarch, rDryKurta, rDryKurta2piece, rDryTop,
            rDrySalwar, rDryDupatta, rDrySaree, rDryShaluPaithani, rDryNavwari, rDryBlause, rDryPunjabiSuit,
            rDryDhotarSohale, rDryCoat, rDrySherwani, rDrySweater, rDrybedsheetSingle, rDrybedsheetDouble,
            rDrySolaSingChadar, rDrySolaDoubleChadar, rDryBlanketSingle, rDryBlanketDouble, rDryCarSeatCover,
            rDrySchoolBag, rDryCarpet, rDryColor;

    TextView DryShirt, DryPant, DryShirtStarch, DryPantStarch, DryKurta, DryKurta2piece, DryTop,
            DrySalwar, DryDupatta, DrySaree, DryShaluPaithani, DryNavwari, DryBlause, DryPunjabiSuit,
            DryDhotarSohale, DryCoat, DrySherwani, DrySweater, DrybedsheetSingle, DrybedsheetDouble,
            DrySolaSingChadar, DrySolaDoubleChadar, DryBlanketSingle, DryBlanketDouble, DryCarSeatCover,
            DrySchoolBag, DryCarpet, DryColor;

    ImageButton minButton,plusButton,pantminus,pantplus;


    Button btnPressSubmit,btnDShirt,btnDPant;

    TextView shirtValue;

    TextView dryShirt, shirtPrice, totalShirtPrice,totalPantPrice,totalShirtStarchPrice,totalPantStarchPrice,
            totalKurtaPrice,totalTopPrice,totalSalwarPrice,totalDupattaPrice,totalSareePrice,totalShaluPaithaniPrice,
            totalNavwariPrice,totalBlausePrice,totalPunjabiSuitPrice,totalDhotarPrice,totalCoatPrice,totalShervaniPrice,
            totalSweaterPrice,totalBedSingPrice,totalBedDoubPrice,totalSolaSingPrice,totalSolaDoubPrice,totalBlankSingPrice,
            totalBlankDoubPrice,totalCarSeatCoverPrice,totalSchoolBagPrice,totalCarpetPrice,totalColorPrice;
    ImageView imgShirt;

    int counter=0;
    int cDryPant=0; int cDryShirtStarch=0; int cDryPantStarch=0; int cDryKurta=0; int cDryTop=0;
    int cDrySalwar=0; int  cDryDupatta=0; int  cDrySaree=0; int  cDryShaluPaithani=0; int  cDryNavwari=0; int  cDryBlause=0;
    int cDryPunjabiSuit=0; int cDryDhotarSohale=0; int  cDryCoat=0; int  cDrySherwani=0; int  cDrySweater=0; int cDrybedsheetSingle=0; int  cDrybedsheetDouble;
    int cDrySolaSingChadar=0; int  cDrySolaDoubleChadar=0; int  cDryBlanketSingle=0; int  cDryBlanketDouble=0; int  cDryCarSeatCover=0; int cDrySchoolBag=0;
    int cDryCarpet=0; int  cDryColor=0;

    Button btndryclean;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dry_cleaning);



//       Total Button*********************************************************

        totalShirtStarchPrice=findViewById(R.id.totalShirtStarchPrice);
        totalPantStarchPrice=findViewById(R.id.totalPantStarchPrice);
        totalKurtaPrice=findViewById(R.id.totalKurtaPrice);
        totalTopPrice=findViewById(R.id.totalTopPrice);
        totalSalwarPrice=findViewById(R.id.totalSalwarPrice);
        totalDupattaPrice=findViewById(R.id.totalDupattaPrice);
        totalSareePrice=findViewById(R.id.totalSareePrice);
        totalShaluPaithaniPrice=findViewById(R.id.totalShaluPaithaniPrice);
        totalNavwariPrice=findViewById(R.id.totalNavwariPrice);
        totalBlausePrice=findViewById(R.id.totalBlausePrice);
        totalPunjabiSuitPrice=findViewById(R.id.totalPunjabiSuitPrice);
        totalDhotarPrice=findViewById(R.id.totalDhotarPrice);
        totalCoatPrice=findViewById(R.id.totalCoatPrice);
        totalShervaniPrice=findViewById(R.id.totalShervaniPrice);
        totalSweaterPrice=findViewById(R.id.totalSweaterPrice);
        totalBedSingPrice=findViewById(R.id.totalBedSingPrice);
        totalBedDoubPrice=findViewById(R.id.totalBedDoubPrice);
        totalSolaSingPrice=findViewById(R.id.totalSolaSingPrice);
        totalSolaDoubPrice=findViewById(R.id.totalSolaDoubPrice);
        totalBlankSingPrice=findViewById(R.id.totalBlankSingPrice);
        totalBlankDoubPrice=findViewById(R.id.totalBlankDoubPrice);
        totalCarSeatCoverPrice=findViewById(R.id.totalCarSeatCoverPrice);
        totalSchoolBagPrice=findViewById(R.id.totalSchoolBagPrice);
        totalCarpetPrice=findViewById(R.id.totalCarpetPrice);
        totalColorPrice=findViewById(R.id.totalColorPrice);


//        Button*************************************************************************************

        btnPressSubmit=findViewById(R.id.btnPressSubmit);

        btnDShirt = findViewById(R.id.btnDShirt);
        totalShirtPrice = findViewById(R.id.totalShirtPrice);
        minButton=findViewById(R.id.shirtminus);
        plusButton=findViewById(R.id.shirtplus);

        btnDPant=findViewById(R.id.btnPant);
        totalPantPrice=findViewById(R.id.totalPantPrice);
        pantminus=findViewById(R.id.pantminus);
        pantplus=findViewById(R.id.pantplus);



//        EditText***********************************************************************************

//        qDryShirt=findViewById(R.id.qDryShirt);
        qDryPant=findViewById(R.id.qDryPant);
        qDryShirtStarch=findViewById(R.id.qDryShirtStarch);
        qDryPantStarch=findViewById(R.id.qDryPantStarch);
        qDryKurta=findViewById(R.id.qDryKurta);
//        qDryKurta2piece=findViewById(R.id.qDryKurta2piece);
        qDrySalwar=findViewById(R.id.qDrySalwar);
        qDryDupatta=findViewById(R.id.qDryDupatta);
        qDrySaree=findViewById(R.id.qDrySaree);
        qDryShaluPaithani=findViewById(R.id.qDryShaluPaithani);
        qDryNavwari=findViewById(R.id.qDryNavwari);
        qDryBlause=findViewById(R.id.qDryBlause);
        qDryPunjabiSuit=findViewById(R.id.qDryPunjabiSuit);
        qDryTop=findViewById(R.id.qDryTop);
        qDryDhotarSohale=findViewById(R.id.qDryDhotarSohale);
        qDryCoat=findViewById(R.id.qDryCoat);
        qDrySherwani=findViewById(R.id.qDrySherwani);
        qDrySweater=findViewById(R.id.qDrySweater);
        qDrybedsheetSingle=findViewById(R.id.qDrybedsheetSingle);
        qDrybedsheetDouble=findViewById(R.id.qDrybedsheetDouble);
        qDrySolaSingChadar=findViewById(R.id.qDrySolaSingChadar);
        qDrySolaDoubleChadar=findViewById(R.id.qDrySolaDoubleChadar);
        qDryBlanketSingle=findViewById(R.id.qDryBlanketSingle);
        qDryBlanketDouble=findViewById(R.id.qDryBlanketDouble);
        qDryCarSeatCover=findViewById(R.id.qDryCarSeatCover);
        qDrySchoolBag=findViewById(R.id.qDrySchoolBag);
        qDryColor=findViewById(R.id.qDryColor);
        qDryCarpet=findViewById(R.id.qDryCarpet);
//        qDryTotal=findViewById(R.id.qDryTotal);

////
//////        TextView*********************************************************************
////
//        rDryShirt=findViewById(R.id.rDryShirt);
        rDryPant=findViewById(R.id.rDryPant);
        rDryShirtStarch=findViewById(R.id.rDryShirtStarch);
        rDryPantStarch=findViewById(R.id.rDryPantStarch);
        rDryKurta=findViewById(R.id.rDryKurta);
//        rDryKurta2piece=findViewById(R.id.rDryKurta2piece);
        rDrySalwar=findViewById(R.id.rDrySalwar);
        rDryDupatta=findViewById(R.id.rDryDupatta);
        rDrySaree=findViewById(R.id.rDrySaree);
        rDryShaluPaithani=findViewById(R.id.rDryShaluPaithani);
        rDryNavwari=findViewById(R.id.rDryNavwari);
        rDryBlause=findViewById(R.id.rDryBlause);
        rDryPunjabiSuit=findViewById(R.id.rDryPunjabiSuit);
        rDryTop=findViewById(R.id.rDryTop);
        rDryDhotarSohale=findViewById(R.id.rDryDhotarSohale);
        rDryCoat=findViewById(R.id.rDryCoat);
        rDrySherwani=findViewById(R.id.rDrySherwani);
        rDrySweater=findViewById(R.id.rDrySweater);
        rDrybedsheetSingle=findViewById(R.id.rDrybedsheetSingle);
        rDrybedsheetDouble=findViewById(R.id.rDrybedsheetDouble);
        rDrySolaSingChadar=findViewById(R.id.rDrySolaSingChadar);
        rDrySolaDoubleChadar=findViewById(R.id.rDrySolaDoubleChadar);
        rDryBlanketSingle=findViewById(R.id.rDryBlanketSingle);
        rDryBlanketDouble=findViewById(R.id.rDryBlanketDouble);
        rDryCarSeatCover=findViewById(R.id.rDryCarSeatCover);
        rDrySchoolBag=findViewById(R.id.rDrySchoolBag);
        rDryColor=findViewById(R.id.rDryColor);
        rDryCarpet=findViewById(R.id.rDryCarpet);
//        rDryTotal=findViewById(R.id.rDryTotal);
//        rDryTotal=findViewById(R.id.rDryTotal);
//
////        TextView*********************************************************************
////
//        rDryShirt=findViewById(R.id.rDryShirt);
        DryPant=findViewById(R.id.DryPant);
        DryShirtStarch=findViewById(R.id.DryShirtStarch);
        DryPantStarch=findViewById(R.id.DryPantStarch);
        DryKurta=findViewById(R.id.DryKurta);
//        DryKurta2piece=findViewById(R.id.DryKurta2piece);
        DrySalwar=findViewById(R.id.DrySalwar);
        DryDupatta=findViewById(R.id.DryDupatta);
        DrySaree=findViewById(R.id.DrySaree);
        DryShaluPaithani=findViewById(R.id.DryShaluPaithani);
        DryNavwari=findViewById(R.id.DryNavwari);
        DryBlause=findViewById(R.id.DryBlause);
        DryPunjabiSuit=findViewById(R.id.DryPunjabiSuit);
        DryTop=findViewById(R.id.DryTop);
        DryDhotarSohale=findViewById(R.id.DryDhotarSohale);
        DryCoat=findViewById(R.id.DryCoat);
        DrySherwani=findViewById(R.id.DrySherwani);
        DrySweater=findViewById(R.id.DrySweater);
        DrybedsheetSingle=findViewById(R.id.DrybedsheetSingle);
        DrybedsheetDouble=findViewById(R.id.DrybedsheetDouble);
        DrySolaSingChadar=findViewById(R.id.DrySolaSingChadar);
        DrySolaDoubleChadar=findViewById(R.id.DrySolaDoubleChadar);
        DryBlanketSingle=findViewById(R.id.DryBlanketSingle);
        DryBlanketDouble=findViewById(R.id.DryBlanketDouble);
        DryCarSeatCover=findViewById(R.id.DryCarSeatCover);
        DrySchoolBag=findViewById(R.id.DrySchoolBag);
        DryColor=findViewById(R.id.DryColor);
        DryCarpet=findViewById(R.id.DryCarpet);



        shirtValue = findViewById(R.id.shirtValue);
        shirtPrice = findViewById(R.id.shirtPrice);
        dryShirt = findViewById(R.id.dryShirt);
        imgShirt = findViewById(R.id.imgShirt);




//        *******************************************************************************************
//                        Shirt


            btnDShirt.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            sharedPreferences = getSharedPreferences("Add", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("shirt", dryShirt.getText().toString());
                            editor.putString("price", totalShirtPrice.getText().toString());
                            editor.putString("count", shirtValue.getText().toString());
                            editor.putInt("image", R.drawable.ic_shirt);
                            editor.commit();

                            Toast.makeText(Drycleaning.this, "Added", Toast.LENGTH_SHORT).show();
                        }
                    }
            );

//  =========================================================================================================
//                                  Pant

        btnDPant.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sharedPreferences=getSharedPreferences("addPant",Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("pant",DryPant.getText().toString());
                        editor.putString("price",totalPantPrice.getText().toString());
                        editor.putString("count",qDryPant.getText().toString());
                        editor.putInt("image",R.drawable.ic_pants);
                        editor.commit();

                        Toast.makeText(Drycleaning.this, "Added", Toast.LENGTH_SHORT).show();
                    }
                }
        );

//  ======================================================================================================

        btnPressSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent shirt=new Intent(Drycleaning.this,CartActivity.class);
                startActivity(shirt);
            }
        });


        minButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                if (counter<=0)
                    counter=0;

                shirtValue.setText(Integer.toString(counter));

                try {

                    int txt1Value = Integer.parseInt(shirtValue.getText().toString());
                    int txt2Value = Integer.parseInt(shirtPrice.getText().toString());
                    txt1Value = txt2Value * txt1Value;
                    totalShirtPrice.setText(String.valueOf(txt1Value));

                }catch (Exception ex){
                    Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
                }
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                counter++;
                shirtValue.setText(Integer.toString(counter));

                try {

                    int txt1Value = Integer.parseInt(shirtValue.getText().toString());
                    int txt2Value = Integer.parseInt(shirtPrice.getText().toString());
                    txt1Value = txt2Value * txt1Value;
                    totalShirtPrice.setText(String.valueOf(txt1Value));

                }catch (Exception ex){
                    Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
                }
            }
        });


//*******************************************************************************************************
//                                      Pant

        pantminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cDryPant--;
                if (cDryPant<=0)
                    cDryPant=0;

                qDryPant.setText(Integer.toString(cDryPant));
                try {

                    int txt1Value = Integer.parseInt(qDryPant.getText().toString());
                    int txt2Value = Integer.parseInt(rDryPant.getText().toString());
                    txt1Value = txt2Value * txt1Value;
                    totalPantPrice.setText(String.valueOf(txt1Value));

                }catch (Exception ex){
                    Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
                }
            }
        });

        pantplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cDryPant++;
                qDryPant.setText(Integer.toString(cDryPant));
                try {

                    int txt1Value = Integer.parseInt(qDryPant.getText().toString());
                    int txt2Value = Integer.parseInt(rDryPant.getText().toString());
                    txt1Value = txt2Value * txt1Value;
                    totalPantPrice.setText(String.valueOf(txt1Value));

                }catch (Exception ex){
                    Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
                }
            }
        });

    }
    //*****************************************************************************************************
    public void shirtStarchmin(View view) {
        cDryShirtStarch--;
        if (cDryShirtStarch<=0)
            cDryShirtStarch=0;
        qDryShirtStarch.setText(Integer.toString(cDryShirtStarch));
        try {

            int txt1Value = Integer.parseInt(qDryShirtStarch.getText().toString());
            int txt2Value = Integer.parseInt(rDryShirtStarch.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShirtStarchPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    public void shirtStarchplus(View view) {
        cDryShirtStarch++;
        qDryShirtStarch.setText(Integer.toString(cDryShirtStarch));
        try {

            int txt1Value = Integer.parseInt(qDryShirtStarch.getText().toString());
            int txt2Value = Integer.parseInt(rDryShirtStarch.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShirtStarchPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    //*******************************************************************************************************
    public void pantStarchmin(View view) {
        cDryPantStarch--;
        if (cDryPantStarch<=0)
            cDryPantStarch=0;
        qDryPantStarch.setText(Integer.toString(cDryPantStarch));
        try {

            int txt1Value = Integer.parseInt(qDryPantStarch.getText().toString());
            int txt2Value = Integer.parseInt(rDryPantStarch.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalPantStarchPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    public void pantStarchplus(View view) {
        cDryPantStarch++;
        qDryPantStarch.setText(Integer.toString(cDryPantStarch));
        try {

            int txt1Value = Integer.parseInt(qDryPantStarch.getText().toString());
            int txt2Value = Integer.parseInt(rDryPantStarch.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalPantStarchPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }

    //*******************************************************************************************************
    public void kurtaMin(View view) {
        cDryKurta--;
        if (cDryKurta<=0)
            cDryKurta=0;
        qDryKurta.setText(Integer.toString(cDryKurta));
        try {

            int txt1Value = Integer.parseInt(qDryKurta.getText().toString());
            int txt2Value = Integer.parseInt(rDryKurta.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalKurtaPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    public void kurtaMax(View view) {

        cDryKurta++;
        qDryKurta.setText(Integer.toString(cDryKurta));
        try {

            int txt1Value = Integer.parseInt(qDryKurta.getText().toString());
            int txt2Value = Integer.parseInt(rDryKurta.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalKurtaPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }  }


    //*******************************************************************************************************
    public void topMin(View view) {
        cDryTop--;
        if (cDryTop<=0)
            cDryTop=0;
        qDryTop.setText(Integer.toString(cDryTop));

        try {

            int txt1Value = Integer.parseInt(qDryTop.getText().toString());
            int txt2Value = Integer.parseInt(rDryTop.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalTopPrice.setText(String.valueOf(txt1Value));

//                    int s1=(Integer.parseInt(shirtValue.getText().toString()));
//                    if(counter<0)
//                    {
//                        minButton.setEnabled(false);
//                    }

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    public void topPlus(View view) {
        cDryTop++;
        qDryTop.setText(Integer.toString(cDryTop));
        try {

            int txt1Value = Integer.parseInt(qDryTop.getText().toString());
            int txt2Value = Integer.parseInt(rDryTop.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalTopPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void salwarMin(View view) {
        cDrySalwar--;
        if (cDrySalwar<=0)
            cDrySalwar=0;
        qDrySalwar.setText(Integer.toString(cDrySalwar));

        try {

            int txt1Value = Integer.parseInt(qDrySalwar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySalwar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSalwarPrice.setText(String.valueOf(txt1Value));

//                    int s1=(Integer.parseInt(shirtValue.getText().toString()));
//                    if(counter<0)
//                    {
//                        minButton.setEnabled(false);
//                    }

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    public void salwarMax(View view) {
        cDrySalwar++;
        qDrySalwar.setText(Integer.toString(cDrySalwar));
        try {

            int txt1Value = Integer.parseInt(qDrySalwar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySalwar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSalwarPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void dupattaMin(View view) {
        cDryDupatta--;
        if (cDryDupatta<=0)
            cDryDupatta=0;
        qDryDupatta.setText(Integer.toString(cDryDupatta));

        try {

            int txt1Value = Integer.parseInt(qDryDupatta.getText().toString());
            int txt2Value = Integer.parseInt(rDryDupatta.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalDupattaPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void dupattaMax(View view) {
        cDryDupatta++;
        qDryDupatta.setText(Integer.toString(cDryDupatta));
        try {

            int txt1Value = Integer.parseInt(qDryDupatta.getText().toString());
            int txt2Value = Integer.parseInt(rDryDupatta.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalDupattaPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void sareeMin(View view) {
        cDrySaree--;
        if (cDrySaree<=0)
            cDrySaree=0;
        qDrySaree.setText(Integer.toString(cDrySaree));

        try {

            int txt1Value = Integer.parseInt(qDrySaree.getText().toString());
            int txt2Value = Integer.parseInt(rDrySaree.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSareePrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void sareeMax(View view) {
        cDrySaree++;
        qDrySaree.setText(Integer.toString(cDrySaree));
        try {

            int txt1Value = Integer.parseInt(qDrySaree.getText().toString());
            int txt2Value = Integer.parseInt(rDrySaree.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSareePrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void shaluMin(View view) {
        cDryShaluPaithani--;
        if (cDryShaluPaithani<=0)
            cDryShaluPaithani=0;
        qDryShaluPaithani.setText(Integer.toString(cDryShaluPaithani));

        try {

            int txt1Value = Integer.parseInt(qDryShaluPaithani.getText().toString());
            int txt2Value = Integer.parseInt(rDryShaluPaithani.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShaluPaithaniPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void shaluMax(View view) {
        cDryShaluPaithani++;
        qDryShaluPaithani.setText(Integer.toString(cDryShaluPaithani));
        try {

            int txt1Value = Integer.parseInt(qDryShaluPaithani.getText().toString());
            int txt2Value = Integer.parseInt(rDryShaluPaithani.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShaluPaithaniPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void navwariMin(View view) {
        cDryNavwari--;
        if (cDryNavwari<=0)
            cDryNavwari=0; qDryNavwari.setText(Integer.toString(cDryNavwari));

        try {

            int txt1Value = Integer.parseInt(qDryNavwari.getText().toString());
            int txt2Value = Integer.parseInt(rDryNavwari.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalNavwariPrice.setText(String.valueOf(txt1Value));

//                    int s1=(Integer.parseInt(shirtValue.getText().toString()));
//                    if(counter<0)
//                    {
//                        minButton.setEnabled(false);
//                    }

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void navwariMax(View view) {
        cDryNavwari++;
        qDryNavwari.setText(Integer.toString(cDryNavwari));
        try {

            int txt1Value = Integer.parseInt(qDryNavwari.getText().toString());
            int txt2Value = Integer.parseInt(rDryNavwari.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalNavwariPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void blauseMin(View view) {
        cDryBlause--;
        if (cDryBlause<=0)
            cDryBlause=0;  qDryBlause.setText(Integer.toString(cDryBlause));

        try {

            int txt1Value = Integer.parseInt(qDryBlause.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlause.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlausePrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void blauseMax(View view) {
        cDryBlause++;
        qDryBlause.setText(Integer.toString(cDryBlause));
        try {

            int txt1Value = Integer.parseInt(qDryBlause.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlause.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlausePrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void punjabiMin(View view) {
        cDryPunjabiSuit--;
        if (cDryPunjabiSuit<=0)
            cDryPunjabiSuit=0;
        qDryPunjabiSuit.setText(Integer.toString(cDryPunjabiSuit));

        try {

            int txt1Value = Integer.parseInt(qDryPunjabiSuit.getText().toString());
            int txt2Value = Integer.parseInt(rDryPunjabiSuit.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalPunjabiSuitPrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void punjabiMax(View view) {
        cDryPunjabiSuit++;
        qDryPunjabiSuit.setText(Integer.toString(cDryPunjabiSuit));
        try {

            int txt1Value = Integer.parseInt(qDryPunjabiSuit.getText().toString());
            int txt2Value = Integer.parseInt(rDryPunjabiSuit.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalPunjabiSuitPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void dhotarMin(View view) {
        cDryDhotarSohale--;
        if (cDryDhotarSohale<=0)
            cDryDhotarSohale=0;
        qDryDhotarSohale.setText(Integer.toString(cDryDhotarSohale));

        try {

            int txt1Value = Integer.parseInt(qDryDhotarSohale.getText().toString());
            int txt2Value = Integer.parseInt(rDryDhotarSohale.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalDhotarPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void dhotarMax(View view) {
        cDryDhotarSohale++;
        qDryDhotarSohale.setText(Integer.toString(cDryDhotarSohale));
        try {

            int txt1Value = Integer.parseInt(qDryDhotarSohale.getText().toString());
            int txt2Value = Integer.parseInt(rDryDhotarSohale.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalDhotarPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}
//*******************************************************************************************************

    public void coatMin(View view) {
        cDryCoat--;
        if (cDryCoat<=0)
            cDryCoat=0;
        qDryCoat.setText(Integer.toString(cDryCoat));

        try {

            int txt1Value = Integer.parseInt(qDryCoat.getText().toString());
            int txt2Value = Integer.parseInt(rDryCoat.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCoatPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void coatMax(View view) {
        cDryCoat++;
        qDryCoat.setText(Integer.toString(cDryCoat));
        try {

            int txt1Value = Integer.parseInt(qDryCoat.getText().toString());
            int txt2Value = Integer.parseInt(rDryCoat.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCoatPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }  }
//*******************************************************************************************************

    public void shervaniMin(View view) {
        cDrySherwani--;
        if (cDrySherwani<=0)
            cDrySherwani=0;
        qDrySherwani.setText(Integer.toString(cDrySherwani));

        try {

            int txt1Value = Integer.parseInt(qDrySherwani.getText().toString());
            int txt2Value = Integer.parseInt(rDrySherwani.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShervaniPrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void sherwaniMax(View view) {
        cDrySherwani++;
        qDrySherwani.setText(Integer.toString(cDrySherwani));
        try {

            int txt1Value = Integer.parseInt(qDrySherwani.getText().toString());
            int txt2Value = Integer.parseInt(rDrySherwani.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalShervaniPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void sweaterMin(View view) {
        cDrySweater--;
        if (cDrySweater<=0)
            cDrySweater=0;  qDrySweater.setText(Integer.toString(cDrySweater));

        try {

            int txt1Value = Integer.parseInt(qDrySweater.getText().toString());
            int txt2Value = Integer.parseInt(rDrySweater.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSweaterPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void sweaterMax(View view) {
        cDrySweater++;
        qDrySweater.setText(Integer.toString(cDrySweater));
        try {

            int txt1Value = Integer.parseInt(qDrySweater.getText().toString());
            int txt2Value = Integer.parseInt(rDrySweater.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSweaterPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void bedSheetSIngMin(View view) {
        cDrybedsheetSingle--;
        if (cDrybedsheetSingle<=0)
            cDrybedsheetSingle=0;  qDrybedsheetSingle.setText(Integer.toString(cDrybedsheetSingle));

        try {

            int txt1Value = Integer.parseInt(qDrybedsheetSingle.getText().toString());
            int txt2Value = Integer.parseInt(rDrybedsheetSingle.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBedSingPrice.setText(String.valueOf(txt1Value));

//                    int s1=(Integer.parseInt(shirtValue.getText().toString()));
//                    if(counter<0)
//                    {
//                        minButton.setEnabled(false);
//                    }

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void bedSheetSIngMax(View view) {
        cDrybedsheetSingle++;
        qDrybedsheetSingle.setText(Integer.toString(cDrybedsheetSingle));
        try {

            int txt1Value = Integer.parseInt(qDrybedsheetSingle.getText().toString());
            int txt2Value = Integer.parseInt(rDrybedsheetSingle.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBedSingPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void bedSheetDoubMin(View view) {
        cDrybedsheetDouble--;
        if (cDrybedsheetDouble<=0)
            cDrybedsheetDouble=0;qDrybedsheetDouble.setText(Integer.toString(cDrybedsheetDouble));

        try {

            int txt1Value = Integer.parseInt(qDrybedsheetDouble.getText().toString());
            int txt2Value = Integer.parseInt(rDrybedsheetDouble.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBedDoubPrice.setText(String.valueOf(txt1Value));

//                    int s1=(Integer.parseInt(shirtValue.getText().toString()));
//                    if(counter<0)
//                    {
//                        minButton.setEnabled(false);
//                    }

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void bedSheetDoubMax(View view) {
        cDrybedsheetDouble++;
        qDrybedsheetDouble.setText(Integer.toString(cDrybedsheetDouble));
        try {

            int txt1Value = Integer.parseInt(qDrybedsheetDouble.getText().toString());
            int txt2Value = Integer.parseInt(rDrybedsheetDouble.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBedDoubPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void SolaSingChadMin(View view) {

        cDrySolaSingChadar--;
        if (cDrySolaSingChadar<=0)
            cDrySolaSingChadar=0;  qDrySolaSingChadar.setText(Integer.toString(cDrySolaSingChadar));

        try {

            int txt1Value = Integer.parseInt(qDrySolaSingChadar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySolaSingChadar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSolaSingPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void SolaSingChadMax(View view) {
        cDrySolaSingChadar++;
        qDrySolaSingChadar.setText(Integer.toString(cDrySolaSingChadar));
        try {

            int txt1Value = Integer.parseInt(qDrySolaSingChadar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySolaSingChadar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSolaSingPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void SolaDoubChadMin(View view) {
        cDrySolaDoubleChadar--;
        if (cDrySolaDoubleChadar<=0)
            cDrySolaDoubleChadar=0; qDrySolaDoubleChadar.setText(Integer.toString(cDrySolaDoubleChadar));

        try {

            int txt1Value = Integer.parseInt(qDrySolaDoubleChadar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySolaDoubleChadar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSolaDoubPrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void SolaDoubChadMax(View view) {
        cDrySolaDoubleChadar++;
        qDrySolaDoubleChadar.setText(Integer.toString(cDrySolaDoubleChadar));
        try {

            int txt1Value = Integer.parseInt(qDrySolaDoubleChadar.getText().toString());
            int txt2Value = Integer.parseInt(rDrySolaDoubleChadar.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSolaDoubPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void blankSingMin(View view) {
        cDryBlanketSingle--;
        if (cDryBlanketSingle<=0)
            cDryBlanketSingle=0;  qDryBlanketSingle.setText(Integer.toString(cDryBlanketSingle));

        try {

            int txt1Value = Integer.parseInt(qDryBlanketSingle.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlanketSingle.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlankSingPrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void blankSingMax(View view) {
        cDryBlanketSingle++;
        qDryBlanketSingle.setText(Integer.toString(cDryBlanketSingle));
        try {

            int txt1Value = Integer.parseInt(qDryBlanketSingle.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlanketSingle.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlankSingPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void blankDoubMin(View view) {
        cDryBlanketDouble--;
        if (cDryBlanketDouble<=0)
            cDryBlanketDouble=0; qDryBlanketDouble.setText(Integer.toString(cDryBlanketDouble));

        try {

            int txt1Value = Integer.parseInt(qDryBlanketDouble.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlanketDouble.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlankDoubPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void blankDoubMax(View view) {
        cDryBlanketDouble++;
        qDryBlanketDouble.setText(Integer.toString(cDryBlanketDouble));
        try {

            int txt1Value = Integer.parseInt(qDryBlanketDouble.getText().toString());
            int txt2Value = Integer.parseInt(rDryBlanketDouble.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalBlankDoubPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void carSeatMin(View view) {
        cDryCarSeatCover--;
        if (cDryCarSeatCover<=0)
            cDryCarSeatCover=0;
        qDryCarSeatCover.setText(Integer.toString(cDryCarSeatCover));

        try {

            int txt1Value = Integer.parseInt(qDryCarSeatCover.getText().toString());
            int txt2Value = Integer.parseInt(rDryCarSeatCover.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCarSeatCoverPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void carSeatMax(View view) {
        cDryCarSeatCover++;
        qDryCarSeatCover.setText(Integer.toString(cDryCarSeatCover));
        try {

            int txt1Value = Integer.parseInt(qDryCarSeatCover.getText().toString());
            int txt2Value = Integer.parseInt(rDryCarSeatCover.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCarSeatCoverPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }  }
//*******************************************************************************************************

    public void schoolBagMin(View view) {
        cDrySchoolBag--;
        if (cDrySchoolBag<=0)
            cDrySchoolBag=0;  qDrySchoolBag.setText(Integer.toString(cDrySchoolBag));

        try {

            int txt1Value = Integer.parseInt(qDrySchoolBag.getText().toString());
            int txt2Value = Integer.parseInt(rDrySchoolBag.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSchoolBagPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void schoolBagMax(View view) {
        cDrySchoolBag++;
        qDrySchoolBag.setText(Integer.toString(cDrySchoolBag));
        try {

            int txt1Value = Integer.parseInt(qDrySchoolBag.getText().toString());
            int txt2Value = Integer.parseInt(rDrySchoolBag.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalSchoolBagPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void carpetMin(View view) {
        cDryCarpet--;
        if (cDryCarpet<=0)
            cDryCarpet=0;
        qDryCarpet.setText(Integer.toString(cDryCarpet));

        try {

            int txt1Value = Integer.parseInt(qDryCarpet.getText().toString());
            int txt2Value = Integer.parseInt(rDryCarpet.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCarpetPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void carpetMax(View view) {
        cDryCarpet++;
        qDryCarpet.setText(Integer.toString(cDryCarpet));
        try {

            int txt1Value = Integer.parseInt(qDryCarpet.getText().toString());
            int txt2Value = Integer.parseInt(rDryCarpet.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalCarpetPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        } }
//*******************************************************************************************************

    public void colorMin(View view) {
        cDryColor--;
        if (cDryColor<=0)
            cDryColor=0;   qDryColor.setText(Integer.toString(cDryColor));

        try {

            int txt1Value = Integer.parseInt(qDryColor.getText().toString());
            int txt2Value = Integer.parseInt(rDryColor.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalColorPrice.setText(String.valueOf(txt1Value));


        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }}

    public void colorMax(View view) {
        cDryColor++;
        qDryColor.setText(Integer.toString(cDryColor));
        try {

            int txt1Value = Integer.parseInt(qDryColor.getText().toString());
            int txt2Value = Integer.parseInt(rDryColor.getText().toString());
            txt1Value = txt2Value * txt1Value;
            totalColorPrice.setText(String.valueOf(txt1Value));

        }catch (Exception ex){
            Toast.makeText(Drycleaning.this, "Enter a number", Toast.LENGTH_SHORT);
        }
    }

    //******************************************************************************************************

}
