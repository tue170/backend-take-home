package backend.take.home.quotely.util;

import backend.take.home.quotely.exception.QuotelyException;
import backend.take.home.quotely.model.Quote;
import backend.take.home.quotely.service.QuotelyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@AllArgsConstructor
public class QuotelyRunner implements CommandLineRunner {
    private final QuotelyService quotelyService;


    /**
     * This method is used to run the program by taking in the argument and displays the quote and author
     *
     * @param args command line arguments
     */
    @Override
    public void run(String... args) {
        try {
            // Default the language to English
            String requestedLanguage = "English";
            String languageCode = "";
            if (args.length > 0) {
                requestedLanguage = args[0];
                switch(requestedLanguage.toLowerCase()){
                    case "english":
                        languageCode = "en";
                        break;
                    case "Russian":
                        languageCode = "ru";
                        break;
                    default:
                        throw new QuotelyException("Invalid language is passed as an argument. Exiting the application.");
                }
                requestedLanguage = args[0];
                log.info("The language requested by the user is " + requestedLanguage);
            }
            Quote quote = quotelyService.getQuote(languageCode);
            log.info("The quote is: " + quote.getQuoteText());
            log.info("The author is: " + quote.getQuoteAuthor());

        } catch (QuotelyException | JsonProcessingException e) {
            log.error(e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

}
