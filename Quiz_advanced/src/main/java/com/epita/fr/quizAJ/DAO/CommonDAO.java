package com.epita.fr.quizAJ.DAO;

import java.util.List;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.epita.fr.quizAJ.Holders.GenericQueryHolder;

@Repository
public abstract class CommonDAO<T>{

	private static final Logger LOGGER = LogManager.getLogger(CommonDAO.class);
	
	@PersistenceContext
	EntityManager em;
	
//	//For Authenticate
//	@Inject
//	private SessionFactory sf;
	
	//CRUDA (Create,Read,Update,Delete,Authenticate)
	
	//C
	@Transactional(Transactional.TxType.REQUIRED)
	public void create(T entity) {
		LOGGER.info("entering the QUESTIONABC create method");
//		try
//		{
//			em.getTransaction().begin();
			em.persist(entity);
//			em.getTransaction().commit();
//		}
//		catch(Exception e) 
//		{
//			System.out.println("The error is : "+e);
//		} 
		LOGGER.info("exiting the create method");
	}
	
	//R
	public List<T> search(T criteria){
		GenericQueryHolder<T> holder = new GenericQueryHolder<T>();
		prepareSearch(criteria, holder);
		
		TypedQuery<T> query = em.createQuery(holder.getQueryString(), holder.getClassName());
		for(Entry<String,Object> entry : holder.getMap().entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		return query.getResultList();
		
	}
	
	public abstract void prepareSearch(T criteria, GenericQueryHolder<T> holder);
	
	//U
	@Transactional(Transactional.TxType.REQUIRED)
	public void update(T entity) {
		em.merge(entity);
	}
	
	//D
	@Transactional(Transactional.TxType.REQUIRED)
	public void delete(T entity) {
		em.remove(entity); 
	}
	
	//A
	@Transactional(Transactional.TxType.REQUIRED)
	public boolean authenticate(T user){
			GenericQueryHolder<T> holder = new GenericQueryHolder<T>(); 
			authenticateUser(user, holder);
			
			TypedQuery<T> query = em.createQuery(holder.getQueryString(), holder.getClassName());
			for(Entry<String,Object> entry : holder.getMap().entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			if(query.getResultList()!=null && query.getResultList().size()>0)
				return true;
			else
				return false;
	}
	
	public abstract void authenticateUser(T criteria, GenericQueryHolder<T> holder);
}
