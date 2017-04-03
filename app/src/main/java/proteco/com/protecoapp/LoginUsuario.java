package proteco.com.protecoapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginUsuario extends AppCompatActivity {
    private FirebaseAuth mAuth;
    Button btnUsuarioLogin;
    EditText edtUsuarioLogin;
    EditText edtPasswordLogin;
    TextView tvLoginRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_usuario);

        mAuth = FirebaseAuth.getInstance();

        btnUsuarioLogin = (Button)findViewById(R.id.btn_login);
        edtPasswordLogin = (EditText)findViewById(R.id.edt_passwd_login);
        edtUsuarioLogin = (EditText)findViewById(R.id.edt_usuario_login);
        tvLoginRegistro = (TextView) findViewById(R.id.tv_login_registro);

        tvLoginRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuario();
            }
        });

        btnUsuarioLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUsuario(edtUsuarioLogin.getText().toString(),edtPasswordLogin.getText().toString());
            }
        });
    }

    protected void loginUsuario(String usuario, String password){
        mAuth.signInWithEmailAndPassword(usuario, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginUsuario.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginUsuario.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    protected void registrarUsuario(){
        Intent intent_Registro = new Intent(getApplicationContext(), RegistroUsuario.class);
        startActivity(intent_Registro);
    }
}
