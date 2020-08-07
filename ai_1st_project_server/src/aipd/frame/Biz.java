package aipd.frame;

import java.util.ArrayList;

import org.springframework.transaction.annotation.Transactional;

public interface Biz<Id, Model> {

	@Transactional
	public void register(Model model);

	@Transactional
	public default void modify(Model model) throws Exception {

	}

	@Transactional
	public default void remove(Id id) throws Exception {

	}

	public Model get(Id id);

	public ArrayList<Model> get();

	

}
