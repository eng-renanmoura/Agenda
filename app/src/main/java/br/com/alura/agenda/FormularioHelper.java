package br.com.alura.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.com.alura.agenda.modelo.Aluno;

public class FormularioHelper {
    private EditText nome;
    private EditText endereco;
    private EditText telefone;
    private EditText site;
    private RatingBar nota;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        this.aluno = new Aluno();
        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.site = (EditText) activity.findViewById(R.id.formulario_site);
        this.nota = (RatingBar) activity.findViewById(R.id.formulario_nota);
    }

    public Aluno pegaAluno(){
        aluno.setNome(this.nome.getText().toString());
        aluno.setEndereco(this.endereco.getText().toString());
        aluno.setTelefone(this.telefone.getText().toString());
        aluno.setSite(this.site.getText().toString());
        aluno.setNota(Double.valueOf(this.nota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno = aluno;

        this.nome.setText(aluno.getNome());
        this.endereco.setText(aluno.getEndereco());
        this.telefone.setText(aluno.getTelefone());
        this.site.setText(aluno.getSite());
        this.nota.setProgress(aluno.getNota().intValue());
    }
}
