package com.example.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.mapping.List;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.model.entities.Deportista;
import com.example.model.entities.Olimpiada;

public class DeportistaDAO {
    public Deportista obtenerDeportistaPorNombre(String nombre,Session session) {
        
            String hql = "FROM Deportista d WHERE d.Nombre = :Nombre";
            Query<Deportista> query = session.createQuery(hql, Deportista.class);
            query.setParameter("Nombre", nombre);
            return query.uniqueResult(); // Devuelve null si no existe
        
    }

    public void insertarDeportista(Deportista deportista,Session session) {
        Transaction transaction = null;

        // Obtener la sesión de Hibernate
        
            transaction = session.beginTransaction(); // Iniciar la transacción

            session.persist(deportista); // Guardar el objeto Olimpiada

            transaction.commit(); // Confirmar la transacción
        
    }

    public void findDeportistasByOlimpiadaDeporteEvento(String nombreOlimpiada, String nombreDeporte, String nombreEvento) {
        String hql = """
            SELECT d
            FROM Deportista d            
            JOIN d.Equipo eq
            JOIN eq.Eventos e
            JOIN e.Olimpiada o
            JOIN e.Deporte dep
            WHERE o.Nombre = :nombreOlimpiada
            AND dep.Nombre = :nombreDeporte
            AND e.Nombre = :nombreEvento
        """;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Deportista> query = session.createQuery(hql, Deportista.class);
            query.setParameter("nombreOlimpiada", nombreOlimpiada);
            query.setParameter("nombreDeporte", nombreDeporte);
            query.setParameter("nombreEvento", nombreEvento);
            System.out.println("entro for");
            for (Deportista dep: query.getResultList()){
                System.out.println("nombre"+dep.getNombre());
            }
        }
}
}
