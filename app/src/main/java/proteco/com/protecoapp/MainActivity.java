package proteco.com.protecoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvBienvenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBienvenido = (TextView)findViewById(R.id.tv_bienvenido);

        tvBienvenido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    iniciar();
            }
        });
    }

    public void iniciar(){
        Toast.makeText(getApplicationContext(),"->",Toast.LENGTH_SHORT).show();
        Intent intencion_bienvenido = new Intent(getApplicationContext(),LoginUsuario.class);
        startActivity(intencion_bienvenido);
    }
}
