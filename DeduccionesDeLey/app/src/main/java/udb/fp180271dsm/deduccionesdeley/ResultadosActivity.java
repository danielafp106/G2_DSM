package udb.fp180271dsm.deduccionesdeley;

import android.icu.text.DecimalFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultadosActivity extends AppCompatActivity {

    private TextView txtSalarioNeto;
    private TextView txtAFP;
    private TextView txtNombre;
    private TextView txtHoras;
    private TextView txtISSS;
    private TextView txtSalarioFinal;
    private TextView txtRenta;
    private String nombre;
    private double horas;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        txtNombre = findViewById(R.id.txtNombre);
        txtHoras = findViewById(R.id.txtHoritas);
        txtSalarioNeto = findViewById(R.id.txtSalarioNeto);
        txtAFP = findViewById(R.id.txtAFP);
        txtISSS = findViewById(R.id.txtISSS);
        txtRenta = findViewById(R.id.txtRenta);
        txtSalarioFinal = findViewById(R.id.txtSalarioFinal);

        Bundle bundle = getIntent().getExtras(); //lo que pasamos
        nombre = bundle.getString("txtName");
        horas = bundle.getDouble("txtHoras");
        Calculos(nombre,horas);
        txtNombre.setText(""+nombre);
        txtHoras.setText(""+horas+" horas");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void Calculos(String name, double horas)
    {
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double valorHora = 8.5;
        Double salarioTotal = valorHora*horas;
        Double afp=0.03*salarioTotal;
        Double isss=0.02*salarioTotal;
        Double renta=0.04*salarioTotal;
        Double salarioFinal = salarioTotal -afp-isss-renta;
        txtSalarioNeto.setText("$"+formateador.format(salarioTotal));
        txtAFP.setText("- $"+formateador.format(afp));
        txtISSS.setText("- $"+formateador.format(isss));
        txtRenta.setText("- $"+formateador.format(renta));
        txtSalarioFinal.setText("$"+formateador.format(salarioFinal));



    }

    public void FinishA(View v)
    {
        finish();
    }
}