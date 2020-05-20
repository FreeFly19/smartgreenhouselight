package com.github.freefly19.smartgreenhouselight;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class LightSwitch {
    @Id
    private Long id;
    private boolean enabled;
}
