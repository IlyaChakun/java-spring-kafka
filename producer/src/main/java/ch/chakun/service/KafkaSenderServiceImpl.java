package ch.chakun.service;

import ch.chakun.dto.AbstractDto;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor
public class KafkaSenderServiceImpl implements KafkaSenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final KafkaTemplate<String, AbstractDto> objectKafkaTemplate;

    @Override
    public void sendMessage(String message, String topicName) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, message);

        future.whenComplete((r, e) -> {
//            System.out.println(r);
//            System.out.println(e);
        });
    }

    @Override
    public void sendMessage(AbstractDto message, String topicName) {
        objectKafkaTemplate.send(topicName, message);
    }

}
