package bankApp;

import java.util.ArrayList;

public class Branch {
    
    private String name;
    private ArrayList<Customer> customers;
    
    public Branch(String name)
    {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }
    
    private Customer findCustomer(String name)
    {
        for(Customer oneCustomer: this.customers)
        {
            if(oneCustomer.getName().equals(name))
            {
                return oneCustomer;
            }
        }
        return null;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public ArrayList<Customer> getCustomers()
    {
        return this.customers;
    }
    
    public boolean newCustomer(String customerName, double initialTransaction)
    {
        Customer customer = findCustomer(customerName);
        if(customer==null)
        {
            this.customers.add(new Customer(customerName, initialTransaction));
            return true;
        }
        return false;
    }
    
    public boolean addCustomerTransaction(String customerName, double transaction)
    {
        Customer customer = findCustomer(customerName);
        if(customer!=null)
        {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }
}