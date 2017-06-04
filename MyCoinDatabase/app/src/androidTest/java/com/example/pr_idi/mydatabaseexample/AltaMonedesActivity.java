package com.example.pr_idi.mydatabaseexample;


import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AltaMonedesActivity extends AppCompatActivity implements View.OnClickListener{


    private static final int PICK_IMAGE = 100;
    private Integer numImatges = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta_monedes);

        //OK BUTTON
        Button button = (Button)findViewById(R.id.buttonOKAlta);
        button.setOnClickListener(this);

        //CANCEL BUTTON
        button = (Button)findViewById(R.id.buttonCancelAlta);
        button.setOnClickListener(this);

        //ADD IMAGE BUTTON
        ImageView imagen = (ImageView)findViewById(R.id.buttonAfegirImatgeAltaMoneda);
        imagen.setImageResource(R.mipmap.add_image_picture);
        imagen.setOnClickListener(this);
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
        CoinData coinData = new CoinData(view.getContext());
        coinData.createCoin(nom, value,country, year, description);

        //AÑADIR A DATABASE
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);

    }

    //AQUI PIDE LA FOTO AL SISTEMA
    private void afegirImatge() {
            Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
            startActivityForResult(gallery, PICK_IMAGE);
        if(numImatges >= 2) deleteAfegirImatges();
    }

    //AQUI RECOGE LA FOTO QUE EL SISTEMA DEVUELVE Y LA PONGO COMO IMAGEN DEL IMAGEVIEW 1 O 2 segun numImatges
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            Uri imageUri = data.getData();
            ImageView imagen;
            if(numImatges == 0)
                imagen = (ImageView)findViewById(R.id.imatge1AltaMoneda);
            else
                imagen = (ImageView)findViewById(R.id.imatge2AltaMoneda);
            imagen.setImageURI(imageUri);
            numImatges++;


        }
    }


    private void deleteAfegirImatges() {
        ImageButton imageButton = (ImageButton)findViewById(R.id.buttonAfegirImatgeAltaMoneda);
        ViewGroup layout = (ViewGroup)findViewById(R.id.layoutInteriorScroll);
        layout.removeView(imageButton);
    }

    private void cancelaMoneda() {

        Intent intent =  new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonOKAlta:
                afegirMoneda(view);
                break;
            case R.id.buttonCancelAlta:
                cancelaMoneda();
            case R.id.buttonAfegirImatgeAltaMoneda:
                afegirImatge();
                break;
        }
    }
}
