package udb.fp180271dsm.g2dr1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int contador =0;
    private TextView txtNumber;
    private Button btnSumar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = (TextView) findViewById(R.id.txtNumber);
        btnSumar=findViewById(R.id.btnSumar);
        if(savedInstanceState!=null)
        {
            contador=savedInstanceState.getInt("Contador");
            txtNumber.setText(String.valueOf(contador));
        }
    }

    public void Sumar(View v)
    { contador = Integer.parseInt(txtNumber.getText().toString());
        if(contador <=8)
        {
            contador++;
        }
        else{
            contador =0;
        }
        String done = Integer.toString(contador);
        txtNumber.setText(done);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Contador", contador);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        contador=savedInstanceState.getInt("Contador");
        txtNumber.setText(String.valueOf(contador));

    }
}