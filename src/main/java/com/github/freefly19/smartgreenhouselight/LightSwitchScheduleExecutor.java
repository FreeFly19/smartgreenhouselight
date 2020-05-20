package com.github.freefly19.smartgreenhouselight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.time.ZoneId;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@Component
public class LightSwitchScheduleExecutor {
    private final LightSwitchRepository lightSwitchRepository;

    @PostConstruct
    public void init() {
        updateLightSwitchesEnabledState();
        var executorService = Executors.newScheduledThreadPool(1);
        executorService.scheduleWithFixedDelay(this::updateLightSwitchesEnabledState, 1, 1, TimeUnit.SECONDS);
    }

    private void updateLightSwitchesEnabledState() {
        if (Instant.now().atZone(ZoneId.of("Europe/Kiev")).getHour() < 8) {
            lightSwitchRepository.updateEnabledState(false);
        } else {
            lightSwitchRepository.updateEnabledState(true);
        }
    }
}
