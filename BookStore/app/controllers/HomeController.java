package controllers;

import play.mvc.*;

import views.html.*;
import home.html.*;
/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    
    public Result about(){
    	return ok("Welcome! to About page");
    }
    
    public Result welcome(String name, String lastName){
    	return ok(home.html.welcome.render(name, lastName));
    }

}
