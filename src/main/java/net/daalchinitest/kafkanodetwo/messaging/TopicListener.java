package net.daalchinitest.kafkanodetwo.messaging;

import lombok.extern.slf4j.Slf4j;
import net.daalchinitest.kafkanodetwo.data.constants.GeneralConstants.BrokerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TopicListener {

    @KafkaListener(topics = BrokerConfig.TOPIC_CONSUME_ONCE_2, groupId = BrokerConfig.GROUP_COMMON)
    public void consumeMessageOnce (String message) {
        log.info("Received message, topic = {}, message={}", BrokerConfig.TOPIC_CONSUME_ONCE_2, message);
    }

    @KafkaListener(topics = BrokerConfig.TOPIC_CONSUME_ALL, groupId = "${app.instance.id}")
    public void consumeMessageAll (String message) {
        log.info("Received message, topic = {}, message={}",BrokerConfig.TOPIC_CONSUME_ALL, message);
    }
}
