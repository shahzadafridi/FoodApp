package official.com.foodapp.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {

    String USER_TABLE = "CREATE TABLE USER (\n" +
            "    id int,\n" +
            "    name varchar(255),\n" +
            "    age varchar(255),\n" +
            "    phone varchar(255),\n" +
            "    address varchar(255)\n" +
            ");";

    public SQLiteHelper(@Nullable Context context, @Nullable String name, int version) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
