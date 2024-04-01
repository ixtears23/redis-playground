package junseok.snr.redisplayground.user.application;

public record UserCreatedEvent(String id, String username, String email) {
}
