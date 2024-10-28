package com.example.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.model.entities.Deporte;
import com.example.model.entities.Olimpiada;

public class DeporteDAO {
    public Deporte obtenerDeportePorNombre(String nombre,Session session) {
        
            String hql = "FROM Deporte d WHERE d.Nombre = :Nombre";
            Query<Deporte> query = session.createQuery(hql, Deporte.class);
            query.setParameter("Nombre", nombre);
            return query.uniqueResult(); // Devuelve null si no existe
        
    }
    public void insertarDeporte(Deporte deporte, Session session) {
        Transaction transaction = null;

        // Obtener la sesión de Hibernate
        
            transaction = session.beginTransaction(); // Iniciar la transacción

            session.persist(deporte); // Guardar el objeto Olimpiada

            transaction.commit(); // Confirmar la transacción
        
    }
}
