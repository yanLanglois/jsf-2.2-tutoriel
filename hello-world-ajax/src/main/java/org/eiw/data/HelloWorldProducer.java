package org.eiw.data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import org.eiw.model.HelloBean;
/**
 * Le producer es dans le scope Request,
 * il sera recréé à chaque nouvelle requete HTTP.
 */
@RequestScoped
public class HelloWorldProducer {
	private HelloBean myHelloBean;
	/**
     * La méthode qui produit l'objet de données vis à vis de la page XHTML.
     */
	@Named
	@Produces
	public HelloBean getMyHelloBean() {
		return myHelloBean;
	}
	/**
	 * Initialise myHelloBean via un évènement. 
	 * Méthode observeur qui s'éxécute lorsqu'un évènement
	 * de type HelloBean est lancé.
	 * @param helloBean Le paramètre de l'évènement détecté.
	 */
	public void myHelloBeanObserver(
			@Observes(notifyObserver = Reception.IF_EXISTS) 
				HelloBean helloBean) {
		myHelloBean = helloBean;
	}
	
	/**
	 * La méthode qui initialise l'objet,
     * à chaque nouvelle requête HTTP.
     */
	@PostConstruct
	public void initMessage() {
		myHelloBean = new HelloBean();
	}
}
