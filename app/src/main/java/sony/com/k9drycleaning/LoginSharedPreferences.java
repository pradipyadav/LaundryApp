package sony.com.k9drycleaning;

import android.content.Context;
import android.content.SharedPreferences;

public class LoginSharedPreferences {

    private static LoginSharedPreferences mInstance;
    private static Context mCtxt;

    private static final String SHARED_PREF_Name="mySharedPref";
    private static final String KEY_User_Name="user_name";
    private static final String KEY_User_Password="password";


    private LoginSharedPreferences(Context context){

        mCtxt=context;
    }
    public static synchronized LoginSharedPreferences getmInstance(Context context){

        if (mInstance==null){
            mInstance=new LoginSharedPreferences(context);
        }
        return mInstance;
    }

    public boolean isLogedIn(){
        SharedPreferences sharedPreferences=mCtxt.getSharedPreferences(SHARED_PREF_Name,Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_User_Name,null) !=null){
            return true;
        }
        return false;
    }
    public boolean logout(){
        SharedPreferences sharedPreferences=mCtxt.getSharedPreferences(SHARED_PREF_Name,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }


}
