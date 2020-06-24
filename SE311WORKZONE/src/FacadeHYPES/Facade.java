package FacadeHYPES;
/*
Birden çok interface barından programdaki subsystemleri bir interface
içerisinde toplayıp kullanıma daha kolay hale getirmek.
MOTIVATION:
-Reducing complexity.
-Interfaces can become quite complex aim is reducing complexity.
    Reducing this complexity with help of facade like that
    providing a single simple interface.
Consequenses:
    Sub-systemi ve uygulamalarını clienttan gizler böylece daha kolay
    kullanım sağlar.
    SubSystem ve client arasında zayıf bağlantı yaratır böylece client değişimlerden
    etkilenmez.
    Büyük yazılım sistemlerinde derleme bağımlılıklarını azaltır.
    Diğer platformlara taşınma işini basitleştirir.
    FACADE HERHANGİ BİR İŞLEVSELLİK EKLEMEZ SADECE PROGRAMI BASİTLEŞTİRİR.
 */
class Customer {
    // Constructor
    public Customer(String name) {this.name = name; }
    public String getName() {return name;}
    private	String name;
}
// Subsystem Class 1. "Bank"
class Bank {
    public Boolean HasSufficientSavings(Customer c, int amount) {
        System.out.println("Check bank balance of " + c.getName() +
                " for the amount " + amount);
        return true;
    }
}
// Subsystem Class 2. "Credit"
class Credit {
    public Boolean HasGoodCredit(Customer c) {
        System.out.println("Check credit for " + c.getName());
        return true;
    }
}
// Subsystem Class 3. "Loan"
class Loan {
    public Boolean HasNoBadLoans(Customer c) {
        System.out.println("Check outstanding loans for " + c.getName());
        return true;
    }
}

// Facade. "Mortgage"
class Mortgage {
    public	Mortgage() {
        bank = new Bank();
        loan = new Loan();
        credit = new Credit();
    }
    public Boolean IsEligible(Customer cust, int amount) {
        System.out.println(cust.getName() + " applies for " + amount + "TL loan");
        Boolean eligible = true;

        // Check creditworthiness of applicant
        if (!bank.HasSufficientSavings(cust, amount)) {
            eligible = false;
        }
        else if (!loan.HasNoBadLoans(cust)) {
            eligible = false;
        }
        else if (!credit.HasGoodCredit(cust)) {
            eligible = false;
        }
        return eligible;
    }
    private	Bank bank;
    private Loan loan;
    private Credit credit;
}
public class Facade {public static void main(String[] args) {
    // Facade
    Mortgage mortgage = new Mortgage();
    // Evaluate mortgage eligibility for the customer.
    Customer customer = new Customer("Ufuk Celikkan");
    Boolean eligable = mortgage.IsEligible(customer,100000);
    System.out.print(customer.getName());
    System.out.println(" has been " +
            (eligable ? "approved." : "rejected."));
}
}
