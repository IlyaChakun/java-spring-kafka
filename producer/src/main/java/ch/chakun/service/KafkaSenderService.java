package ch.chakun.service;

import java.util.Objects;

public interface KafkaSenderService {

    void sendMessage(String message, String topicName);

  //  void sendMessage(Object message, String topicName);

}
