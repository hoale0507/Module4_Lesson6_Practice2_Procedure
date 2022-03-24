package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Component
@Transactional
public class CustomerRepository implements ICustomerRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        String sql = "call Insert_Customer(:firstName,:lastName);";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("firstName",customer.getFirstName());
        query.setParameter("lastName",customer.getLastName());
        return  query.executeUpdate() == 0;
    }
}
