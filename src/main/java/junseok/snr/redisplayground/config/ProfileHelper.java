package junseok.snr.redisplayground.config;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfileHelper {
    private final Environment environment;

    public String[] getActiveProfiles() {
        return environment.getActiveProfiles();
    }
}
