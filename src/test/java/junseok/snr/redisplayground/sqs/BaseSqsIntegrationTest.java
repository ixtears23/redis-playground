package junseok.snr.redisplayground.sqs;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.localstack.LocalStackContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest
public class BaseSqsIntegrationTest {

    private static final String LOCAL_STACK_VERSION = "localstack/localstack:3.2.0";

    @Container
    static LocalStackContainer localstack = new LocalStackContainer(DockerImageName.parse(LOCAL_STACK_VERSION));
    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.cloud.aws.region.static", () -> localstack.getRegion());
        registry.add("spring.cloud.aws.credential.access-key", () -> localstack.getAccessKey());
        registry.add("spring.cloud.aws.credential.secret-key", () -> localstack.getSecretKey());
        registry.add("spring.cloud.aws.sqs.endpoint", () -> localstack.getEndpointOverride(LocalStackContainer.Service.SQS).toString());
    }

}
