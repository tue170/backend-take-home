package backend.take.home.quotely.util;

import backend.take.home.quotely.model.Quote;
import backend.take.home.quotely.service.QuotelyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuotelyRunnerTest {
    @Mock
    QuotelyService quotelyService;
    @InjectMocks
    QuotelyRunner quotelyRunner;
    @Test
    void run_With_Normal_Args_Test() throws JsonProcessingException {
        Quote mockQuote = new Quote();
        when(quotelyService.getQuote(anyString())).thenReturn(mockQuote);
        quotelyRunner.run();
        verify(quotelyService).getQuote(anyString());
    }
    @Test
    void run_With_No_Args_Test() throws JsonProcessingException {
        Quote mockQuote = new Quote();
        when(quotelyService.getQuote(anyString())).thenReturn(mockQuote);
        quotelyRunner.run();
        verify(quotelyService).getQuote(anyString());
    }



}