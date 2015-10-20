package br.com.gerenciadorcampeonatos.modelo;

import java.io.Serializable;

public interface PersistentEntity<PK extends Serializable> extends Serializable {

    PK getId();

    void setId(PK id);

    boolean isNew();

}
