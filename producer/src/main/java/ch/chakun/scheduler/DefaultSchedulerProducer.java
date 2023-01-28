package ch.chakun.scheduler;

import ch.chakun.service.KafkaSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@RequiredArgsConstructor
public class DefaultSchedulerProducer {

    @Value("${kafka.simple.topic}")
    private String topicName;

    private final KafkaSenderService kafkaSenderService;

    private int counter = 1;

    @Scheduled(fixedRate = 2000)
    public void produce() throws UnknownHostException {
        int random = counter++;

        this.kafkaSenderService.sendMessage("Number : " + random, topicName);

        //just for logging
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.printf("TopicName: " + topicName + " %s produced %d%n", hostName, random);
    }

}