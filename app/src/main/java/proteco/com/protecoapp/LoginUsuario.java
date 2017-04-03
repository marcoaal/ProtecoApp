package proteco.com.protecoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginUsuario extends AppCompatActivity {

    Button btnUsuarioLogin;
    EditText edtUsuarioLogin;
    EditText edtPasswordLogin;
    TextView tvLoginRegistro;

    String usuario;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        btnUsuarioLogin = (Button)findViewById(R.id.btn_login);
        edtPasswordLogin = (EditText)findViewById(R.id.edt_passwd_login);
        edtUsuarioLogin = (EditText)findViewById(R.id.edt_usuario_login);
        tvLoginRegistro = (TextView) findViewById(R.id.tv_login_registro);

        usuario = edtUsuarioLogin.getText().toString();
        password = edtPasswordLogin.getText().toString();

        tvLoginRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        btnUsuarioLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario(usuario,password);
            }
        });
    }

    protected void loginUsuario(String usuario, String password){

    }

    protected void registrarUsuario(){
        Intent intent_Registro = new Intent(getApplicationContext(), RegistroUsuario.class);
        startActivity(intent_Registro);
    }
}
