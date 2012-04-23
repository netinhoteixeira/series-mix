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
public class ComentarioFactory {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List comentarios = session.createQuery("from Comentario").list();
            session.getTransaction().commit();

            for (Object registro : comentarios) {
                Comentario comentario = (Comentario) registro;
                System.out.println(comentario.getId() + " : " + comentario.getEpisodio().getNome() + " - " + comentario.getUsuario().getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}