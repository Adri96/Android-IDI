package main.java.com.example.pr_idi.mydatabaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gabri on 04/06/2017.
 */

public class DBhelper extends SQLiteOpenHelper {

    public static final String DBname = "Monedes.db";
    public static final int DBversion = 1;

    public DBhelper(Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //CREATE TABLE Monedes (
        //                      _ID INTEGER PRIMARY KEY AUTOINCREMENT
        //
        //                      )
        db.execSQL("CREATE TABLE");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
