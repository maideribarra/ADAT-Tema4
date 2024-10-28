package com.example.model.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.example.HibernateUtil;
import com.example.model.entities.Equipo;
import com.example.model.entities.Olimpiada;

public class EquipoDAO {
    public Equipo obtenerEquipoPorNombre(String nombre,Session session) {
        
            String hql = "FROM Equipo e WHERE e.Nombre = :Nombre";
            Query<Equipo> query = session.createQuery(hql, Equipo.class);
            query.setParameter("Nombre", nombre);
            return query.uniqueResult(); // Devuelve null si no existe
        
}
    public void insertarEquipo(Equipo equipo,Session session) {
        Transaction transaction = null;

        // Obtener la sesión de Hibernate
        
            transaction = session.beginTransaction(); // Iniciar la transacción

            session.persist(equipo); // Guardar el objeto Olimpiada

            transaction.commit(); // Confirmar la transacción
        
    }
    
}
