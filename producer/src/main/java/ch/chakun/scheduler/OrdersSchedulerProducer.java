//package ch.chakun.scheduler;
//
//import ch.chakun.dto.OrderDto;
//import ch.chakun.service.KafkaSenderService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//import java.util.UUID;
//
//@Component
//@RequiredArgsConstructor
//public class OrdersSchedulerProducer {
//
//    @Value("${kafka.template.orders-topic}")
//    private String ordersTopic;
//
//    private final KafkaSenderService kafkaSenderService;
//
//    private int counter = 1;
//
//    @Scheduled(fixedRate = 1000)
//    public void produce() throws UnknownHostException {
//        int random = counter++;
//
//        String status;
//        if (random % 2 > 0) {
//            status = "PLACED";
//        } else {
//            status = "PROCESSING";
//        }
//
//        OrderDto orderDto = OrderDto.builder()
//                .id(UUID.randomUUID().toString())
//                .number(random)
//                .status(status)
//                .price((double) random * 250)
//                .build();
//
//        this.kafkaSenderService.sendMessage(orderDto, ordersTopic);
//
//        //just for logging
//        String hostName = InetAddress.getLocalHost().getHostName();
//        System.out.printf("%s produced %d%n", hostName, random);
//    }
//
//}