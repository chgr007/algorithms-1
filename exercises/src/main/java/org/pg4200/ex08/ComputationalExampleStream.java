package org.pg4200.ex08;

import org.pg4200.ex06.Book;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ComputationalExampleStream implements ComputationExample {
    @Override
    public List<String> compute(List<Book> books) {
        Objects.requireNonNull(books);
        return books.stream()
                .filter(b -> b.getYear() >= 2010 && b.getYear() <= 2015)
                .filter(b -> b.getAuthors().size() >= 2)
                .flatMap(b -> b.getAuthors().stream())
                .filter(a -> a.getName() != null && a.getSurname() != null)
                .distinct()
                .map(a -> a.getName() + " " + a.getSurname())
                .collect(Collectors.toList());
    }
}
