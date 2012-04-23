/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upis.ltpiv.turma352.series_mix.model;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author francisco.teixeira
 */
public class TemporadaFactory {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List temporadas = session.createQuery("from Temporada").list();
            session.getTransaction().commit();

            for (Object registro : temporadas) {
                Temporada temporada = (Temporada) registro;
                System.out.println(temporada.getId() + " : " + temporada.getSerie().getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}