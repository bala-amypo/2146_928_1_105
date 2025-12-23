@RestController
@RequestMapping("/api/alerts")
@Tag(name = "Alerts", description = "Alert notification APIs")
public class AlertNotificationController {

    private final AlertNotificationService alertService;

    public AlertNotificationController(AlertNotificationService alertService) {
        this.alertService = alertService;
    }

    @PostMapping("/send/{visitLogId}")
    public AlertNotification send(@PathVariable Long visitLogId) {
        return alertService.sendAlert(visitLogId);
    }

    @GetMapping
    public List<AlertNotification> getAll() {
        return alertService.getAllAlerts();
    }
}
