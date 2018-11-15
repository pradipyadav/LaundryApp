package sony.com.k9drycleaning;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "k9laundry";
    private static final String TABLE_NAME = "product_order";
    private static final String COL_1 = "id";
    private static final String COL_2 = "p_name";
    private static final String COL_3 = "p_qyantity";
    private static final String COL_4 = "p_price";

    public DataBaseHelper( Context context) {
        super(context,DATABASE_NAME,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+"(ID INTEGER PRIMARY KEY AUTOINCREMENT,p_name TEXT,p_qyantity INTEGER,p_price INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
    public boolean insertData(String name,String quantity,String price) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(COL_2, name);
        cv.put(COL_3, quantity);
        cv.put(COL_4, price);

        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1)
            return false;
        else
            return true;
    }
}
