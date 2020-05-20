package com.github.freefly19.smartgreenhouselight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface LightSwitchRepository extends JpaRepository<LightSwitch, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE LightSwitch ls SET ls.enabled = :enabled")
    int updateEnabledState(@Param("enabled") boolean enabled);
}
