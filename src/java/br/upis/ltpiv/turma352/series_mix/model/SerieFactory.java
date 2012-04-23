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
public class SerieFactory {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List series = session.createQuery("from Serie").list();
            session.getTransaction().commit();

            for (Object registro : series) {
                Serie serie = (Serie) registro;
                System.out.println(serie.getId() + " : " + serie.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}