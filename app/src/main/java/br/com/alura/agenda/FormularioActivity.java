package br.com.alura.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.modelo.Aluno;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper formularioHelper;
    private Aluno aluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        this.formularioHelper = new FormularioHelper(this);

        Intent intent = getIntent();
        aluno = (Aluno) intent.getSerializableExtra("aluno");
        if(aluno != null ){
            formularioHelper.preencheFormulario(aluno);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Aluno aluno = formularioHelper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);
                if(aluno.getId() == null){
                    dao.insere(aluno);
                } else {
                    dao.altera(aluno);
                }

                dao.close();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
