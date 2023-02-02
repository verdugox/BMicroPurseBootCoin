package com.bmicro.bootcoin.service;

import com.bmicro.bootcoin.entity.BootCoin;
import com.bmicro.bootcoin.events.BootCoinCreatedEvent;
import com.bmicro.bootcoin.events.Event;
import com.bmicro.bootcoin.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class BootCoinEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.bootCoin.name:bootCoins}")
    private String topicBootCoin;

    public void publish(BootCoin bootCoin) {

        BootCoinCreatedEvent created = new BootCoinCreatedEvent();
        created.setData(bootCoin);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicBootCoin, created);
    }

}
