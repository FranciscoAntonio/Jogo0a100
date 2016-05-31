package renato.com.br.jogo0a100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Main4Activity extends AppCompatActivity {

    TextView txt5;
    String nome;
    Integer pontuacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        txt5= (TextView)findViewById(R.id.textView5);

        SharedPreferences prefs= getSharedPreferences("configuracoes", Context.MODE_PRIVATE);
        nome="";
        int cont=0;

        Map <String ,?> allEntries = prefs.getAll();
        for  ( Map.Entry <String,?> entrada:allEntries.entrySet())  {
            nome+=entrada.getKey()+": "+entrada.getValue() + "  ";
            nome+="\n";

        }

        // nome=prefs.getString("nome","NÃO ENCONTRADO");
       // pontuacao=prefs.getInt("pontuacao", 0);

        txt5.setText(nome);

    }
}
