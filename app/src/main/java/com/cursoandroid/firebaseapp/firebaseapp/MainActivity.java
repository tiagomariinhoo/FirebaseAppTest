package com.cursoandroid.firebaseapp.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
/*
        Usuario usuario = new Usuario();
        usuario.setNome("Tiago");
        usuario.setSobrenome("Marinho");
        usuario.setIdade(21);
        usuario.setSexo("Masculino");
*/
  //      usuarioReferencia.child("003").setValue( usuario ); //Codigo utilizado
        //No PreDi poderia usar o child como email e depois criar os atributos

        Produto produto = new Produto();
        produto.setDescricao("Notebook WP40");
        produto.setCor("Branco");
        produto.setFabricante("HP");
        //Se mudar algo ele sobreesecreve
        produtoReferencia.child("001").setValue(produto);

    }
}
