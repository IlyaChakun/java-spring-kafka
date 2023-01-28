package ch.chakun.service;

import ch.chakun.dto.AbstractDto;

public interface KafkaSenderService {

    void sendMessage(String message, String topicName);

    void sendMessage(AbstractDto message, String topicName);

}
