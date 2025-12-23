package com.example.demo.controller;

import com.example.demo.entity.Host;
import com.example.demo.service.HostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hosts")
@Tag(name = "Hosts", description = "Host management APIs")
public class HostController {

    private final HostService hostService;

    public HostController(HostService hostService) {
        this.hostService = hostService;
    }

    @PostMapping
    public Host createHost(@RequestBody Host host) {
        return hostService.createHost(host);
    }

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @GetMapping("/{id}")
    public Host getHost(@PathVariable Long id) {
        return hostService.getHost(id);
    }
}
