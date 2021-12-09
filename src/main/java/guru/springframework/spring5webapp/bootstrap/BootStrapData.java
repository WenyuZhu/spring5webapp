package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublishRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublishRepository publishReppository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublishRepository publishReppository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publishReppository = publishReppository;
    }



    @Override
    public void run(String... args) throws Exception{

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        Publisher Nanbowan = new Publisher("Nan Bo Wan", "SomeWhereIDon'tKnow", "notImpotant", "notImpotantToo", "00009");
        publishReppository.save(Nanbowan);



        System.out.println("Started in Bootstrap");
        System.out.println("Number of Authors" + authorRepository.count());
        System.out.println("Number of Books" + bookRepository.count());
        System.out.println("Number of Publisher" + publishReppository.count());

        ddd.setPublisher(Nanbowan);
        Nanbowan.getBooks().add(ddd);
        publishReppository.save(Nanbowan);

        noEJB.setPublisher(Nanbowan);
        Nanbowan.getBooks().add(noEJB);
        publishReppository.save(Nanbowan);

        System.out.println("Publisher number of books" + Nanbowan.getBooks().size());
    }
}
