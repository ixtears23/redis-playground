package junseok.snr.redisplayground.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.core.env.Environment;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class ProfileAwareKeyGenerator implements KeyGenerator {

    private final Environment environment;
    @Override
    public Object generate(Object target, Method method, Object... params) {
        return String.join(",", environment.getActiveProfiles());
    }
}
