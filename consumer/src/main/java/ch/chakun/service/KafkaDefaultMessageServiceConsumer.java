package ch.chakun.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class KafkaDefaultMessageServiceConsumer {

    @Value("${message.processing.time}")
    private long processingTime;

    @KafkaListener(
            topics = "${kafka.template.default-topic}"
    )
    public void defaultConsumer(String message) throws UnknownHostException, InterruptedException {

        String hostName = InetAddress.getLocalHost().getHostName();

        System.out.println(String.format("%s consumed %s", hostName, message));
        Thread.sleep(processingTime);
    }

    @KafkaListener(topics = "${kafka.template.orders-topic}")
    public void consumer(String message) throws UnknownHostException, InterruptedException {

        String hostName = InetAddress.getLocalHost().getHostName();

        System.out.println(String.format("%s consumed %s", hostName, message));
        Thread.sleep(processingTime);
    }

}
