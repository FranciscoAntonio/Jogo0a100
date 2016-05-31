package renato.com.br.jogo0a100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    String nome;
    Integer pontuacao;
    TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        SharedPreferences prefs= getSharedPreferences("configuracoes", Context.MODE_PRIVATE);

        nome=prefs.getString("nome","NÃO ENCONTRADO");
        pontuacao=prefs.getInt("pontuacao", 0);

        text3=(TextView)findViewById(R.id.textView3);

        text3.setText("Nome: "+nome+"\nPontuação: "+pontuacao);

    }

    public void ok(View view){
        Intent intent= new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
