package dao.bdo;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Singleton {

	private static final String DB4O = "BDOO_2019_1.db4o";

	private static ObjectContainer objectContainer;
	private static Singleton singleton;

	private Singleton() {
		objectContainer = Db4oEmbedded.openFile( //
				Db4oEmbedded.newConfiguration(), DB4O);
	}

	public static ObjectContainer getObjectContainer() {
		if (singleton == null) {
			Singleton singleton = new Singleton();
		}
		return objectContainer;
	}

}
