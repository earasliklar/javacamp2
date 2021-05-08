package homework5.userUI;

import java.util.Scanner;


import homework5.business.abstracts.UserService;
import homework5.business.concretes.AuthenticationManager;
import homework5.business.concretes.UserManager;
import homework5.business.concretes.verificationManager;
import homework5.core.gmail.services.LogInWithGmailAdapter;
import homework5.core.mailsender.concretes.VerificationMailSender;
import homework5.dataAccess.concrete.HibernateDao;
import homework5.entity.concrete.User;

public class Main {
  static boolean loggedIn;
  static Scanner scanner = new Scanner(System.in);
  static UserService userService = new UserManager(new HibernateDao());
  static AuthenticationManager authenticationManager = new AuthenticationManager(userService, new verificationManager(new VerificationMailSender()), new LogInWithGmailAdapter()) ;
  
    public static void main(String[] args) {
    	
    	String mainMessage = "********** xxx sistemine hoþ geldiniz **********\n\n" +
                "1. Giriþ yap\n" +
                "2. Google ile giriþ yap\n" +
                "3. Kayýt ol\n" +
                "4. Çýkýþ Yap\n" +
                "0. Ana mesajý göster\n" +
                "************************************************";
        String loggedMessage = "********** xxx sistemine hoþ geldiniz **********\n\n" +
                "1. Hesabýmý sil\n"+
                "2. Çýkýþ yap\n" +
                "0. Mesajý göster\n" +
                "************************************************";;
                
                /*User user1 = new User(1,"Emre","Araþlýklar","emrearasliklar@gmail.com","1234567");
                User user2 = new User("test@test.com","1234567");
                authenticationManager.register(user1);
                authenticationManager.logIn(user2);*/
                System.out.println(mainMessage);
    
                int key;
                
                while(true) {
                	System.out.println("Ýþlem seç");
                	key = scanner.nextInt();
                	switch (key) {
					case 1: 
						logIn();
						break;
					
					case 2: 
						logInWithGmail();
						break;
					
					case 3: 
						register();
						break;
					case 4: 
						return;
					
					case 0: 
						System.out.println(mainMessage);
						break;
					
					
					default:
						System.out.println("seçim yapýnýz");
					
                }
                	
                while(loggedIn) {
				System.out.println("Ýþlem seçiniz");
				key = scanner.nextInt();
				switch (key) {
				case 1: 
					deleteAccount();
					break;
					
				
				case 2:
					System.out.println( mainMessage);
					loggedIn=false;
					break;

				
				case 0:
					System.out.println(loggedMessage);
					break;
					
				
				default:	System.out.println("lütfen seçin");
				
				
				}
				}
                }
}

                 		
                		
                	
                
              
    	


    public static void register() {
 	   scanner.nextLine();
 	   String mail,password,firstname,lastname;
 	   System.out.println("ad girin");
 	   firstname = scanner.nextLine();
 	   System.out.println("soyad girin");
 	   lastname = scanner.nextLine();
 	   System.out.println("mail girin");
 	   mail = scanner.nextLine();
 	   System.out.println("þifre girin");
 	   password = scanner.nextLine();
 	   User user = new User(HibernateDao.getLastId()+1, firstname, lastname, mail, password);
 	   loggedIn = authenticationManager.register(user); 
 	   
 	   
    }    
    
    public static void logIn() {
    	
    	scanner.nextLine();
    	String mail,password;
    	System.out.println("mail girin");
    	mail = scanner.nextLine();
    	System.out.println("þifre girin");
    	password = scanner.nextLine();
    	User user =  new User(mail, password);
    	loggedIn = authenticationManager.register(user); 
    }
    
    public static void logInWithGmail () {
    	scanner.nextLine();
    	String mail,password;
    	System.out.println("mail girin");
    	mail = scanner.nextLine();
    	System.out.println("þifre girin");
    	password = scanner.nextLine();
    	User user =  new User(mail, password);
    	loggedIn = authenticationManager.register(user); 
    	
    	
    	
    }
    public static void deleteAccount(){
        System.out.println("Sistem henüz eklenmemiþ!");
    }
}

