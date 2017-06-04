package com.example.pr_idi.mydatabaseexample;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AltaMonedesActivity extends AppCompatActivity implements View.OnClickListener{

    private CoinData CD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_monedes);
        Button button = (Button)findViewById(R.id.buttonOKAlta);
        button.setOnClickListener(this);
        button = (Button)findViewById(R.id.buttonCancelAlta);
        button.setOnClickListener(this);
    }

    private void afegirMoneda(View view) {
        Coin coin = new Coin();

        //SET NOM
        TextView text = (TextView)findViewById(R.id.textNomAltaMoneda);
        String nom = text.getText().toString();

        //SET VALUE
        text = (TextView)findViewById(R.id.textValorAltaMoneda);
        Double value = Double.parseDouble(text.getText().toString());

        //SER YEAR
        text = (TextView)findViewById(R.id.textAnyAcunyacioAltaMoneda);
        Integer year = Integer.parseInt(text.getText().toString());

        //SET COUNTRY
        text = (TextView)findViewById(R.id.textPaisAltaMoneda);
        String country = text.getText().toString();

        //SET DESCRIPTION
        text = (TextView)findViewById(R.id.textDescripcioAltaMoneda);
        String description = text.getText().toString();

        CD.createCoin(nom, value,country, year, description);

    }

    private void cancelaMoneda() {}

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonOKAlta:
                afegirMoneda(view);
                break;
            case R.id.buttonCancelAlta:
                cancelaMoneda();
                break;
        }
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }
}
