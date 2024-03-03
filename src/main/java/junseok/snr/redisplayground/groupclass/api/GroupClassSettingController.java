package junseok.snr.redisplayground.groupclass.api;

import junseok.snr.redisplayground.groupclass.application.dto.GroupClassSettingDto;
import junseok.snr.redisplayground.groupclass.application.service.GroupClassSettingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/group-class")
public class GroupClassSettingController {
    private final GroupClassSettingService groupClassSettingService;
    @GetMapping("/{id}")
    public ResponseEntity<GroupClassSettingDto> getGroupClassSettingById(@PathVariable Integer id) {
        return groupClassSettingService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<GroupClassSettingDto> createGroupClassSetting(@RequestBody GroupClassSettingDto groupClassSetting) {
        GroupClassSettingDto savedGroupClassSetting = groupClassSettingService.create(groupClassSetting);
        return ResponseEntity.ok(savedGroupClassSetting);
    }

    @PutMapping
    public ResponseEntity<GroupClassSettingDto> updateGroupClassSetting(@RequestBody GroupClassSettingDto groupClassSetting) {
        GroupClassSettingDto savedGroupClassSetting = groupClassSettingService.update(groupClassSetting);
        return ResponseEntity.ok(savedGroupClassSetting);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupClassSetting(@PathVariable Integer id) {
        groupClassSettingService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
