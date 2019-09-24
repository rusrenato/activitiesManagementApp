import model.MonitoredData;

import repository.MonitoredDataRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    private MonitoredDataRepository monitoredDataRepository = new MonitoredDataRepository();
    private List<MonitoredData> monitoredDataList = monitoredDataRepository.parseInput("E:/Git/activitiesManagementApp/src/main/resources/activities.txt");

    @org.junit.Test
    public void test() {
        monitoredDataList.stream()
                .map(x -> x.getStartTime().getDayOfMonth())
                .distinct()
                .forEach(System.out::println);


    }

    @org.junit.Test
    public void test2() {
        List<Object> lists =  monitoredDataList.stream().collect(Collectors.groupingBy(p -> p.getStartTime().getDayOfMonth())).values().stream().collect(Collectors.toList());
        System.out.println(lists);

        ;
    }
}
