package com.example.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.model.dao.VideoDAO;
import com.example.model.entities.Video;
import com.example.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class VideoDaoHibernate implements VideoDAO {
    public Session session=null;
    public VideoDaoHibernate(Session session){
        this.session=session;
    }
    // Método para insertar un video en la base de datos
    @SuppressWarnings("deprecation")
    @Override
    public void insert(Video video) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(video); // Usamos save() de Hibernate para guardar el objeto
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                //transaction.rollback(); // Rollback en caso de fallo
            }
            e.printStackTrace();
        }
    }

    // Método para actualizar los likes de un usuario
    @Override
    public void update(String nombreUsuario, int likes) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "UPDATE Video SET likes = :likes WHERE autor = :autor";
            session.createQuery(hql)
                .setParameter("likes", likes)
                .setParameter("autor", nombreUsuario)
                .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para eliminar videos con duración menor a un valor dado
    @Override
    public void deleteByDuracion(float duracion) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            String hql = "DELETE FROM Video WHERE duracion < :duracion";
            session.createQuery(hql)
                .setParameter("duracion", duracion)
                .executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // Método para actualizar los likes de varios usuarios usando un procedimiento
    @Override
    public void actualizarLikesUsuariosProcedimiento(ArrayList<Integer> likes) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (int i = 0; i < likes.size(); i++) {
                String nombreUsuario = "@usuario" + (i + 1);  // Generar nombre de usuario
                int numeroLikes = likes.get(i);

                String hql = "UPDATE Video SET likes = likes + :likes WHERE autor = :autor";
                session.createQuery(hql)
                    .setParameter("likes", numeroLikes)
                    .setParameter("autor", nombreUsuario)
                    .executeUpdate();
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Hibernate maneja las tablas automáticamente si usas auto-ddl
    @Override
    public void createTable() {
        // En Hibernate, si usas "hibernate.hbm2ddl.auto", no necesitas crear tablas manualmente.
        // Hibernate se encargará de crear las tablas basadas en las anotaciones de las entidades.
    }
}
