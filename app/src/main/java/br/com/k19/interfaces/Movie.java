package br.com.k19.interfaces;

import java.util.Random;

/**
 * Created by Edi Carlos on 01/03/2017.
 */

public class Movie {

    private String name;
    private int rating;
    private int year;

    private static String[] names = new String[] {
        "Back to the Future", "Star Wars", "Lord of the Rings",
        "the Hitchhiker's Guide to the Galaxy", "Tron", "Blade Runner",
        "Harry Potter and the Sorcerer's Stone", "Raiders of the Lost Ark"};

    public static Movie newInstance() {
        Random random = new Random();

        Movie movie = new Movie();
        movie.setName(names[random.nextInt(names.length)]);
        movie.setRating(random.nextInt(5) + 1);
        movie.setYear(1980 + random.nextInt(35));

        return movie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
