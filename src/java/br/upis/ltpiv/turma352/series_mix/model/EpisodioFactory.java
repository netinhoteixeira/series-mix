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
public class EpisodioFactory {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List episodios = session.createQuery("from Episodio").list();
            session.getTransaction().commit();

            for (Object registro : episodios) {
                Episodio episodio = (Episodio) registro;
                System.out.println(episodio.getId() + " : " + episodio.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}