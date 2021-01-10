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
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class BaciasActivity extends AppCompatActivity {

    ListView listViewBacias;

    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    private List<String> listBacias = new ArrayList<String>();
    private ArrayAdapter<String> arrayAdapterBacias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacias);

        // método action bar para botão back
        ActionBar bar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // titulo da actionbar
        ActionBar actionbarNome = getSupportActionBar();
        actionbarNome.setTitle("BACIAS");

        carregarListaBacias();

        itemSelecionado();
    }

    private void alert(String s){
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

    // método botão back action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finish();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

    public void onBackPressed(){ // Botão BACK padrão do android
        startActivity(new Intent(this, MainActivity.class)); //O efeito ao ser pressionado do botão (no caso abre a activity)
        finish(); //Método para matar a activity e não deixa-lá indexada na pilhagem
        return;
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarListaBacias();
    }

    private void carregarListaBacias() {

        listViewBacias = (ListView) findViewById(R.id.listViewBacias);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Bacias");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listBacias.clear();

                for(DataSnapshot objSnapShot:dataSnapshot.getChildren()){

                    String bacia = objSnapShot.getValue().toString();
                    listBacias.add(bacia);

                }

                arrayAdapterBacias = new ArrayAdapter<>(BaciasActivity.this, android.R.layout.simple_list_item_1, listBacias);
                listViewBacias.setAdapter(arrayAdapterBacias);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void itemSelecionado(){

        // pegar item clicado comparar se tem sub-bacias e transmitir o valor com put
        // pra segunda tela carregar as subbacias daquela bacia
        listViewBacias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Object itemLista = listViewBacias.getItemAtPosition(position);
                String path = itemLista.toString();



                if(path.equals("Rio Piranhas")){

                    Intent i = new Intent(BaciasActivity.this, SubBaciasActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Piranhas";
                    String chaveSubBacia = "Sub-Bacias Rio Piranha";
                    params.putString("bacia", bacia);
                    params.putString("subBacia", chaveSubBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Rio Paraíba")){

                    Intent i = new Intent(BaciasActivity.this, SubBaciasActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Paraíba";
                    String chaveSubBacia = "Sub-Bacias Rio Paraíba";
                    params.putString("bacia", bacia);
                    params.putString("subBacia", chaveSubBacia);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Região do Alto Piranhas")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Região do Alto Piranhas";
                    String acude = "Acudes Região do Alto Piranhas";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Região do Medio Piranhas")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Região do Medio Piranhas";
                    String acude = "Acudes Região do Médio Piranhas";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Região do Alto Paraíba")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Região do Alto Paraíba";
                    String acude = "Acudes Região do Alto Paraíba";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Região do Médio Paraíba")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Região do Médio Paraíba";
                    String acude = "Acudes Região do Médio Paraíba";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Rio Jacu")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Jacu";
                    String acude = "Acudes Rio Jacu";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Rio Curimatáu")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Curimatáu";
                    String acude = "Acudes Rio Curimatáu";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Rio Mamanguape")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Mamanguape";
                    String acude = "Acudes Rio Mamanguape";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                } else if (path.equals("Rio Gramame")){

                    Intent i = new Intent(BaciasActivity.this, AcudesActivity.class);

                    Bundle params = new Bundle();
                    String bacia = "Rio Gramame";
                    String acude = "Acudes Rio Gramame";
                    params.putString("bacia", bacia);
                    params.putString("acude", acude);
                    i.putExtras(params);
                    startActivity(i);

                }
            }
        });

    }
}
