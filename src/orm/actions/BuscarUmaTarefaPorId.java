package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class BuscarUmaTarefaPorId {
	public static void main(String[] args) {
		//1. Conectar ao operador do ORM/JPA
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();

		//2.Executar a operação

		//O "R" do CRUD é dado pelo método "find" de Hibernate
		Tarefa t1 = manager.find(Tarefa.class, 1L);
		System.out.println(t1.getDescricao());
		
		manager.close();
		factory.close();

	}

}
