package com.company.shoppinglist.Database.product;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.hibernate.criterion.Restrictions;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
@Profile("hibernate")
@Transactional
public class ProdCollectionHibernate implements ProdRep {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProdCollectionHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Product insert(Product product) {
        sessionFactory.getCurrentSession().save(product);
        return product;
    }

    public Product findProductById(Long id) {
        Product product= (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("id",id))
                .uniqueResult();
        return product;
    }

    public List<Long> getallids() {
        List<Long> idlist = new ArrayList<>();
        List<Product> prdlist=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class).list();
        for(Product prd:prdlist){
            Long id =prd.getId();
            idlist.add(id);
        }
        return idlist;
    }

    public boolean existbyName(String productName) {
        Product product= (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
                .add(Restrictions.eq("Name",productName))
                .uniqueResult();
        return product != null;
    }

    @Override
    public void insert(Cart cart) {

    }

    @Override
    public Cart Getcart(Long id) {
        return null;
    }

    @Override
    public Map<Long, Cart> getAllcarts() {
        return null;
    }

    @Override
    public Product findCardById(Long id) {
        return null;
    }
}
