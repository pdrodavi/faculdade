package rokobasi.com.br.acquali;

import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Conexao {

    private static FirebaseAuth firebaseAuth;
    private static FirebaseAuth.AuthStateListener authStateListener;
    private static FirebaseUser firebaseUser;

    private Conexao() {
    }

    // método de autenticação
    public static FirebaseAuth getFirebaseAuth(){
        if(firebaseAuth == null){
            inicializaFirebase();
        }
        return firebaseAuth;
    }

    // incializar firebase
    private static void inicializaFirebase() {
        firebaseAuth = FirebaseAuth.getInstance();
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    firebaseUser = user;
                }
            }
        };
        firebaseAuth.addAuthStateListener(authStateListener);
    }

    // pegar usuário
    public static FirebaseUser getFirebaseUser(){
        return firebaseUser;
    }

    // deslogar usuário
    private static void logout(){
        firebaseAuth.signOut();
    }

}
