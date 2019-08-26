import repository.MonitoredDataRepository;

public class Main {
    public static void main(String[] args) {
        MonitoredDataRepository monitoredDataRepository = new MonitoredDataRepository();

        System.out.println(monitoredDataRepository.parseInput("E:/Git/activitiesManagementApp/src/main/resources/activities.txt"));
    }
}
