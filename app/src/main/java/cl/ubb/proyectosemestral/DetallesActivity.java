package cl.ubb.proyectosemestral;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetallesActivity extends AppCompatActivity {

    private TextView Ddnombre, Dddescrip, Ddprecio;
    private ImageView Ddimagen;
    private MDetalles mDetalles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            mDetalles = (MDetalles) getIntent().getExtras().getSerializable("model");
        } catch (Exception e) {
            finish();
        }

        Ddimagen = (ImageView) findViewById(R.id.dimagen);

        Ddnombre = (TextView) findViewById(R.id.dnombre);
        Dddescrip = (TextView) findViewById(R.id.ddescrip);
        Ddprecio = (TextView) findViewById(R.id.dprecio);

        Ddnombre.setText(mDetalles.getNombre());
        Dddescrip.setText(mDetalles.getDescripcion());
        Ddprecio.setText(mDetalles.getPrecio());
        Ddimagen.setImageResource(mDetalles.getImagen());

    }

    public static Intent getCallingIntent(Context context, MDetalles mDetalles){
        Intent intent = new Intent(context, DetallesActivity.class);
        intent.putExtra("model", mDetalles);
        return intent;
    }
}
