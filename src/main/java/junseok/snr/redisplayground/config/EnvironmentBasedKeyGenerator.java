package junseok.snr.redisplayground.config;

import junseok.snr.redisplayground.lesson.domain.LessonSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.core.env.Environment;

import java.lang.reflect.Method;

@RequiredArgsConstructor
public class EnvironmentBasedKeyGenerator implements KeyGenerator {

    private final Environment environment;
    @Override
    public Object generate(Object target, Method method, Object... params) {
        String seqLessonSetting = "";
        if (params.length > 0 && params[0] instanceof LessonSetting) {
            LessonSetting lessonSetting = (LessonSetting) params[0];
            seqLessonSetting = String.valueOf(lessonSetting.getSeqLessonSetting());
        }

        // 활성 프로필 정보를 캐시 키에 포함
        String profiles = String.join(",", environment.getActiveProfiles());

        // 요구된 포맷에 맞춰 캐시 키 생성
        String key = "lessonSetting:" + seqLessonSetting + ":" + profiles;
        return key;
    }
}
