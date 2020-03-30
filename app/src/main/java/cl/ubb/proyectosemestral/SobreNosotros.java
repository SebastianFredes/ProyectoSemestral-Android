package cl.ubb.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SobreNosotros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_nosotros);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


}
