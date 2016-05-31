package renato.com.br.jogo0a100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    EditText editText;
    Button button;
    TextView textView;
    String nome;
    Integer numero_aleatorio,numero_inicio=0,numero_final=100,numero_jogada, contador=101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editText=(EditText)findViewById(R.id.editText2);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView2);


        numero_aleatorio= (int) (Math.random()*100);

        textView.setText(String.format("Digite um Número Entre %d e %d",numero_inicio,numero_final));

        //Toast.makeText(this,"nome "+nome+"numero "+numero_aleatorio,Toast.LENGTH_SHORT).show();
    }


    public void jogar(View view){
        contador--;
        numero_jogada=Integer.parseInt(editText.getText().toString());
        Toast.makeText(this,""+numero_aleatorio,Toast.LENGTH_SHORT).show();
        //textView.setText(String.format("Você Ganhou o Jogo\n Pontuação: %d", numero_jogada));
        if(numero_aleatorio == numero_jogada) {
            Intent intent = getIntent();
            Intent it= new Intent(this,Main3Activity.class);

            nome = intent.getStringExtra("nome");
            //textView.setText(String.format(nome + "\nVocê Ganhou o Jogo\nPontuação: %d", contador));
            SharedPreferences prefs = getSharedPreferences("configuracoes", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putInt(nome,contador);
            editor.commit();
            startActivity(it);
        }
        else {
            if(numero_jogada<numero_aleatorio){
                numero_inicio=numero_jogada;
                textView.setText(String.format("Digite um numero entre %d e %d\nPontuação: %d",numero_inicio,numero_final,contador));
            }else{
                numero_final=numero_jogada;
                textView.setText(String.format("Digite um numero entre %d e %d\nPontuação: %d",numero_inicio,numero_final,contador));
            }
        }
    }
}
