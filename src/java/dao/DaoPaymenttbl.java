/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author Probook 14
 */
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.NewHibernateUtil;
import pojo.PaymentTable;

public class DaoPaymenttbl {
    
    public void addPaymentTable(PaymentTable payment_table)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.save(payment_table);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public void deletePaymentTable(int user_id)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            PaymentTable prod=(PaymentTable)session.load(PaymentTable.class, new Integer(user_id));
            session.delete(prod);
            trans.commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    public List<PaymentTable> getbyID(int user_id)
    {
        List<PaymentTable> payment_table1=new ArrayList();
       
         Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from PaymentTable where user_id= :user_id");
            query.setInteger("user_id", user_id);
            payment_table1=query.list();
            
            trans.commit();
        }
        catch(Exception e)
        {
            
        }
        return payment_table1;
    }
    
    public List<PaymentTable> retrievePaymentTable()
    {
       
        List prod=new ArrayList();
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try
        {
            trans=session.beginTransaction();
            Query query=session.createQuery("from PaymentTable");
            prod=query.list();
         
            trans.commit();
            
        }
        catch(Exception e)
        {

        }
        return prod;
    }
    
    public void updatePaymentTable(PaymentTable payment_table)
    {
        Transaction trans=null;
        Session session=NewHibernateUtil.getSessionFactory().openSession();
        try 
        {
            trans=session.beginTransaction();
            session.update(payment_table);
            trans.commit();
        }
        catch(Exception e)
        {
            
        }   
    }   
}
