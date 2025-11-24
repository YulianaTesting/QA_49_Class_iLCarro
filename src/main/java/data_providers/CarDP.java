package data_providers;

import dto.Car;
import org.testng.annotations.DataProvider;
import utils.PropertiesReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CarDP {
    @DataProvider
    public Iterator<Car> dataProviderCarFile() {

        List<Car> list = new ArrayList<>();
        String fileName = PropertiesReader.getProperty("base.properties", "file_car_csv");

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("src/test/resources/data_csv/" + fileName)
        )) {
            String line = bufferedReader.readLine();

            while (line != null) {

                String[] a = line.split(",");

                list.add(Car.builder()
                        .location(a[0])
                        .manufacture(a[1])
                        .model(a[2])
                        .year(Integer.parseInt(a[3]))
                        .fuel(a[4])
                        .seats(Integer.parseInt(a[5]))
                        .carClass(a[6])
                        .registrationNumber(a[7])
                        .price(a[8])
                        .about(a[9])
                        .build());

                line = bufferedReader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException("IO exception", e);
        }

        return list.iterator();
    }

}
