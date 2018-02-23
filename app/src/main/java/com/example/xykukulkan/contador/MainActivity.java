
package com.example.xykukulkan.contador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected Button btnContar;
    private Button btnReiniciar;
    private EditText editContador;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnContar = (Button)this.findViewById(R.id.botonContar);
        btnReiniciar = (Button)this.findViewById(R.id.botonReiniciar);
        editContador = (EditText)this.findViewById(R.id.campoConteo);

        this.restore(savedInstanceState);
        btnContar.setOnClickListener( e -> {
            //contador = Integer.parseInt(editContador.getText().toString());
            contador += 1;
            editContador.setText(Integer.toString(contador));
        });

        btnReiniciar.setOnClickListener( e -> {
            editContador.setText("0");
            contador = 0;
        });
    }

    protected void restore(Bundle bundle){
        super.onRestoreInstanceState(bundle);
        contador = bundle.getInt("CONT");
        editContador.setText(Integer.toString(contador));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("CONT", contador);
    }
}
