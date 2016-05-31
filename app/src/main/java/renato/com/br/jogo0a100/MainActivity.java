package renato.com.br.jogo0a100;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText= (EditText)findViewById(R.id.editTexto);
        button= (Button)findViewById(R.id.button);
        SharedPreferences prefs = getSharedPreferences("configuracoes", Context.MODE_PRIVATE);

    }

    public void IniciarJogo(View view){

        String nome= editText.getText().toString();
        Intent intent=new Intent(this,Main2Activity.class);
        intent.putExtra("nome",nome);

        startActivity(intent);

    }

    public void Ranking(View view){
        Intent intent=new Intent(this,Main4Activity.class);
        startActivity(intent);
    }
}
