package homework5.business.concretes;


import java.util.Scanner;

import homework5.business.abstracts.VerificationService;
import homework5.core.mailsender.abstracts.MailSender;

public class verificationManager implements VerificationService {
	
	private MailSender mailSender;
	
	
	

	public verificationManager(MailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}




	@Override
	public boolean verificated(String email) {
		String code = "";
		try {
			code = mailSender.send(email);
			}
		catch (Exception e) {
			System.out.println("hata");
		}
		Scanner scanner = new Scanner(System.in);
		System.out.println("Kodu Girin : ");
		String enteredCode = scanner.nextLine();
		if (!(code.equals(enteredCode))) {
			return false;
		}
		return true;
	}
	

}
