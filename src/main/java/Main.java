import repository.MonitoredDataRepository;
import service.MonitoredDataService;

public class Main {
    public static void main(String[] args) {
        MonitoredDataRepository monitoredDataRepository = new MonitoredDataRepository();
        MonitoredDataService monitoredDataService = new MonitoredDataService();

        System.out.println(monitoredDataService.countNumberOfDays());
        System.out.println(monitoredDataService.countNumberOfActivities());
        System.out.println(monitoredDataService.labelDuration().toString());


    }
}
