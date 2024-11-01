package com.example.kafkaconsumerdatabase;

import com.example.kafkaconsumerdatabase.entity.WikimediaData;
import com.example.kafkaconsumerdatabase.repository.WikimediaDateRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaDatebaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatebaseConsumer.class);
    private final WikimediaDateRepository wikimediaDateRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {
        LOGGER.info(String.format("Event message received: %s", eventMessage));

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikimediaDateRepository.save(wikimediaData);
    }
}
