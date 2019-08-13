package com.company.shoppinglist.Database.product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;


@Repository
@Profile("hibernate")
@Transactional
public class CartCollectionHibernate implements CartRep {

    private final SessionFactory sessionFactory;

    @Autowired
    public CartCollectionHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Cart Getcart(Long shoppingCartId) {
        CriteriaBuilder criteriaBuilder = sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Cart> querry = criteriaBuilder.createQuery(Cart.class);
        Root<Cart> root = querry.from(Cart.class);

        querry.select(root).where(criteriaBuilder.equal(root.get("id"), shoppingCartId));

        return sessionFactory.getCurrentSession().createQuery(querry).uniqueResult();
    }


    @Override
    public boolean existbyName(String productName) {
        return false;
    }

    @Override
    public void insert(Cart cart) {
        sessionFactory.getCurrentSession().save(cart);
        //return Cart.getId();
    }


    @Override
    public Map<Long, Cart> getAllcarts() {
        List<Cart> shoppingCarts = sessionFactory.getCurrentSession()
                .createQuery("FROM " + Cart.class.getName(), Cart.class)
                .list();
        return (Map<Long, Cart>) shoppingCarts;
    }


    @Override
    public void deleteCart(Long shoppingCartId){
        sessionFactory.getCurrentSession().delete(Getcart(shoppingCartId));
    }
}

