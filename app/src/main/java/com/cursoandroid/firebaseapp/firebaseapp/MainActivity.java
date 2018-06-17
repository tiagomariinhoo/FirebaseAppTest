package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //Volta na raiz do projeto, já pode criar os nodes
    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    //Faz referencia na raiz do projeto, cria nodes a partir dela

    private DatabaseReference usuarioReferencia = databaseReferencia.child("usuarios");
    private DatabaseReference produtoReferencia = databaseReferencia.child("produtos");
    //Referencia o node "usuarios" que será criado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*      SALVAR E ATUALIZAR DADOS
        Usuario usuario = new Usuario();
        usuario.setNome("Tiago");
        usuario.setSobrenome("Marinho");
        usuario.setIdade(21);
        usuario.setSexo("Masculino");

  //      usuarioReferencia.child("003").setValue( usuario ); //Codigo utilizado
        //No PreDi poderia usar o child como email e depois criar os atributos

        Produto produto = new Produto();
        produto.setDescricao("Notebook WP40");
        produto.setCor("Branco");
        produto.setFabricante("HP");
        //Se mudar algo ele sobreesecreve
        produtoReferencia.child("001").setValue(produto);
*/

        //LISTAR DADOS

        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
                //Desse jeito verifica a referencia inteira do produtos, mas, se botar
                // databaseReferencia.child("produtos").child("001"), vai ser só para o 001
                //Sempre que eu mudar no database ele vai avisar no log, notifica
                // Não precisa fazer com que o app fique verificando os dados
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); //Adiciona o listener

    }
}
