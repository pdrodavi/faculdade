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

public class AcudesSubBaciaActivity extends AppCompatActivity {

    ListView listViewAcudesSubBacia;
    String bacia;
    String chaveSubBacia;
    String subSubBacia;
    String subBacia;
    String acude;
    String path;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    private List<String> listAcudesSubBacia = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapterAcudesSubBacia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acudes_sub_bacia);

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
            chaveSubBacia = params.getString("chave-subBacia");
            subBacia = params.getString("nome-sub-bacia");
            subSubBacia = params.getString("subSubBacia");

            path = params.getString("acudesSubBacia");
            actionbarNome.setTitle("Acúdes da " + subSubBacia);
        }

        carregarAcudesSubBacia(path);

        ClicarItemSelecionado();
    }

    private void ClicarItemSelecionado(){

        listViewAcudesSubBacia.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                if (user != null) {

                    String name = user.getDisplayName();
                    String email = user.getEmail();
                    String uid = user.getUid();

                    Object itemLista = listViewAcudesSubBacia.getItemAtPosition(position);
                    String acudeRegistro = itemLista.toString();

                    Intent i = new Intent(AcudesSubBaciaActivity.this, InserirRegistro.class);
                    Bundle params = new Bundle();

                    String emailAgente = email;
                    String baciaRegistro = bacia;
                    String subBaciaRegistro = subBacia;

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
        carregarAcudesSubBacia(path);
    }

    private void carregarAcudesSubBacia(String path){

        listViewAcudesSubBacia = (ListView) findViewById(R.id.listViewAcudesSubBacia);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(path);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listAcudesSubBacia.clear();

                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){

                    String bacia = objSnapShot.getValue().toString();
                    listAcudesSubBacia.add(bacia);

                }

                arrayAdapterAcudesSubBacia = new ArrayAdapter<>(AcudesSubBaciaActivity.this, android.R.layout.simple_list_item_1, listAcudesSubBacia);
                listViewAcudesSubBacia.setAdapter(arrayAdapterAcudesSubBacia);
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
