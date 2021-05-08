package homework5.core.mailsender.concretes;

import java.util.Random;

import homework5.core.mailsender.abstracts.MailSender;

public class VerificationMailSender implements MailSender{

	@Override
	public String send(String email) {
		Random random = new Random();
		String code = String.valueOf(random.nextInt(1000));
		System.out.println("Onay Kodunuz: "+ code);
		return code;
	}
	
	

}
