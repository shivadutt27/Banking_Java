package bankApp;

import java.util.ArrayList;

public class Bank {
    
    private String name;
    private ArrayList<Branch> branches;
    
    public Bank(String name)
    {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }
    
    private Branch findBranch(String branchName)
    {
        for(Branch oneBranch: this.branches)
        {
            if(oneBranch.getName().equals(branchName))
            {
                return oneBranch;
            }
        }
        return null;
    }
    
    public boolean addBranch(String branchName)
    {
        Branch branch = findBranch(branchName);
        if(branch==null)
        {
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    
    public boolean addCustomer(String branchName, String customerName, double initialAmount)
    {
        Branch branch = findBranch(branchName);
        if(branch!=null)
        {
            return branch.newCustomer(customerName,initialAmount);
        }
        return false;
    }
    
    public boolean addCustomerTransaction(String branchName, String customerName, double transaction)
    {
        Branch branch = findBranch(branchName);
        if(branch!=null)
        {
            return branch.addCustomerTransaction(customerName, transaction);
        }
        return false;
    }
    
    public boolean listCustomers(String branchName, boolean printList)
    {
       Branch branch = findBranch(branchName);
       if(branch!=null)
       {
           System.out.println("Customer details for branch "+branch.getName());
           ArrayList<Customer> allCustomers = branch.getCustomers();
           for(int i = 0; i < allCustomers.size(); i++)
           {
               Customer oneCustomer = allCustomers.get(i);
               System.out.println("Customer: "+oneCustomer.getName()+" ["+(i+1)+"]");
               
               if(printList)
               {
                   System.out.println("Transactions");
                   ArrayList<Double> allTransactions = oneCustomer.getTransactions();
                   for(int j=0;j<allTransactions.size();j++)
                   {
                       System.out.println("["+(j+1)+"] Amount "+allTransactions.get(j));
                   }
               }
           }
           return true;
       }else{
           return false;
       }
    }
}