
package castelinogohilculminating;


public class Employee 
{
    protected int empid, salary;  
    protected String name, address, shift;
    protected double payperHour;
    protected int hoursWorked;
    
    //making constructors 
    
    Employee()
    {
        
    }
    
    Employee(int e, int s, String n, String a, String sh, double pph, int hw) 
    {
        empid = e;
        salary = s;
        name = n;
        address = a;
        shift = sh;
        payperHour = pph;
        hoursWorked = hw;
        
    }

    
    public int getEmployeeid(int empid)
    {
        return empid;
    }
    
    public void setEmpid(int empid)
    {
        
    }
    
    public int getSalary(int salary)
    {
        return salary;
    }
    
    public void setSalary(int salary)
    {
        
    }
    
//    public String getName()
//    {
//        return name;
//    }
//    
//    public void setName( String Name)
//    {
//         
//    }
//    
//    public String getAddress()
//    {
//        return address;
//        
//    }
//    
//    public void setAdrtess( String Adress)
//    {
//        
//        
//    }
//      
//    public String getShift( )   
//    {
//        return shift;
//    }
//     
//    
//    public void setShift()
//    {
//        
//    
//    }
    
    
    public void menu()
    {
        
    }
    
    
    
}
