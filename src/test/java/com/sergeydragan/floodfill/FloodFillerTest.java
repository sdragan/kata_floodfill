package com.sergeydragan.floodfill;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFillerTest {

    @Test
    public void testFloodFill() {
        FloodFiller floodFiller = getSimpleFloodFiller();
        List<List<String>> field = getField();
        Point startingPoint = new Point(0, 0);
        List<List<String>> result = floodFiller.fillField(field, startingPoint);
        Assertions.assertEquals(result, getExpectedResult());
    }

    @Test
    public void testBadCoords() {
        FloodFiller floodFiller = getSimpleFloodFiller();
        List<List<String>> field = getField();

        Point startingPoint = new Point(-5, 0);
        List<List<String>> result = floodFiller.fillField(field, startingPoint);
        Assertions.assertEquals(result, getField());

        startingPoint = new Point(25, 2);
        result = floodFiller.fillField(field, startingPoint);
        Assertions.assertEquals(result, getField());
    }

    private List<List<String>> getField() {
        List<List<String>> field = new ArrayList<>();
        field.add(new ArrayList<>(Arrays.asList("0", "0", "0", "0")));
        field.add(new ArrayList<>(Arrays.asList("1", "1", "0", "0", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "1", "0", "1", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "1", "1", "1", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0")));
        return field;
    }

    private List<List<String>> getExpectedResult() {
        List<List<String>> field = new ArrayList<>();
        field.add(new ArrayList<>(Arrays.asList("*", "*", "*", "*")));
        field.add(new ArrayList<>(Arrays.asList("1", "1", "*", "*", "*")));
        field.add(new ArrayList<>(Arrays.asList("*", "1", "*", "1", "*")));
        field.add(new ArrayList<>(Arrays.asList("*", "1", "1", "1", "*")));
        field.add(new ArrayList<>(Arrays.asList("*", "*", "*", "*", "*")));
        return field;
    }

    private FloodFiller getSimpleFloodFiller() {
        return new SimpleFloodFiller();
    }

}
