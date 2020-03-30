package cl.ubb.proyectosemestral;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Sandwiches extends AppCompatActivity {

    private ListView lvlista;
    private Adapter adapter;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sandwiches);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        context = this;

        //Se crea el Arraylist y se cargan los sandwiches creados al final de esta clase
        ArrayList<sandwiches> lista = new ArrayList<sandwiches>();
        lista.add(italiano);
        lista.add(chacarero);
        lista.add(arrolladohuaso);
        lista.add(barrosluco);
        lista.add(depotito);
        lista.add(chemilico);
        lista.add(mechada);

        //Se carga el adapter personalizado creado en Adapter y que usa row.xml para el estilo
        adapter = new Adapter(this, lista);

        lvlista = (ListView)findViewById(R.id.lvlista);
        //ArrayAdapter<sandwiches> adaptador = new ArrayAdapter<sandwiches>(Sandwiches.this,android.R.layout.simple_list_item_1,lista);
        lvlista.setAdapter(adapter);

        lvlista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                sandwiches _sandwiches = (sandwiches) adapter.getItem(position);

                MDetalles mDetalles = new MDetalles();
                mDetalles.setNombre(_sandwiches.getNombre());
                mDetalles.setDescripcion(_sandwiches.getDescripcion());
                mDetalles.setPrecio(_sandwiches.getPrecio());
                mDetalles.setImagen(_sandwiches.getImagen());

                startActivity(DetallesActivity.getCallingIntent(context, mDetalles));
            }
        });

    }

    public class sandwiches{
       private String nombre;
       private int imagen;
       private String descripcion;
       private String precio;

        public sandwiches(){

        }

        public sandwiches(String nombre, int imagen, String descripcion, String precio) {
            this.nombre = nombre;
            this.imagen = imagen;
            this.descripcion = descripcion;
            this.precio = precio;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getImagen() {
            return imagen;
        }

        public void setImagen(int imagen) {
            this.imagen = imagen;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getPrecio() {
            return precio;
        }

        public void setPrecio(String precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return nombre;
        }

    }
    sandwiches italiano = new sandwiches("ITALIANO",R.drawable.italiano,"CONTIENE 400 GRAMOS DE BISTEC DE POSTA ROSADA, 2 PALTAS MADURAS, TOMATE Y MAYONESA QUE REPOSAN SOBRE DOS PANES FRICA.","$3500");
    sandwiches chacarero = new sandwiches("CHACARERO",R.drawable.chacarero,"CONTIENE 400 GRAMOS DE CHURRASCO EN LAMINAS, TOMATE, POROTOS VERDES Y AJÍ VERDE A ELECCIÓN, TODO ESTO EN DOS PANES FRICA.","$4000");
    sandwiches barrosluco = new sandwiches("BARROS LUCO",R.drawable.barrosluco,"CONTIENE 4 CHURRASCOS Y 4 REBANADAS DE QUESO CHANCO, CONTENIDOS DENTRO DE UNA MARRAQUETA.","$2000");
    sandwiches arrolladohuaso = new sandwiches("ARROLLADO HUASO",R.drawable.arrolladoh,"CONTIENE RODAJAS GRUESAS DE ARROLLADO HUASO CON AJÍ, TOMATE, CEBOLLA EN ESCABECHE, CILANTRO FRESCO Y MAYONESA, TODO ESTO EN PAN TIPO MARRAQUETA.","$3500");
    sandwiches depotito = new sandwiches("DE POTITO",R.drawable.depotito,"CONTIENE 100 GRAMOS DE TRIPA DE VACUNO, 200 GRAMOS DE GUATITAS, VINGRE, CEBOLLA, ZANAHORIA, UN DIETE DE AJO, LONGANIZA Y PEBRE, ESTO DENTRO DE DOS PANES FRICA.","$2500");
    sandwiches chemilico = new sandwiches("CHEMILICO",R.drawable.chemilico,"CONTIENE MEDIA CEBOLLA EN PLUMA FRITA, UN HUEVO FRITO Y UN BISTEC, ESTO DENTRO DE DOS PANES FRICA.","$3000");
    sandwiches mechada = new sandwiches("MECHADA",R.drawable.mechada,"CONTIENE CARNE DE VACUNO A LA OLLA MECHADA, ACOMPAÑADA DE PALTA, RODAJAS DE TOMATE Y MAYONESA, ESTO DENTRO DE DOS PANES FRICA.","$3000");
}
