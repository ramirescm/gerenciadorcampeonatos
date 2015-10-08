
package br.com.gerenciadorcampeonatos.util;

import br.com.gerenciadorcampeonatos.modelo.Jogador;
import br.com.gerenciadorcampeonatos.modelo.Time;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gecampeonatoPU");
        
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();
        
        Time novoTime = new Time();
        novoTime.setNome("Guerreiros");
        
        manager.persist(novoTime);
        
        Jogador novoJogador = new Jogador();
        
        novoJogador.setNome("Oséias Vieira Miguel");
        novoJogador.setApelido("Muso");
        novoJogador.setTelefone("99292011");
        
        manager.persist(novoJogador);
                
        manager.getTransaction().commit();
        
        manager.close();
        factory.close();
        
    }
    
}
