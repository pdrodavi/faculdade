package rokobasi.com.br.acquali;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AcudesActivity extends AppCompatActivity {

    ListView listViewAcudes;
    String bacia;
    String path;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    private List<String> listAcudes = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapterAcudes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acudes);

        // método action bar para botão back
        ActionBar bar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // titulo da actionbar
        ActionBar actionbarNome = getSupportActionBar();

        // recebendo parametros da outra tela
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        if(params!=null)
        {
            bacia = params.getString("bacia");
            path = params.getString("acude");
            actionbarNome.setTitle("Acúdes da bacia " + bacia);
        }

        carregarLista(path);

        ClicarItemSelecionado();

    }

    private void ClicarItemSelecionado(){

        listViewAcudes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {

                    Object itemLista = listViewAcudes.getItemAtPosition(position);
                    String acudeRegistro = itemLista.toString();

                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    String uid = user.getUid();

                    Intent i = new Intent(AcudesActivity.this, InserirRegistro.class);
                    Bundle params = new Bundle();

                    String emailAgente = email;
                    String baciaRegistro = bacia;
                    String subBaciaRegistro = "";

                    params.putString("agente", emailAgente);
                    params.putString("bacia", bacia);
                    params.putString("subBacia", subBaciaRegistro);
                    params.putString("acude", acudeRegistro);

                    i.putExtras(params);

                    startActivity(i);

                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista(path);
    }

    private void carregarLista(String path) {

        listViewAcudes = (ListView) findViewById(R.id.listViewAcudes);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(path);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAcudes.clear();

                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){

                    String bacia = objSnapShot.getValue().toString();
                    listAcudes.add(bacia);

                }

                arrayAdapterAcudes = new ArrayAdapter<>(AcudesActivity.this, android.R.layout.simple_list_item_1, listAcudes);
                listViewAcudes.setAdapter(arrayAdapterAcudes);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    // método botão back action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, BaciasActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void onBackPressed(){ // Botão BACK padrão do android
        startActivity(new Intent(this, BaciasActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }
}

