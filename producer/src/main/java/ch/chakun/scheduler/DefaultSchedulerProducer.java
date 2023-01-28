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

    @Value("${kafka.template.default-topic}")
    private String topicName;

    @Value("${kafka.template.orders-topic}")
    private String orders;

    private final KafkaSenderService kafkaSenderService;

    private int counter = 1;

    @Scheduled(fixedRate = 2000)
    public void produce() throws UnknownHostException {
        int random = counter++;

        this.kafkaSenderService.sendMessage("Number : " + random, topicName);

        this.kafkaSenderService.sendMessage("Orders Number : " + random, orders);

        //just for logging
        String hostName = InetAddress.getLocalHost().getHostName();
        System.out.printf("%s produced %d%n", hostName, random);
        System.out.printf("%s produced %d%n", hostName, random);
    }

}