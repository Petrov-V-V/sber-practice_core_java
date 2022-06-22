package oop_1.Task4;

public class Program {
    public static void main(String[] args) {
        Author author = new Author("John", "john@gmail.com", 'm');
        
        System.out.println(author.getName());
        System.out.println(author.getGender());
        System.out.println(author.getEmail());

        Book book = new Book("The Book of Revelation", author, 96);

        System.out.println(book.getTitle());
        System.out.println(book.getAuthor());
        System.out.println(book.getYear());

        System.out.println(author);
        System.out.println(book);

        author.setName("St. Luke the Evangelist");
        author.setGender('m');
        author.setEmail("eva@gmail.com");

        book.setTitle("The Acts of the Apostles");
        book.setAuthor(author);
        book.setYear(80);

        System.out.println(author);
        System.out.println(book);
    }
}