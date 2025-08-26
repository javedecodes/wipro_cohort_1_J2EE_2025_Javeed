package com.worknest.dao.impl;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.worknest.dao.CommentDao;
import com.worknest.model.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Comment comment) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(comment);
        tx.commit();
        session.close();
    }

    public Comment findById(int id) {
        Session session = sessionFactory.openSession();
        Comment comment = session.get(Comment.class, id);
        session.close();
        return comment;
    }

    public List<Comment> findByTaskId(int taskId) {
        Session session = sessionFactory.openSession();
        List<Comment> comments = session.createQuery("from Comment where task.id = :taskId", Comment.class)
                                        .setParameter("taskId", taskId)
                                        .list();
        session.close();
        return comments;
    }

    public void delete(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Comment comment = session.get(Comment.class, id);
        if (comment != null) {
            session.delete(comment);
        }
        tx.commit();
        session.close();
    }
}
