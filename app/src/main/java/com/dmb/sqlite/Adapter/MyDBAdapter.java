package com.dmb.sqlite.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.dmb.sqlite.Model.Student;
import com.dmb.sqlite.Model.Asignatura;
import com.dmb.sqlite.Model.Teacher;

import java.util.ArrayList;

/**
 * Created by davidmari on 22/1/18.
 */

public class MyDBAdapter {

    private static final String DATABASE_NAME = "SQLiteVictor.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =   "CREATE TABLE estudiantes (id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, nota integer);"+
            "CREATE TABLE profesores (id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, despacho text);"+
            "CREATE TABLE asignaturas (id integer primary key autoincrement, nombre text, horas integer);";
    private static final String DATABASE_DROP = "DROP TABLE IF EXISTS estudiantes;"+
            "DROP TABLE IF EXISTS profesores;"+"DROP TABLE IF EXISTST asignaturas";


    private final Context context;

    private MyDbHelper dbHelper;

    private SQLiteDatabase db;

    public MyDBAdapter (Context c){
        context = c;
        dbHelper = new MyDbHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
        open();

    }

    public void open(){

        try{
            db = dbHelper.getWritableDatabase();
        }catch(SQLiteException e){
            db = dbHelper.getReadableDatabase();
        }

    }

    public void insertStudent(String nombre, String ciclo, String curso, int edad, int nota) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("edad", edad);
        contentValues.put("ciclo", ciclo);
        contentValues.put("curso", curso);
        contentValues.put("nota", nota);
        db.insert("estudiantes", null, contentValues);
        Toast.makeText(context, "Estudiante "+nombre+" añadido", Toast.LENGTH_SHORT).show();
    }

    public void insertTeacher(String nombre, String ciclo, String curso, int edad, String despacho) {
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("edad", edad);
        contentValues.put("ciclo", ciclo);
        contentValues.put("curso", curso);
        contentValues.put("despacho", despacho);
        db.insert("profesores", null, contentValues);
        Toast.makeText(context, "Profesor "+nombre+" añadido", Toast.LENGTH_SHORT).show();
    }

    public void insertAsignatura(String nombre, int horas){
        db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",nombre);
        contentValues.put("horas",horas);
        db.insert("asignaturas",null,contentValues);
        Toast.makeText(context, "Asignatura "+nombre+" añadida", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Student> searchStudents(String sql) {
        db = dbHelper.getReadableDatabase();

        ArrayList<Student> students = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()){
            do {
                students.add(new Student(
                        c.getString(1),
                        c.getString(3),
                        c.getString(4),
                        Integer.parseInt(c.getString(5)),
                        Integer.parseInt(c.getString(2))));
            } while(c.moveToNext());
        }
        c.close();
        db.close();
        return students;
    }

    public ArrayList<Teacher> searchTeachers(String sql) {
        db = dbHelper.getReadableDatabase();

        ArrayList<Teacher> teachers = new ArrayList<>();
        Cursor c = db.rawQuery(sql, null);
        if (c.moveToFirst()){
            do {
                teachers.add(new Teacher(
                        c.getString(1),
                        c.getString(3),
                        c.getString(4),
                        c.getString(5),
                        c.getInt(2)));
            } while(c.moveToNext());
        }
        c.close();
        db.close();
        return teachers;
    }


    public ArrayList<Asignatura> searchAsignatura(String sql){
        db = dbHelper.getReadableDatabase();

        ArrayList<Asignatura> asignaturas = new ArrayList<>();
        Cursor c = db.rawQuery(sql,null);
        if (c.moveToFirst()){
            do{
                asignaturas.add(new Asignatura(
                        c.getString(1),
                        c.getInt(2)));
            } while (c.moveToNext());
        }
        c.close();
        db.close();
        return asignaturas;
    }

    public void deleteStudent(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete("Estudiantes", "id="+id, null);
        Toast.makeText(context, "Estudiante "+id+" eliminado", Toast.LENGTH_SHORT).show();
    }

    public void deleteTeacher(int id) {
        db = dbHelper.getWritableDatabase();
        db.delete("Profesores", "id="+id, null);
        Toast.makeText(context, "Profesor "+id+" eliminado", Toast.LENGTH_SHORT).show();
    }
    
    public void deleteAsignatura(int id){
        db = dbHelper.getWritableDatabase();
        db.delete("Asignaturas","id="+id,null);
        Toast.makeText(context, "Asignatura "+id+" eliminada", Toast.LENGTH_SHORT).show();
    }

    public void deleteDB() {
        context.deleteDatabase(DATABASE_NAME);
        Toast.makeText(context, "Base de datos borrada", Toast.LENGTH_SHORT).show();
    }

    private static class MyDbHelper extends SQLiteOpenHelper {

        public MyDbHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
            super(context,name,factory,version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE estudiantes (id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, nota integer);");
            db.execSQL("CREATE TABLE profesores (id integer primary key autoincrement, nombre text, edad integer, ciclo text, curso text, despacho text);");
            db.execSQL("CREATE TABLE asignaturas (id integer primary key autoincrement, nombre text, horas integer);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(DATABASE_DROP);
            onCreate(db);
        }

    }
}
