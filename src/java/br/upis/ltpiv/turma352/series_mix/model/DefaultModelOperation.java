/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upis.ltpiv.turma352.series_mix.model;

import br.upis.ltpiv.turma352.series_mix.model.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author francisco.teixeira
 */
public class DefaultModelOperation {

    protected Session session;
    protected String defaultTable;

    protected void openConnection() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    protected void closeConnection() {
        HibernateUtil.getSessionFactory().close();
    }

    protected void begin() throws HibernateException {
        session.beginTransaction();
    }

    protected void commit() throws HibernateException {
        session.getTransaction().commit();
    }

    protected void persist(Object object) throws HibernateException {
        this.openConnection();
        try {
            this.begin();
            session.persist(object);
            this.commit();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            this.closeConnection();
        }
    }
    
    protected void delete(Object objetct) throws HibernateException {
        session.delete(objetct);
    }
}
