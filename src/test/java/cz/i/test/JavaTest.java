package cz.i.test;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void tryWithResourcesTest() throws FileNotFoundException  {
        // effectively final var
        PrintStream out = new PrintStream(new FileOutputStream("test.out"));

        // some code ...

        // try with resources closes the output stream
        try (out) {
            out.println(158);
        }
    }

    @Test
    public void anonymouseClassDiamondTest() {

        List<String> fakeList = new ArrayList<>(){
            @Override
            public int size() {
                // always empty
                return 0;
            }
        };

    }
}
