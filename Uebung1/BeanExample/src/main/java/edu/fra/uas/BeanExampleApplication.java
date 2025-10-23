package edu.fra.uas;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner; /* Ermöglicht das Ausführen von Code direkt nach dem Start. */
import org.springframework.boot.SpringApplication; /* Startet die Anwendung */
import org.springframework.boot.autoconfigure.SpringBootApplication; /* Markiert die Hauptklasse als Spring Boot-Anwendung.*/
import org.springframework.context.annotation.Bean; /* Kennzeichnet eine Methode, deren Rückgabewert als Spring-Bean registriert wird.*/

import edu.fra.uas.controller.BeanController;

@SpringBootApplication
public class BeanExampleApplication {

	private static final Logger log = LoggerFactory.getLogger(BeanExampleApplication.class);

	@Autowired
	private BeanController beanController;
	public static void main(String[] args) {
		SpringApplication.run(BeanExampleApplication.class, args);
	}

	@Bean
	CommandLineRunner init() {
		CommandLineRunner action = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				log.debug(beanController.putMessage("Hallo Welt"));
				log.debug(beanController.putMessage("--> OOOHOOO <--"));

			}
		};
		return action;
	}

}
