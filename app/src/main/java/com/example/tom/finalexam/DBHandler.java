package com.example.tom.finalexam;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tom on 12/8/2015.
 */
public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "host.db";

    //HOST TABLE
    public static final String TABLE_HOST = "host";

    public static final String COLUMN_HOSTID = "_id";
    public static final String COLUMN_EMAIL = "email";

    //MEETING TABLE
    public static final String TABLE_MEETING = "meeting";

    public static final String COLUMN_MEETINGID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_DESCRIPTION= "description";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_TIME = "time";
    public static final String COLUMN_HOST_ID = "hostid";

    private Host[] hostData;
    private Meeting[] meetingData;

    public DBHandler(Context context, SQLiteDatabase.CursorFactory factory) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //host table
        String query = "CREATE TABLE " + TABLE_HOST + "(" +
                COLUMN_HOSTID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT " +
                ");";
        db.execSQL(query);

        //meeting table
        query = "CREATE TABLE " + TABLE_MEETING + "(" +
                COLUMN_MEETINGID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_LOCATION + " TEXT, " +
                COLUMN_DATE + " TEXT, " +
                COLUMN_TIME + " TEXT, " +
                COLUMN_HOSTID + " TEXT " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_HOST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEETING);
        onCreate(db);
    }

    public void addHost(String email) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_EMAIL, email);

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_HOST, null, values);

        db.close();

    }

    //Add a row to the meeting table
    public void addMeeting(String name, String description, String location,
                           String date, String time, String hostid){

        //inserting column name and value
        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, name);
        values.put(COLUMN_DESCRIPTION, description);
        values.put(COLUMN_LOCATION, location);
        values.put(COLUMN_DATE, date);
        values.put(COLUMN_TIME, time);
        values.put(COLUMN_HOST_ID, hostid);

        SQLiteDatabase db = getWritableDatabase();

        db.insert(TABLE_MEETING, null, values);

        db.close();
    }

    public Host[] getHost() {

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_HOST + ";";

        Cursor c = db.rawQuery(query, null);

        int numHost = c.getCount();

        if (numHost >= 1) {

            hostData = new Host[numHost];

            int i = 0;

            c.moveToFirst();

            while (!c.isAfterLast()) {

                hostData[i] = new Host(c.getString(c.getColumnIndex("email"))
                );

                c.moveToNext();

                i++;
            }
        }

        db.close();
        return hostData;
    }

    public Meeting[] getMeeting() {

        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_MEETING + ";";

        Cursor c = db.rawQuery(query, null);

        int numMeeting = c.getCount();

        if (numMeeting >= 1) {

            meetingData = new Meeting[numMeeting];

            int i = 0;

            c.moveToFirst();

            while (!c.isAfterLast()) {

                meetingData[i] = new Meeting (c.getString(c.getColumnIndex("name")),
                        c.getString(c.getColumnIndex("description")),
                        c.getString(c.getColumnIndex("location")),
                        c.getString(c.getColumnIndex("date")),
                        c.getString(c.getColumnIndex("time")),
                        c.getInt(c.getColumnIndex("hostid"))
                );

                c.moveToNext();

                i++;
            }
        }

        db.close();

        return meetingData;
    }
}