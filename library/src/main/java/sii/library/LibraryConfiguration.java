package sii.library;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import sii.library.book.BookCatalog;

import java.util.List;

import static sii.library.LibraryDepartment.FANTASY;
import static sii.library.LibraryDepartment.HORROR;

@Slf4j
@Configuration
@EnableScheduling
public class LibraryConfiguration { // JavaConfig
    @Autowired
    private Environment environment;

    @Autowired
    private ApplicationContext context;

    @Bean
    BookCatalog createBookCatalog() {
        return new BookCatalog();
    }

    @Bean
    LibraryUnit createLibraryUnit(BookCatalog bookCatalog) {
        var departments = List.of(HORROR, FANTASY);
        return new LibraryUnit(environment.getProperty("sii.library.name"), departments, bookCatalog);
    }

//    @Scheduled(fixedRate = 5000)
    void printBeans() {
        log.info(context.getBean(LibraryUnit.class).toString());
        log.info("\n");

    }
}
