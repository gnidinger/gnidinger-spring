package com.gnidinger.hello_world;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) { // DI
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) { // 엔티티 클래스 -> DB에 저장
        return messageRepository.save(message);
    }
}