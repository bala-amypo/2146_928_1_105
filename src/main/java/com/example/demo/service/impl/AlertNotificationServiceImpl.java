@Service
public class AlertNotificationServiceImpl implements AlertNotificationService {

    private AlertNotificationRepository alertRepository;
    private VisitLogRepository visitLogRepository;

    // 🔥 REQUIRED BY TESTS
    public AlertNotificationServiceImpl() {}

    public AlertNotificationServiceImpl(
            AlertNotificationRepository alertRepository,
            VisitLogRepository visitLogRepository
    ) {
        this.alertRepository = alertRepository;
        this.visitLogRepository = visitLogRepository;
    }
}
