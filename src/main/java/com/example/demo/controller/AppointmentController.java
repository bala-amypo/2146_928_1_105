@RestController
@RequestMapping("/api/appointments")
@Tag(name = "Appointments", description = "Appointment scheduling APIs")
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/{visitorId}/{hostId}")
    public Appointment create(@PathVariable Long visitorId,
                              @PathVariable Long hostId,
                              @RequestBody Appointment appointment) {
        return appointmentService.createAppointment(visitorId, hostId, appointment);
    }

    @GetMapping("/{id}")
    public Appointment get(@PathVariable Long id) {
        return appointmentService.getAppointment(id);
    }
}
