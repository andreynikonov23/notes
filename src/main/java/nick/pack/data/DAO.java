package nick.pack.data;

import java.util.List;

public interface DAO<Entity> {
	public void insert(Entity entity);
	public void update(Entity entity);
	public void delete(Entity entity);
	public List<Entity> selectAll();
}
