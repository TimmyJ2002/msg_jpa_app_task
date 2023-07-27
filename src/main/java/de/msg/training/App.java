package de.msg.training;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.msg.training.model.Author;
import org.hibernate.sql.Select;

public class App 
{
    public static void main( String[] args )
    {
    	//Create EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-app-managed-task");

        //Create EntityManager
        EntityManager entityManager = emf.createEntityManager();

        //Create EntityTransaction
        EntityTransaction entityTransaction = entityManager.getTransaction();

        //Open Transaction
        TypedQuery<Author> q = entityManager.createQuery("select a from Author a", Author.class);
        List<Author> authorList = q.getResultList();
        authorList.forEach(System.out::println);


        //Create Author and persist it
        Author newAuthor = new Author();
        newAuthor.setFirstName("Firstname");
        newAuthor.setLastName("Lastname");

        //Commit Transaction
        entityTransaction.begin();
        entityManager.persist(newAuthor);
        entityTransaction.commit();

        //Create Query Hint: entityManager.createQuery("select a from Author a", Author.class);
        entityManager.createQuery("SELECT a from Author a");

        //Print the authors
        System.out.println(authorList);
    }
}
