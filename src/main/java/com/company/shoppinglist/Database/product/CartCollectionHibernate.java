package com.company.shoppinglist.Database.product;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
    @Profile("hibernate")
    @Transactional
    public class CartCollectionHibernate {

        private final SessionFactory sessionFactory;

        @Autowired
        public CartCollectionHibernate(SessionFactory sessionFactory) {
            this.sessionFactory = sessionFactory;
        }

}

