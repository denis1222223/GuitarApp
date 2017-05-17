package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class DataDaoHibernateImpl<T> implements DataDao<T> {

    private final SessionFactory sessionFactory;
    private Class<T> type;
    private Session session = null;
    private Transaction tx = null;

    public DataDaoHibernateImpl(SessionFactory sessionFactory, Class<T> type) {
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @Override
    public boolean add(T entity) {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
        session.close();
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<T> list = session.createCriteria(type).list();
        tx.commit();
        session.close();
        return list;
    }

    @Override
    public T get(Integer id) {
        session = sessionFactory.openSession();
        T entity = (T)session.load(type, id);
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        return entity;
    }

    @Override
    public boolean update(T entity) {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        session = sessionFactory.openSession();
        Object o = session.load(type, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }
}
