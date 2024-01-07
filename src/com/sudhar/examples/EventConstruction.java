package com.sudhar.examples;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EventConstruction {

    public static void main(final String[] args) throws IOException {
//        String kafkaMsg = "{\"event\":{\"id\":\"348126ac-cfe6-4715-bb20-7661654b5792\",\"traceId\":\"409c27cf-db70-4b89-89cd-855bc8b03e30\",\"type\":\"com.tesco.range.change.event.1.0.0\",\"timestamp\":\"2022-08-12T16:25:25Z\",\"clientId\":\"11bcce19-a6cb-4bf1-8133-04939ad9f75f\"},\"rangeDetails\":{\"source\":\"Allocations\",\"product\":\"091174248\",\"store\":%s,\"startDate\":\"2022-08-18\",\"endDate\":\"2022-08-18\",\"country\":\"GB\",\"startReasonCode\":\"L\",\"endReasonCode\":\"M\"}}";
//
//        int count = 0;
//        try(BufferedReader br = new BufferedReader(new FileReader("/Users/sudharsan/projects/ds/src/com/sudhar/examples/stores.txt"))) {
//            StringBuilder sb = new StringBuilder();
//            String line = br.readLine();
//
//            String[] stores = line.split(",");
//
//            for (String store: stores) {
//                System.out.printf(kafkaMsg, store);
//                count++;
//                System.out.println();
//            }
//
//            //System.out.println(line);
//            assert count == 150;
//
//            while (line != null) {
//                sb.append(line);
//                sb.append(System.lineSeparator());
//                line = br.readLine();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        constructInsertQueries();

    }


    private static void constructInsertQueries() throws FileNotFoundException {
        //'050967012', '051028529', '090003471', '090004493', '090006630', '050321419', '050385654')
        // UPDATE PROD_IN_MERCH_GRP set PSG_START_DATE = '2021-01-01 00:00:00.000' where ranging_prod_no in (%s) and PSG_START_DATE>'2021-01-01'

        int count = 0;
        final String sql = "UPDATE PROD_IN_MERCH_GRP set PSG_START_DATE = '2021-01-01 00:00:00.000' where ranging_prod_no in (%s) and PSG_START_DATE>'2021-01-01';";
        final BufferedReader br = new BufferedReader(new FileReader("/Users/sudharsan/projects/ds/src/com/sudhar/examples/BBPDATA.txt"));
        StringBuilder sb = new StringBuilder();
        final String product = "'0%s'";
        String line = null;
        final List<String> productList = new ArrayList<>();
        try {
            line = br.readLine();

            while (line != null) {
                count++;
                String[] data = line.split(" ");
                productList.add(String.format(product, data[1]));
                line = br.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        count++;
        try (FileWriter fileWriter = new FileWriter("/Users/sudharsan/projects/ds/src/com/sudhar/examples/crdb.sql")) {
            for (int i = 0; i < count; i += 1000) {
                List<String> products = null;
                if (i + 999 > count) {
                    products = productList.subList(i, i + (count - i - 1));
                } else {
                    products = productList.subList(i, i + 999);
                }

                String fullSQL = String.format(sql, String.join(",", products));
                System.out.println(fullSQL);

                fileWriter.write(fullSQL + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Line count : " + count);
    }
}
