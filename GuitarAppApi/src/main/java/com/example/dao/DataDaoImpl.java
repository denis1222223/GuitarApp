package com.example.dao;

import com.example.domain.Song;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DataDaoImpl implements DataDao {

    private final SessionFactory sessionFactory;

    Session session = null;
    Transaction tx = null;

    @Autowired
    public DataDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean addEntity(Song song) {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(song);
        tx.commit();
        session.close();

        return false;
    }

    @Override
    public Song getEntityById(Integer id) {
        session = sessionFactory.openSession();
        Song song = (Song) session.load(Song.class, id);
        System.out.println(song.toString());
        tx = session.getTransaction();
        session.beginTransaction();
        tx.commit();
        System.out.println(song.toString());
        return song;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Song> getEntityList() {
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        List<Song> SongList = session.createCriteria(Song.class).list();
        tx.commit();
        session.close();
        return SongList;
    }

    @Override
    public boolean deleteEntity(Integer id) {
        session = sessionFactory.openSession();
        Object o = session.load(Song.class, id);
        tx = session.getTransaction();
        session.beginTransaction();
        session.delete(o);
        tx.commit();
        return false;
    }
}
