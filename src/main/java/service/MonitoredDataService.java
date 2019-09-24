package service;

import model.MonitoredData;
import repository.MonitoredDataRepository;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MonitoredDataService {

    private MonitoredDataRepository monitoredDataRepository = new MonitoredDataRepository();
    private List<MonitoredData> monitoredDataList = monitoredDataRepository.parseInput("E:/Git/activitiesManagementApp/src/main/resources/activities.txt");


    //Count how many days of monitored data appears in the log.
    public int countNumberOfDays() {
        return (int) monitoredDataList.stream()
                .map(x -> x.getStartTime().getDayOfYear())
                .distinct()
                .count();
    }

    //Count how many times has appeared each activity over the entire monitoring period.
    //Return a map of type <String, Int> representing the mapping of activities to their count

    public Map<String, Long> countNumberOfActivities() {
        return monitoredDataList.stream()
                .map(MonitoredData::getActivity)
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));
    }

    //Count how many times has appeared each activity for each day over the monitoring period
    public Map<LocalDateTime, Map<String, Integer>> countEachActivityPerDay() {
        List<Object> lists =  monitoredDataList.stream().collect(Collectors.groupingBy(p -> p.getStartTime().getDayOfMonth())).values().stream().collect(Collectors.toList());
        System.out.println(lists);

        return null;
    }

    //For each line from the file map for the activity label the duration recorded on that line
    //(end_time-start_time)
    public Map<MonitoredData,Long> labelDuration() {
        return monitoredDataList.stream()
                .collect(Collectors.toMap(Function.identity(), x -> Duration.between(x.getStartTime(), x.getEndTime()).toMinutes()));
    }

    //For each activity compute the entire duration over the monitoring period
    public Map<String, Long> computeEntireDurationForAnActivity() {
        return labelDuration().values().stream().collect(Collectors.toMap(MonitoredData::getActivity,))
    }

}
