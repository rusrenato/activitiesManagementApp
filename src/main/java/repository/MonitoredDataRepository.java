package repository;

import model.MonitoredData;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MonitoredDataRepository {

    public List<MonitoredData> parseInput(String filename) {
        List<MonitoredData> monitoredDataList = new ArrayList<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {

            stream.forEach(s -> {
                String[] pair = s.split("[\t]+");
                monitoredDataList.add(new MonitoredData(LocalDateTime.parse(pair[0], format), LocalDateTime.parse(pair[1], format),pair[2]));

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return monitoredDataList;
    }
}
