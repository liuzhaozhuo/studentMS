package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;

	// ˽�й��췽������֤����ģʽ
	private MyHibernateSessionFactory() {

	}

	//���о�̬��������ûỰ����
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			// �������ö���
			Configuration config = new Configuration().configure();
			// ��������ע�����
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
					.buildServiceRegistry();
			// ����sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
