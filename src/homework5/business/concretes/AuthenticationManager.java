package homework5.business.concretes;


import homework5.business.abstracts.AuthentucationService;
import homework5.business.abstracts.UserService;
import homework5.business.abstracts.VerificationService;
import homework5.core.gmail.services.LogInWithGmailService;
import homework5.entity.concrete.User;

public class AuthenticationManager implements AuthentucationService {

	private UserService userService;
	private VerificationService verificationService;
	private LogInWithGmailService logInWithGmailService;
	
	
	public AuthenticationManager(UserService userService, VerificationService verificationManager,
			LogInWithGmailService logInWithGmailService) {
		super();
		this.userService = userService;
		this.verificationService = verificationManager;
		this.logInWithGmailService = logInWithGmailService;
	}

	@Override
	public boolean logIn(User user) {
		User userToCheck = this.userService.getByMail(user.getEmail());
		if (userToCheck==null) {
			System.out.println("Kullanýcý Yok");
			return false;
		}
		if (!user.getPassword().equals(userToCheck.getPassword())) {
			System.out.println("Parola yanlýþ");
			return false;
		}
		System.out.println("Giriþ Baþarýlý");
		return true;
	}

	@Override
	public boolean register(User user) {
		if (!(this.userService.checkMailCorrect(user.getEmail())&&
				this.userService.getByMail(user.getEmail()) == null &&
				user.getFirstName().length()>=2 &&
				user.getSurName().length()>=2 &&
				user.getPassword().length() >= 6)){
			System.out.println("Kayýt Baþarýsýz");
			return false;}
		System.out.println("Mail Gönderildi");
		if (!verificationService.verificated(user.getEmail())) {
			System.err.println("Kod Yanlýþ");
			return false;
		}
		System.out.println("Kaydedildi");
		this.userService.userAdd(user);
		return true;
	}

	@Override
	public boolean logInWithGoogle(User user) {
		if (!logInWithGmailService.login(user.getEmail(), user.getPassword())) {
			System.out.println("onaylanmadý");
			return false ;
			
		}
		
		if (this.userService.getByMail(user.getEmail())==null) {
			this.userService.userAdd(user);
			
		}
		System.out.println("giriþ baþaralý");
			return true;
	}


}
