package de.telran.projectredirectservice.service.kafka;

import de.telran.projectredirectservice.dto.StatDto;
import de.telran.projectredirectservice.model.RedirectStatistics;
import de.telran.projectredirectservice.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImplementation implements StatisticsService {
//    private static final Logger logger = LoggerFactory.getLogger( StatisticsServiceImplementation.class );

    private final StatisticsRepository statisticsRepository;

    public StatisticsServiceImplementation(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    @Override
    public void makeInsertOrUpdateInBd(List<StatDto> statDtoList) {
        Map<StatDto, Long> result = new HashMap<>();

        result = statDtoList.stream().collect( Collectors.groupingBy( Function.identity(), Collectors.counting() ) );
        for (Map.Entry<StatDto, Long> entry : result.entrySet()) {
            statisticsRepository.updateCounterForRedirectStatistics( entry.getKey().getShortUrl(), entry.getKey().getLongUrl(),
                    entry.getValue() );
        }
    }

    @Override
    public List<RedirectStatistics> get3ListOfMostVisitedUrls() {
        return statisticsRepository.findTop3ByOrderByCounterDesc();
    }
}
