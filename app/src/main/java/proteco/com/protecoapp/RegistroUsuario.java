package proteco.com.protecoapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistroUsuario extends AppCompatActivity {
    private FirebaseAuth mAuth;

    EditText edtUsuarioRegistro;
    EditText edtPasswdRegistro;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        mAuth = FirebaseAuth.getInstance();

        edtPasswdRegistro = (EditText) findViewById(R.id.edt_passwd_registro);
        edtUsuarioRegistro = (EditText) findViewById(R.id.edt_usuario_registro);
        btnRegistro = (Button) findViewById(R.id.btn_registro);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser(){

        //creating a new user
        mAuth.createUserWithEmailAndPassword(edtUsuarioRegistro.getText().toString().trim(), edtPasswdRegistro.getText().toString().trim())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(getApplicationContext(),"Usuario registrado exitosamente",Toast.LENGTH_SHORT).show();
                        }else{
                            //display some message here
                            Toast.makeText(getApplicationContext(),"El usuario ya existe",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

    }
}
