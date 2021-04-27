package de.telran.projectredirectservice.service.kafka;

import de.telran.projectredirectservice.dto.StatDto;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class StatisticsConsumerService {
    private final Logger LOGGER = LoggerFactory.getLogger( StatisticsConsumerService.class );

    private final StatisticsServiceImplementation statisticsServiceImplementation;

    private final static String topic = "redirects_statistics";
    private final static String groupId = "group_one";

    @KafkaListener(topics = topic, groupId = groupId, containerFactory = "kafkaListenerContainerFactory",
            autoStartup = "true")
    public void consume(@Payload List<StatDto> statDtoList) {
        statisticsServiceImplementation.makeInsertOrUpdateInBd( statDtoList );

        LOGGER.info( "Consumer have received the statistics: " + statDtoList.toString() );
    }
}
