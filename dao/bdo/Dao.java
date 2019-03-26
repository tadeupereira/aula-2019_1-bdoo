package dao.bdo;

import com.db4o.ObjectContainer;

import dao.InterfaceDao;


public abstract class Dao<T> implements InterfaceDao<T> {
	
	ObjectContainer objectContainer;
	
	public Dao() {
		objectContainer = Singleton.getObjectContainer();
	}

}
