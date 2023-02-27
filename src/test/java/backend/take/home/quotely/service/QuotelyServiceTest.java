package backend.take.home.quotely.service;

import backend.take.home.quotely.exception.QuotelyException;
import backend.take.home.quotely.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuotelyServiceTest {

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    QuotelyService quotelyService;

    @Test
    void getForismaticQuoteSuccessfulTest() throws JsonProcessingException {
        Quote expectedQuote = new Quote();
        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class), eq(Quote.class))).thenReturn(new ResponseEntity<>(expectedQuote, HttpStatus.OK));
        Quote actualQuote = quotelyService.getQuote("en");
        assertEquals(expectedQuote, actualQuote);
    }

}