package br.com.k19.interfaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

import static br.com.k19.interfaces.R.id.nome;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initSpinner();
        initButton();
        initListView();
        initAdvancedListView();
        initGridView();
        initAdvancedGridView();
    }

    private void initSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.cidades);

        if ( spinner == null) {
            return;
        }

        ArrayList<String> cidades = new ArrayList<>();
        cidades.add("São Paulo");
        cidades.add("Mogi das Cruzes");
        cidades.add("Campinas");
        cidades.add("Pindamonhangaba");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, cidades);

        spinner.setAdapter(adapter);
    }

    private void initButton() {
        final EditText nome = (EditText) findViewById(R.id.nome);
        final EditText email = (EditText) findViewById(R.id.email);
        final Spinner cidades = (Spinner) findViewById(R.id.cidades);
        final CheckBox noticias = (CheckBox) findViewById(R.id.noticias);
        final RadioGroup sexo = (RadioGroup) findViewById(R.id.sexo);

        Button button = (Button) findViewById(R.id.cadastrar);

        if(button == null) {
            return;
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder builder = new StringBuilder();
                builder.append("Nome: " + nome.getEditableText().toString() + "\n");
                builder.append("Email: " + email.getEditableText().toString() + "\n");
                builder.append("Cidade: " + cidades.getSelectedItem() + "\n");
                builder.append("Receber notícia? " + noticias.isChecked() + "\n");

                RadioButton sexoSelecionado =
                        (RadioButton) findViewById(sexo.getCheckedRadioButtonId());

                builder.append("Sexo: " + sexoSelecionado.getText());

                Toast toast = Toast.makeText(MainActivity.this,
                        builder.toString(), Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }

    private ArrayList<String> createItemList() {
        ArrayList<String> list = new ArrayList<String>();

        for (int i = 1; i <= 60; i++) {
            list.add("Item " + i);
        }
        return list;
    }

    private void initListView() {
        ListView listView = (ListView) findViewById(R.id.list_view);

        if (listView == null) {
            return;
        }

        ArrayList<String> list = createItemList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);
    }

    private ArrayList<Movie> createMoviesList() {
        ArrayList<Movie> list = new ArrayList<Movie>();

        for (int i = 1; i <= 60; i++) {
            list.add(Movie.newInstance());
        }

        return list;
    }

    private void initAdvancedListView() {
        ListView listView = (ListView) findViewById(R.id.advanced_list_view);

        if (listView == null) {
            return;
        }

        ArrayList<Movie> list = createMoviesList();

        MovieAdapter adapter = new MovieAdapter(this, R.layout.list_view_item, list);
        listView.setAdapter(adapter);
    }

    private void initGridView() {
        GridView gridView = (GridView) findViewById(R.id.grid_view);

        if (gridView == null) {
            return;
        }

        ArrayList<String> list = createItemList();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, list);
        gridView.setAdapter(adapter);
    }

    private void initAdvancedGridView() {
        GridView gridView = (GridView) findViewById(R.id.advanced_grid_view);

        if (gridView == null) {
            return;
        }

        ArrayList<Movie> list = createMoviesList();

        MovieAdapter adapter = new MovieAdapter(this,
                R.layout.grid_view_item, list);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Movie movie = (Movie) parent.getAdapter().getItem(position);

                Toast toast = Toast.makeText(MainActivity.this, movie.getName(),
                        Toast.LENGTH_LONG);

                toast.show();
            }
        });
    }
}
