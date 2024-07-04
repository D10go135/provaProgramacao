package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.model.Tarefa;

public class AtualizarTarefaPorId {
	public static void main(String[] args) {
		//1.
		Tarefa tarefa = new Tarefa();
		tarefa.setId(2L);
		tarefa.setDescricao("Estudar Java até o fim!!!");
		tarefa.setFinalizada(false);
		tarefa.setDataFinalizacao(null);
		
		//2.
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		//3. operar com "merge"
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa atualizada, ID: "+tarefa.getId());
		
		manager.close();
		factory.close();
		
		
	}

}
