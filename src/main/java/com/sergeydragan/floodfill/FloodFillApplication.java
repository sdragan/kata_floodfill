package com.sergeydragan.floodfill;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FloodFillApplication {

    public static void main(String[] args) {
        List<List<String>> field = new ArrayList<>();
        field.add(new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0")));
        field.add(new ArrayList<>(Arrays.asList("1", "1", "0", "0", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "1", "0", "1", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "1", "1", "1", "0")));
        field.add(new ArrayList<>(Arrays.asList("0", "0", "0", "0", "0")));

        final FloodFiller floodFiller = new SimpleFloodFiller();
        final Point startingPoint = new Point(0, 0);
        floodFiller.fillField(field, startingPoint);
    }
}


