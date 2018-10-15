package cz.i.test;

import org.junit.Test;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class JavaTest {

    @Test
    public void localVariableTest() {
        var number = 158;
        var list = new ArrayList<>(asList("First item", "Second item", "Third item"));
        var stream = list.stream();
        var item = stream.findAny();

        System.out.println("cislo: " + number);
        System.out.println("polozka z kolekce: " + item.orElse("Kolekce je prazdna"));

    }
}
