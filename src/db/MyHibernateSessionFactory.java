package db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class MyHibernateSessionFactory {

	private static SessionFactory sessionFactory;

	// 私有构造方法，保证单例模式
	private MyHibernateSessionFactory() {

	}

	//共有静态方法，获得会话对象
	public static SessionFactory getSessionFactory() {

		if (sessionFactory == null) {
			// 创建配置对象
			Configuration config = new Configuration().configure();
			// 创建服务注册对象
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
					.buildServiceRegistry();
			// 创建sessionFactory
			sessionFactory = config.buildSessionFactory(serviceRegistry);
			return sessionFactory;
		} else {
			return sessionFactory;
		}
	}
}
