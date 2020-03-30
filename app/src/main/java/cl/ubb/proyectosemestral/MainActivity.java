package cl.ubb.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Snosotros (View view) {
        Intent snosotros = new Intent(this, SobreNosotros.class);
        startActivity(snosotros);
    }
    public void sandwichesL (View view) {
        Intent sandwichesl = new Intent(this, Sandwiches.class);
        startActivity(sandwichesl);
    }

}
