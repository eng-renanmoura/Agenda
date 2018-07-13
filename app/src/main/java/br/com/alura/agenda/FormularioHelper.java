package br.com.alura.agenda;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;

import br.com.alura.agenda.modelo.Aluno;

public class FormularioHelper {
    private EditText nome;
    private EditText endereco;
    private EditText telefone;
    private EditText site;
    private RatingBar nota;
    private ImageView foto;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {
        this.aluno = new Aluno();
        this.nome = (EditText) activity.findViewById(R.id.formulario_nome);
        this.endereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        this.telefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        this.site = (EditText) activity.findViewById(R.id.formulario_site);
        this.nota = (RatingBar) activity.findViewById(R.id.formulario_nota);
        this.foto = (ImageView) activity.findViewById(R.id.foto_aluno_form);
    }

    public Aluno pegaAluno(){
        aluno.setNome(this.nome.getText().toString());
        aluno.setEndereco(this.endereco.getText().toString());
        aluno.setTelefone(this.telefone.getText().toString());
        aluno.setSite(this.site.getText().toString());
        aluno.setNota(Double.valueOf(this.nota.getProgress()));
        aluno.setCaminhoFoto((String) this.foto.getTag());
        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        this.aluno = aluno;

        this.nome.setText(aluno.getNome());
        this.endereco.setText(aluno.getEndereco());
        this.telefone.setText(aluno.getTelefone());
        this.site.setText(aluno.getSite());
        this.nota.setProgress(aluno.getNota().intValue());
        carregaFoto(aluno.getCaminhoFoto());
    }

    public void carregaFoto(String caminhoFoto){
        if(caminhoFoto != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(caminhoFoto);
            Bitmap bm = Bitmap.createScaledBitmap(bitmap, 100, 100, true);
            foto.setImageBitmap(bm);
            foto.setScaleType(ImageView.ScaleType.FIT_XY);
            foto.setTag(caminhoFoto);
        }
    }
}
