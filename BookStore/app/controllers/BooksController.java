package controllers;

import java.util.Set;

import com.google.inject.Inject;

import models.Book;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
//import views.html.*;
import home.html.*;
public class BooksController extends Controller{
	
	@Inject
	FormFactory formFactory;
	
	//Display all books to user
	public Result index(){
		
		Set<Book> books = Book.allBooks();
		return ok(index.render(books));
	}
	
	
	//To create Book
	public Result create(){
		
		Form<Book> bookForm = formFactory.form(Book.class);
		//Book book = new Book(3,"Let us C", 230,"Srivastav");
		
		return ok(create.render(bookForm));
	}
	
	
	//To Save book
	public Result save(){
		Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
		Book book = bookForm.get();
		Book.add(book);
		return redirect(routes.BooksController.index());
	}
	
	//To edit book
	public Result edit(Integer id){
		
		Book book = Book.findById(id);
		if(book == null){
			return notFound("Book Not Found");
		}
		Form<Book> bookForm = formFactory.form(Book.class).fill(book);
		return ok(edit.render(bookForm));
	}
	
	
	//To update book
	public Result update(){
		
		Form<Book> bookForm = formFactory.form(Book.class).bindFromRequest();
		Book book = bookForm.get();
		Book checkBook = Book.findById(book.id);
		if(checkBook == null){
			Book.add(book);
			return redirect(routes.BooksController.index());
		}else{
			return ok("OOPS! Already Exists with id");
		}
		
	}
	
	
	//To delete the book
	public Result destroy(Integer bookId){
		
		Book book = Book.findById(bookId);
		if(book == null){
			return notFound("OOPS! Book Not found");
		}
		Book.delete(bookId);
		return redirect(routes.BooksController.index());
	}
	
	
	//For book details
	public Result show(Integer bookId){
		
		Book book = Book.findById(bookId);
		if(book == null){
			return notFound("OOP's! Book Not Found");
		}
		
		return ok(show.render(book));
	}

}
