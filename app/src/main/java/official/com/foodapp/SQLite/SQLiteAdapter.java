package official.com.foodapp.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

public class SQLiteAdapter {
    String NAME = "foodapp.db";
    int VERSION = 1;
    SQLiteHelper helper;
    SQLiteDatabase database;
    Context ctx;

    public SQLiteAdapter(Context context){
     helper = new SQLiteHelper(context,NAME,VERSION);
     database = helper.getWritableDatabase();
     ctx = context;
    }

    public void insertUser(int id, String name, String age, String phone, String address){
        ContentValues contentValues = new ContentValues();
        contentValues.put("id",id);
        contentValues.put("name",name);
        contentValues.put("age",age);
        contentValues.put("phone",phone);
        contentValues.put("address",address);
        long isInsert = database.insert("USER",null,contentValues);
        if (isInsert == -1){
            Toast.makeText(ctx,"Failed to insert new row.",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(ctx,"New record inserted.",Toast.LENGTH_SHORT).show();
        }
    }

    public void updateUser(String id, String name, String age, String phone, String address){
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("age",age);
        cv.put("phone",phone);
        cv.put("address",address);
        int i = database.update("USER",cv,"id=?",new String[]{id});
        Log.e("SQLiteAdapter","int i = "+i);
    }

    public void readUser(){
        Cursor cursor = database.rawQuery("SELECT * from USER",null);
        if (cursor.getCount() != -1){
            while (cursor.moveToNext()){
//                String id = cursor.getString(cursor.getColumnIndex("id"));
//                String name = cursor.getString(cursor.getColumnIndex("name"));
//                String age = cursor.getString(cursor.getColumnIndex("age"));
//                String phone = cursor.getString(cursor.getColumnIndex("phone"));
//                String address = cursor.getString(cursor.getColumnIndex("address"));
                String id = cursor.getString(0);
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                String phone = cursor.getString(3);
                String address = cursor.getString(4);
                Log.e("SQLiteAdapter","id:"+id+" , name:"+name+" , age:"+age+" , phone:"+phone+" , address"+address);
            }
        }
    }
}
