@RestController
@RequestMapping("/api/visits")
@Tag(name = "Visit Logs", description = "Check-in & check-out APIs")
public class VisitLogController {

    private final VisitLogService visitLogService;

    public VisitLogController(VisitLogService visitLogService) {
        this.visitLogService = visitLogService;
    }

    @PostMapping("/checkin/{visitorId}/{hostId}")
    public VisitLog checkIn(@PathVariable Long visitorId,
                            @PathVariable Long hostId,
                            @RequestBody String purpose) {
        return visitLogService.checkInVisitor(visitorId, hostId, purpose);
    }

    @PostMapping("/checkout/{id}")
    public VisitLog checkOut(@PathVariable Long id) {
        return visitLogService.checkOutVisitor(id);
    }
}
