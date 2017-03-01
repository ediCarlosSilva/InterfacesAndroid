package br.com.k19.interfaces;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Edi Carlos on 01/03/2017.
 */

public class MovieAdapter extends ArrayAdapter<Movie> {

    private int resource;

    public MovieAdapter(Context context, int resource, List<Movie> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if ( row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext()
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            row = inflater.inflate(this.resource, parent, false);
        }

        Movie movie = getItem(position);

        TextView name = (TextView) row.findViewById(R.id.name);
        name.setText(movie.getName());

        TextView year = (TextView) row.findViewById(R.id.year);
        year.setText("Year: " + movie.getYear());

        TextView rating = (TextView) row.findViewById(R.id.rating);
        rating.setText(String.valueOf(movie.getRating()));

        return row;
    }
}
