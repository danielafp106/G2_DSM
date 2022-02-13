package udb.fp180271dsm.deduccionesdeley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txtName;
    private EditText txtHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtHoras = findViewById(R.id.txtHoras);
    }

    public void Resultados(View v)
    {
        Intent i = new Intent(this,ResultadosActivity.class);
        i.putExtra("txtName", txtName.getText().toString());
        i.putExtra("txtHoras",Double.valueOf(txtHoras.getText().toString()));
        startActivity(i);

        //Intent: es un objeto de mensajería que puedes usar para solicitar una acción de otro componente de
        //una app. Si bien las intents facilitan la comunicación entre componentes de varias formas.

    }
}