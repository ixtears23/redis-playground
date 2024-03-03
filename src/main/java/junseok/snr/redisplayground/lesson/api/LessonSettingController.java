package junseok.snr.redisplayground.lesson.api;

import junseok.snr.redisplayground.lesson.application.LessonSettingService;
import junseok.snr.redisplayground.lesson.domain.LessonSetting;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/lesson")
public class LessonSettingController {
    private final LessonSettingService lessonSettingService;
    @GetMapping("/{id}")
    public ResponseEntity<LessonSetting> getLessonSettingById(@PathVariable Integer id) {
        return lessonSettingService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LessonSetting> createLessonSetting(@RequestBody LessonSetting lessonSetting) {
        LessonSetting savedLessonSetting = lessonSettingService.create(lessonSetting);
        return ResponseEntity.ok(savedLessonSetting);
    }

    @PutMapping
    public ResponseEntity<LessonSetting> updateLessonSetting(@RequestBody LessonSetting lessonSetting) {
        LessonSetting savedLessonSetting = lessonSettingService.update(lessonSetting);
        return ResponseEntity.ok(savedLessonSetting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLessonSetting(@PathVariable Integer id) {
        lessonSettingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
