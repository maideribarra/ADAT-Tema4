package com.example.application;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;

import com.example.HibernateUtil;
import com.example.model.dao.DeporteDAO;
import com.example.model.dao.DeportistaDAO;
import com.example.model.dao.EquipoDAO;
import com.example.model.dao.EventoDAO;
import com.example.model.dao.OlimpiadaDAO;
import com.example.model.entities.Deporte;
import com.example.model.entities.Deportista;
import com.example.model.entities.Equipo;
import com.example.model.entities.Olimpiada;
import com.example.model.entities.Evento;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class GestionDB {

    public void cargarDatos( String ruta){
        OlimpiadaDAO olimpiadaDAO=new OlimpiadaDAO();
        EquipoDAO equipoDAO=new EquipoDAO();
        DeporteDAO deporteDAO=new DeporteDAO();
        DeportistaDAO deportistaDAO=new DeportistaDAO();
        EventoDAO eventoDAO=new EventoDAO();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try (CSVReader reader = new CSVReader(new FileReader(ruta))) {
            
            // Leer todas las líneas del archivo CSV
            List<String[]> lineas = reader.readAll();
            lineas.remove(0);//remuevo la cabecera

            // Imprimir el contenido del archivo CSV
            for (String[] linea : lineas) {
                System.out.println("linea:"+linea[0]);
                Olimpiada olimpiada = olimpiadaDAO.obtenerOlimpiadaPorNombre(linea[8],session);
                Equipo equipo = equipoDAO.obtenerEquipoPorNombre(linea[6],session);
                Deporte deporte = deporteDAO.obtenerDeportePorNombre(linea[12],session);
                Deportista deportista = deportistaDAO.obtenerDeportistaPorNombre(linea[1],session);         
                 
                
                if (olimpiada != null) {
                    System.out.println("Olimpiada encontrada: " + olimpiada.getNombre());
                } else {
                    System.out.println("Olimpiada no encontrada.");
                    olimpiada=new Olimpiada(linea[8],linea[9].equals("NA")? 0 :Integer.parseInt(linea[9]),linea[10],linea[11]);
               
                }              
                
                if (equipo != null) {
                    System.out.println("Equipo encontrado: " + equipo.getNombre());
                } else {
                    System.out.println("Equipo no encontrado.");
                    equipo=new Equipo(linea[6],linea[7]);                
                
                }                
                
                if (deporte != null) {
                    System.out.println("Deporte encontrado: " + deporte.getNombre());
                } else {
                    System.out.println("Deporte no encontrado.");
                    deporte=new Deporte(linea[12]);
                }               
                
                if (deportista != null) {
                    System.out.println("Deportista encontrado: " + deportista.getNombre());
                } else {
                    System.out.println("Deportista no encontrado.");
                    deportista=new Deportista(linea[1],linea[2],linea[3].equals("NA")? 0 :Integer.parseInt(linea[3]),linea[4].equals("NA")? 0 :Double.parseDouble(linea[4]),linea[5].equals("NA")? 0 :Double.parseDouble(linea[5]));
                
                }

                Evento evento=new Evento(linea[13],deporte,olimpiada);
                
                
                deportista.setEquipo(equipo);
                equipo.setEvento(evento);
                equipo.setDeportista(deportista);
                evento.setEquipo(equipo);
                deporteDAO.insertarDeporte(deporte, session);                
                olimpiadaDAO.insertarOlimpiada(olimpiada,session);
                //equipoDAO.insertarEquipo(equipo,session);
                //deportistaDAO.insertarDeportista(deportista);
                //equipoDAO.insertarEquipo(equipo);
                eventoDAO.insertarEvento(evento, session);
            }

        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }



    }

    public void findDeportistasByOlimpiadaDeporteEvento(String nombreOlimpiada, String nombreDeporte, String nombreEvento){
        
        //return DeportistaDAO.findDeportistasByOlimpiadaDeporteEvento("1992 Summer","Alpine Skiing","Basketball Men's Basketball");
        DeportistaDAO dDAO=new DeportistaDAO();
        dDAO.findDeportistasByOlimpiadaDeporteEvento(nombreOlimpiada, nombreDeporte, nombreEvento);

    }

    

    
}
