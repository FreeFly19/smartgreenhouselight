package com.github.freefly19.smartgreenhouselight;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LightSwitchController {
    private final LightSwitchRepository lightSwitchRepository;

    @GetMapping("/api/light-switches")
    public List<LightSwitch> getAll() {
        return lightSwitchRepository.findAll();
    }

    @GetMapping("/api/light-switches/{id}/enabled")
    public boolean getStatus(@PathVariable("id") long id) {
        return lightSwitchRepository.getOne(id).isEnabled();
    }

    @PutMapping("/api/light-switches/{id}/enabled")
    public void updateStatus(@PathVariable("id") long id, @RequestBody boolean state) {
        LightSwitch lightSwitch = lightSwitchRepository.getOne(id);
        lightSwitch.setEnabled(state);
        lightSwitchRepository.save(lightSwitch);
    }
}
