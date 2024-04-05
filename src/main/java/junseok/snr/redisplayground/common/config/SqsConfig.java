package junseok.snr.redisplayground.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class SqsConfig {
    private static final ProfileCredentialsProvider credentialsProvider = ProfileCredentialsProvider.create("junseok");


    @Bean
    public SqsAsyncClient sqsAsyncClient() {
        return SqsAsyncClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.AP_NORTHEAST_2)
                .build();
    }

    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .credentialsProvider(credentialsProvider)
                .region(Region.AP_NORTHEAST_2)
                .build();
    }


}
