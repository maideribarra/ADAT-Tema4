package com.example.application;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;

import org.hibernate.Session;

import com.mysql.cj.xdevapi.SessionFactory;
import com.example.model.dao.DeportistaDAO;
import com.example.model.entities.*;
import com.example.*;



public class fromcsvTodb {
    
    public static void main(String[] args) {
        GestionDB gDB=new GestionDB();
        //gDB.cargarDatos( "./athlete_events2.csv");
        gDB.findDeportistasByOlimpiadaDeporteEvento("1992 Summer","Basketball","Basketball Men's Basketball");
        
        


}
}
