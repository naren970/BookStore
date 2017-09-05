package models;

import java.util.HashSet;
import java.util.Set;

public class Book {
	public Integer id;
	public String title;
	public Integer price;
	public String author;
	
	public Book(){
		
	}
	
	//Constructor
	public Book(Integer id, String title, Integer price, String author){
		this.id = id;
		this.title = title;
		this.price = price;
		this.author = author;
		
	}
	
	//Static Initilization
	private static Set<Book> books;
	
	static {
		books = new HashSet<>();
		books.add(new Book(1,"C++", 2000, "Yeshwanth"));
		books.add(new Book(2, "Java", 3000, "Emer"));
	}
	
	
	//Return all books
	public static Set<Book> allBooks(){
		return books;
	}
	
	
	//Return book by id
	public static Book findById(Integer id){
		for(Book book : books){
			if(book.id.equals(id)){
				return book;
			}
		}
		return null;
	}
	
	
	//Add book 
	public static void add(Book book){
		books.add(book);
	}
	
	//Delete book
	public static boolean delete(Integer id){
		return books.remove(id);
	}
}
