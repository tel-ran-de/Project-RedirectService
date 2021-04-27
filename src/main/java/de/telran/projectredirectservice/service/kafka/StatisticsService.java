package de.telran.projectredirectservice.service.kafka;

import de.telran.projectredirectservice.dto.StatDto;
import de.telran.projectredirectservice.model.RedirectStatistics;

import java.util.List;

public interface StatisticsService {

    void makeInsertOrUpdateInBd(List<StatDto> statDtoList);

    List<RedirectStatistics> get3ListOfMostVisitedUrls();
}
