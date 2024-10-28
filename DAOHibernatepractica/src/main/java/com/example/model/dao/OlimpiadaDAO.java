package com.example.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.model.entities.Olimpiada;

public class OlimpiadaDAO {
    public Olimpiada obtenerOlimpiadaPorNombre(String nombre,Session session) {
    
        String hql = "FROM Olimpiada o WHERE o.Nombre = :Nombre";
        Query<Olimpiada> query = session.createQuery(hql, Olimpiada.class);
        query.setParameter("Nombre", nombre);
        return query.uniqueResult(); // Devuelve null si no existe
    
}
public void insertarOlimpiada(Olimpiada olimpiada,Session session) {
    Transaction transaction = null;

    // Obtener la sesión de Hibernate
    
        transaction = session.beginTransaction(); // Iniciar la transacción

        session.persist(olimpiada); // Guardar el objeto Olimpiada

        transaction.commit(); // Confirmar la transacción
    
}
}
