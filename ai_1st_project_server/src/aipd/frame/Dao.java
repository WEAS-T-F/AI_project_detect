package aipd.frame;

import java.util.ArrayList;

public interface Dao<Id, Model> {

	// CRUD //

	public ArrayList<Model> selectall();

	public Model select(Id id);

	public void insert(Model model);

	public default void update(Model model) throws Exception {
	}

	public default void delete(Id id) throws Exception {
	}

}
