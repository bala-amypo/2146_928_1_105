@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts", description = "Host management APIs")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public Host create(@RequestBody Host host) {
        return hostService.createHost(host);
    }

    @GetMapping
    public List<Host> getAll() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host get(@PathVariable Long id) {
        return hostService.getHost(id);
    }
}
