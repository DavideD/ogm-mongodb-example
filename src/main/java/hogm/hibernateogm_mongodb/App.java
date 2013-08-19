package hogm.hibernateogm_mongodb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.ogm.cfg.OgmConfiguration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Untersuchungsraum.Contact;

/**
 * @author Davide D'Alto <davide@hibernate.org>
 */
public class App {
	public static void main(String[] args) {
		Configuration configuration = new OgmConfiguration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings( configuration.getProperties() ).buildServiceRegistry();
		SessionFactory sessionFactory = configuration.buildSessionFactory( serviceRegistry );
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		System.out.println( "Populating the database..." );
		Contact cnt = new Contact();
		cnt.setFirstname( "Blabla" );
		cnt.setLastname( "Blabla" );
		cnt.setEmail( "blabla" );
		session.save( cnt );
		session.getTransaction().commit();
		System.out.println( "Done... :)" );
	}

}
