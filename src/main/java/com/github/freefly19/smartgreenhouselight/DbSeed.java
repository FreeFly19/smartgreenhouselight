package com.github.freefly19.smartgreenhouselight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class DbSeed {
    private final LightSwitchRepository lightSwitchRepository;

    @PostConstruct
    public void init() {
        var ls = new LightSwitch();
        ls.setId(1L);
        lightSwitchRepository.save(ls);
    }
}
