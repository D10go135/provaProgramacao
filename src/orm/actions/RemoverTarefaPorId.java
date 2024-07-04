package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class RemoverTarefaPorId {
	public static void main(String[] args) {
		// 1. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//2.Buscar o objeto a ser excluído
		Tarefa tarefa = new Tarefa();
		tarefa.setId(1L);
		tarefa = manager.find(Tarefa.class, tarefa.getId());
		//ou tarefa = manager.find(Tarefa.class, 1L);
		
		//3. operar com "remove"
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa excluída!");
		
		manager.close();
		factory.close();
		
	}

}
