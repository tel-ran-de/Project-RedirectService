package de.telran.projectredirectservice.controller;

import de.telran.projectredirectservice.dto.StatDto;
import de.telran.projectredirectservice.model.RedirectStatistics;
import de.telran.projectredirectservice.service.kafka.StatisticsConsumerService;
import de.telran.projectredirectservice.service.kafka.StatisticsServiceImplementation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsController {

    private final StatisticsServiceImplementation statisticsServiceImplementation;
    private final StatisticsConsumerService statisticsConsumerService;

    public StatisticsController(StatisticsServiceImplementation statisticsServiceImplementation, StatisticsConsumerService statisticsConsumerService) {
        this.statisticsServiceImplementation = statisticsServiceImplementation;
        this.statisticsConsumerService = statisticsConsumerService;
    }

    @PostMapping("/urls/statistics")
    public List<RedirectStatistics> getTop3Urls(@RequestBody List<StatDto> list) {
        statisticsConsumerService.consume(list);
        return statisticsServiceImplementation.get3ListOfMostVisitedUrls();
    }
}
