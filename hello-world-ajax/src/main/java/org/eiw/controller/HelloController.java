package org.eiw.controller;

import javax.enterprise.event.Event;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import org.eiw.model.HelloBean;

/**
 * Controller qui va traiter les demandes des vues.
 * L'annotation est utilisée pour :
 * 	- Positionner l'objet dans le scope Request
 * 	- Outjecter l'objet dans le contexte d'injection CDI
 * 	- Pouvoir référencer l'objet dans la vue XHTML
 */
@Model
public class HelloController {
	
	/**
	 * Injection d'un evènement pour pouvoir prévenir
	 * le producer que l'objet myHelloBean doit être modifier.
	 */
	@Inject
	private Event<HelloBean> helloBeanEventSrc;
	
	/**
	 * Action pour traiter la soumission du formulaire.
	 * @param helloBean Cet instance vient de l'IHM.
	 */
	public void modifierBean(HelloBean helloBean) {
		// Lancement de l'évènement de type HelloBean pour
		// provoquer l'exécution de la méthode observeur
		// pour mettre à jour le bean HeeloBean
		helloBeanEventSrc.fire(helloBean);
	}
}
