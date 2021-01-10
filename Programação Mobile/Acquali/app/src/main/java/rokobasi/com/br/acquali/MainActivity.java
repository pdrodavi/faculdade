package rokobasi.com.br.acquali;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etSenha;
    private Button btIniciar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarComponentesGraficos();

        btIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();
                login(email, senha);
            }
        });

    }

    private void inicializarComponentesGraficos() {
        etEmail = (EditText) findViewById(R.id.et_usuario);
        etSenha = (EditText) findViewById(R.id.et_senha);
        btIniciar = (Button) findViewById(R.id.bt_entrar);
    }

    // método validação de login com firebase
    private void login(String email, String senha){
        auth.signInWithEmailAndPassword(email, senha).
                addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()&&Conexao.getFirebaseUser().getEmail().toString().equals("teste@teste.com")){
                    alert("Bem Vindo ADM");
                    // aqui abrir a tela de adm
                } else if (task.isSuccessful()){
                    alert("Login efetuado com Sucesso!");
                    Intent i = new Intent(MainActivity.this, BaciasActivity.class);
                    startActivity(i);
                } else {
                    alert("Email ou senha incorretos!");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        auth = Conexao.getFirebaseAuth();
    }

    public void alert(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
