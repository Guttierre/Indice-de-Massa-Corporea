package br.senac.pi.indicemassacorporea;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //myCode________________
        findViewById(R.id.btnImc).setOnClickListener(imc());

    }
    //MyCode
    private View.OnClickListener imc(){
        return new View.OnClickListener(){
            @Override
            public void onClick(View view){
                EditText edtPeso = (EditText) findViewById(R.id.edtPeso);
                EditText edtAltura = (EditText) findViewById(R.id.edtAltura);
                //Converter para double
                double peso = Double.parseDouble(edtPeso.getText().toString());
                double altura = Double.parseDouble(edtAltura.getText().toString());
                double total = peso / (altura * altura);
                TextView txtResultado = (TextView) findViewById(R.id.txtResultado);
                txtResultado.setText(getString(R.string.total) + " "+ total);

                if(total <= 18.5){
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao1));
                }else if(total >= 18.6 && total <= 24.9){
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao2));
                }else if(total >= 25 && total <= 29.9){
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao3));
                }else if(total >= 30 && total <= 34.9){
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao4));
                }else if(total >= 35 && total <= 39.9){
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao5));
                }else{
                    TextView txtClassific = (TextView) findViewById(R.id.txtClassific);
                    txtClassific.setText(getString(R.string.classificacao6));
                }
            }
        };
    }
    //______________
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}