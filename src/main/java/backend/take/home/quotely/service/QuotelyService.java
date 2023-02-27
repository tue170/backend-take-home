package backend.take.home.quotely.service;

import backend.take.home.quotely.model.Quote;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@AllArgsConstructor
public class QuotelyService {
    private final RestTemplate restTemplate;
    private final static String FORISMATIC_API = "http://api.forismatic.com/api/1.0/";

    /**
     * This method is used to retrieve the quote from Forismatic API
     *
     * @param languageCode en or ru
     * @return Quote quote object that contains quote text and author's name
     * @throws JsonProcessingException when there's error processing the request
     */
    public Quote getQuote(String languageCode) throws JsonProcessingException {
        // Initializing the http headers
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        httpHeaders.add("user-agent", "");
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(httpHeaders);

        // Setting up the query parameters
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(FORISMATIC_API)
                .queryParam("method","getQuote")
                .queryParam("format", "json")
                .queryParam("lang", languageCode);
        log.info("Retrieving quote from the forismatic api with the language code: " + languageCode);
        ResponseEntity<Quote> response = restTemplate.exchange(uriComponentsBuilder.toUriString(), HttpMethod.GET, requestEntity, Quote.class);

        return response.getBody();
    }


}
