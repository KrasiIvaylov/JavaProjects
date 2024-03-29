package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        System.out.println("Please select Exercise: ");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1 -> booksTitlesByAgeRestriction();
            case 2 -> goldenBook();
            case 3 -> getBooksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> findAuthorByGivenString();
            case 7 -> booksSearch();
            case 8 -> booksSearchByAuthorCredentials();
            case 9 -> countBooksByTitleCount();
            case 10 -> getTotalNumberOfCopiesByAuthor();
        }

    }

    private void getTotalNumberOfCopiesByAuthor() {
        authorService
                .findAllAuthorsAndTheirTotalCopies()
        .forEach(System.out::println);
    }

    private void countBooksByTitleCount() throws IOException {
        System.out.println("Please enter title length in digits:");
        int count = Integer.parseInt(bufferedReader.readLine());
        int books = bookService
                .findTitleLongerThen(count);

        System.out.println(String.format("There are %d books with titles longer than %d symbols"
                , books
                , count));
    }

    private void booksSearchByAuthorCredentials() throws IOException {
        System.out.println("Please enter author`s credentials:");

        String str = bufferedReader.readLine();
        bookService
                .findBooksByAuthorsName(str)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Please enter book credentials:");
        String str = bufferedReader.readLine();

        bookService
                .findBooksByString(str)
                .forEach(System.out::println);
    }

    private void findAuthorByGivenString() throws IOException {
        System.out.println("Please enter last letters of the author`s first name:");
        String str = bufferedReader.readLine();

        System.out.println("Authors: ");
        authorService
                .findAuthorsFirstNameEndingWith(str)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Please enter year for validation in the format of dd-MM-yyyy:");
        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        bookService
                .findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Please enter year of release:");
        int year = Integer.parseInt(bufferedReader.readLine());
        bookService
                .findAllNotReleasedBooks(year)
                .forEach(System.out::println);
    }

    private void getBooksByPrice() {
        bookService
                .findAllBookTitlesWithPriceLessThen5OrMoreThen40()
                .forEach(System.out::println);
    }

    private void goldenBook() {
        System.out.println("Gold edition books with less then 5000 copies:");
        bookService
                .findAllGoldBooksWithTitlesLEssThen5000()
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter age restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());

        bookService
                .findAllBookTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
