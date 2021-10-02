package org.pg4200.ex06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ImmutableBookImp implements ImmutableBook{
    private final String title;

    private final int year;

    private final List<ImmutableAuthor> authors;

    public ImmutableBookImp() {
        title = null;
        year = 0;
        authors = new ArrayList<>();
    }

    public ImmutableBookImp(String title, int year, List<ImmutableAuthor> authors) {
        this.title = title;
        this.year = year;
        this.authors = Collections.unmodifiableList(authors);
    }

    @Override
    public ImmutableBook withTitle(String title) {
        return new ImmutableBookImp(title, this.year, authors);
    }

    @Override
    public ImmutableBook withYear(int year) {
        return new ImmutableBookImp(this.title, year, authors);
    }

    @Override
    public ImmutableBook withAuthors(List<ImmutableAuthor> authors) {
        return new ImmutableBookImp(this.title, this.year, this.authors);
    }

    @Override
    public ImmutableBook withAuthors(ImmutableAuthor... authors) {
        return new ImmutableBookImp(this.title, this.year, new ArrayList<ImmutableAuthor>(List.of(authors)));
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public int getYear() {
        return this.year;
    }

    @Override
    public List<ImmutableAuthor> getAuthors() {
        return new ArrayList<ImmutableAuthor>(this.authors);
    }
}
