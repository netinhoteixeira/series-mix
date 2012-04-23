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
public class ServidorFactory {

    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List servidores = session.createQuery("from Servidor").list();
            session.getTransaction().commit();

            for (Object registro : servidores) {
                Servidor servidor = (Servidor) registro;
                System.out.println(servidor.getId() + " : " + servidor.getNome());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}