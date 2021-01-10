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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SubBaciasActivity extends AppCompatActivity {

    ListView listViewSubBacias;
    String bacia;
    String path;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    private List<String> listSubBacias = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapterSubBacias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_bacias);

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
            path = params.getString("subBacia");
            actionbarNome.setTitle("Sub-Bacias do " + bacia);
        }

        carregarListaSubBacias(path);

        itemSelecionado();

    }

    private void itemSelecionado(){

        listViewSubBacias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object itemLista = listViewSubBacias.getItemAtPosition(position);
                String path = itemLista.toString();

                Object itemListaNomeSubBacia = listViewSubBacias.getItemAtPosition(position);
                String nomeSubBacia = itemListaNomeSubBacia.toString();

                if(path.equals("Sub-Bacia do Rio do Peixe")){

                    Intent i = new Intent(SubBaciasActivity.this, AcudesSubBaciaActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Piranhas";
                    String chaveSubBacia = "Sub-Bacias Rio Piranha";
                    String subBacia = nomeSubBacia;
                    String SubSubBacia = "Sub-Bacia do Rio do Peixe";
                    String acudesSubBacia = "Sub-Bacia do Rio do Peixe";
                    params.putString("bacia", bacia);
                    params.putString("chave-subBacia", chaveSubBacia);
                    params.putString("acudesSubBacia", acudesSubBacia);
                    params.putString("subSubBacia", SubSubBacia);
                    params.putString("nome-sub-bacia", subBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Sub-Bacia do Rio Piancó")){

                    Intent i = new Intent(SubBaciasActivity.this, AcudesSubBaciaActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Piranhas";
                    String chaveSubBacia = "Sub-Bacias Rio Piranha";
                    String subBacia = nomeSubBacia;
                    String SubSubBacia = "Sub-Bacia do Rio Piancó";
                    String acudesSubBacia = "Sub-Bacia do Rio Piancó";
                    params.putString("bacia", bacia);
                    params.putString("chave-subBacia", chaveSubBacia);
                    params.putString("acudesSubBacia", acudesSubBacia);
                    params.putString("subSubBacia", SubSubBacia);
                    params.putString("nome-sub-bacia", subBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Sub-Bacia do Rio Espinharas")){

                    Intent i = new Intent(SubBaciasActivity.this, AcudesSubBaciaActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Piranhas";
                    String chaveSubBacia = "Sub-Bacias Rio Piranha";
                    String subBacia = nomeSubBacia;
                    String SubSubBacia = "Sub-Bacia do Rio Espinharas";
                    String acudesSubBacia = "Sub-Bacia do Rio Espinharas";
                    params.putString("bacia", bacia);
                    params.putString("chave-subBacia", chaveSubBacia);
                    params.putString("acudesSubBacia", acudesSubBacia);
                    params.putString("subSubBacia", SubSubBacia);
                    params.putString("nome-sub-bacia", subBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Sub-Bacia do Rio Seridó")){

                    Intent i = new Intent(SubBaciasActivity.this, AcudesSubBaciaActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Piranhas";
                    String chaveSubBacia = "Sub-Bacias Rio Piranha";
                    String subBacia = nomeSubBacia;
                    String SubSubBacia = "Sub-Bacia do Rio Seridó";
                    String acudesSubBacia = "Sub-Bacia do Rio Seridó";
                    params.putString("bacia", bacia);
                    params.putString("chave-subBacia", chaveSubBacia);
                    params.putString("acudesSubBacia", acudesSubBacia);
                    params.putString("subSubBacia", SubSubBacia);
                    params.putString("nome-sub-bacia", subBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if(path.equals("Sub-Bacia Taperoá")){

                    Intent i = new Intent(SubBaciasActivity.this, AcudesSubBaciaActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Paraíba";
                    String chaveSubBacia = "Sub-Bacias Rio Paraíba";
                    String subBacia = nomeSubBacia;
                    String SubSubBacia = "Sub-Bacia Taperoá";
                    String acudesSubBacia = "Sub-Bacia Taperoá";
                    params.putString("bacia", bacia);
                    params.putString("chave-subBacia", chaveSubBacia);
                    params.putString("acudesSubBacia", acudesSubBacia);
                    params.putString("subSubBacia", SubSubBacia);
                    params.putString("nome-sub-bacia", subBacia);
                    i.putExtras(params);
                    startActivity(i);

                }

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaSubBacias(path);
    }

    private void carregarListaSubBacias(String path) {

        listViewSubBacias = (ListView) findViewById(R.id.listViewSubBacias);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(path);

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listSubBacias.clear();

                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){

                    String bacia = objSnapShot.getValue().toString();
                    listSubBacias.add(bacia);

                }

                arrayAdapterSubBacias = new ArrayAdapter<>(SubBaciasActivity.this, android.R.layout.simple_list_item_1, listSubBacias);
                listViewSubBacias.setAdapter(arrayAdapterSubBacias);
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
