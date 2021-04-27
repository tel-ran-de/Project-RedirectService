package de.telran.projectredirectservice.service.kafka;

import de.telran.projectredirectservice.dto.StatDto;
import de.telran.projectredirectservice.model.RedirectStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Service
public class StatisticsProducerService {
    private static final String TOPIC = "redirects_statistics";
    @Autowired
    public KafkaTemplate<String, StatDto> kafkaTemplate;

    public void sendRedirectSat(StatDto statDto) {
        Message<StatDto> message = MessageBuilder
                .withPayload( statDto )
                .setHeader( KafkaHeaders.TOPIC, TOPIC )
                .setHeader( KafkaHeaders.PARTITION_ID, 1 )
                .build();
        this.kafkaTemplate.send( message );
    }
}
