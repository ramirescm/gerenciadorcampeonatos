
package br.com.gerenciadorcampeonatos.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarTabelas {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gecampeonatoPU");
        
        EntityManager manager = factory.createEntityManager();

        manager.close();
        factory.close();
    }
    
    
}
