package com.example.crudfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Agregar extends AppCompatActivity {
    EditText nombre, marca, precio;
    Button btnAdd, btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombre = findViewById(R.id.nombreText);
        marca = findViewById(R.id.marcaText);
        precio = findViewById(R.id.precioText);

        btnAdd = findViewById(R.id.btn_agregar);
        btnAtras = findViewById(R.id.btn_atras);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarDatos();
            }
        });
        btnAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void insertarDatos(){
        Map<String,Object> map = new HashMap<>();
        map.put("Nombre", nombre.getText().toString());
        map.put("Marca", marca.getText().toString());
        map.put("Precio", precio.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("Programación Android").push()
                .setValue(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(Agregar.this,"Insertado Correctamente",Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Agregar.this, "Error al Insertar",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}