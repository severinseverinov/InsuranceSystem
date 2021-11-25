import java.util.Date;
import java.util.TreeSet;

public class AccountManager {
    private TreeSet<Account> accounts;

    public AccountManager() {
        accounts = new TreeSet<>();
        accounts.add(new Enterprise(new User("Sevgin","SERBEST","sevgin@sevgin.com","1234","Teacher",36,new Date())));
        accounts.add(new Individual(new User("Ali","VELİ","ali@ali.com","1234","Engineer",26,new Date())));
        accounts.add(new Individual(new User("Veli","VELİ","veli@veli.com","1234","Student",34,new Date())));
    }

    public Account login(String email, String password) {
        Account account=null;
        for(Account acc : accounts){
            if(acc.getUser().getEmail().equals(email))
                account = acc;
        }

        try {
            account.login(email, password);
        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }catch (NullPointerException e){
            System.out.println("Böyle bir kullanıcı bulunmamaktadır!");
            System.exit(0);
        }

        return account;
    }
}
