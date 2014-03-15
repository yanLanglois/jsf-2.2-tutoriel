package org.eiw.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
/**
 * Le producer es dans le scope Request,
 * il sera recréé à chaque nouvelle requete HTTP.
 */
@RequestScoped
public class HelloWorldProducer {
	private String message;
	/**
    	 * La méthode qui produit l'objet de données vis à vis de la page XHTML.
    	 */
	@Named
	@Produces
	public String getMessage() {
		return message;
	}
	
	
	/**
     	 * La méthode qui initialise l'objet,
     	 * à chaque nouvelle requête HTTP.
     	 */
	@PostConstruct
	public void initMessage() {
		message = "Hello world !";
	}
}
