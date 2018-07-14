package br.com.alura.agenda;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.util.List;

import br.com.alura.agenda.converter.AlunoConverter;
import br.com.alura.agenda.dao.AlunoDAO;
import br.com.alura.agenda.modelo.Aluno;

public class EnviarDadosServidor extends AsyncTask<Void, Void, String> {

    private Context context;
    ProgressDialog progressDialog;

    public EnviarDadosServidor (Context context){
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = ProgressDialog.show(context, "Aguarde", "Enviando para o servidor...", true, true);
        progressDialog.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        AlunoDAO dao = new AlunoDAO(context);
        List<Aluno> alunos = dao.buscaAlunos();
        dao.close();

        AlunoConverter converter = new AlunoConverter();
        String json = converter.toJson(alunos);
        WebClient client = new WebClient();
        String resposta = client.post(json);

        return resposta;
    }

    @Override
    protected void onPostExecute(String s) {
        progressDialog.dismiss();
        Toast.makeText(context, s, Toast.LENGTH_LONG).show();
    }
}
