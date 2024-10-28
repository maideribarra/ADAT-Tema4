package com.example.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.HibernateUtil;
import com.example.model.entities.Evento;

public class EventoDAO {
    public void insertarEvento(Evento evento,Session session) {
        Transaction transaction = null;

        // Obtener la sesión de Hibernate
        
            transaction = session.beginTransaction(); // Iniciar la transacción

            session.persist(evento); // Guardar el objeto Olimpiada

            transaction.commit(); // Confirmar la transacción
        
    }
    
}
