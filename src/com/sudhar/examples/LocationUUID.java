package com.sudhar.examples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LocationUUID {

    public static void main(String[] args) throws IOException {
        File file = new File(
                "/Users/sudharsan/Downloads/locationuuid.csv");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String st;

        final List<String> chunks = new ArrayList<>();

        while ((st = br.readLine()) != null) {
            chunks.add(st);
        }


        StringBuilder sb = new StringBuilder();

        batches(chunks, 10).forEach(list -> sb.append(list).append("\n"));

        Path fileName = Path.of(
                "/Users/sudharsan/Downloads/locationuuid-10.csv");

        final String s = sb.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll(" ", "");
        Files.writeString(fileName, s);

        System.out.println(s);

        // batches(chunks, 10).forEach(System.out::println);

    }

    public static <T> Stream<List<T>> batches(List<T> source, int length) {
        if (length <= 0)
            throw new IllegalArgumentException("length = " + length);
        int size = source.size();
        if (size <= 0)
            return Stream.empty();
        int fullChunks = (size - 1) / length;
        return IntStream.range(0, fullChunks + 1).mapToObj(
                n -> source.subList(n * length, n == fullChunks ? size : (n + 1) * length));
    }

}
