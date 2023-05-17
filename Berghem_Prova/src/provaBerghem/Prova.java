package provaBerghem;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Prova {

	public static void main(String[] args) {

		try {

			Scanner ler = new Scanner(System.in);
			System.out.println("insira o texto para criptografar");
			String texto = ler.next();

			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			SecretKey secretKey = keyGenerator.generateKey();
			Cipher cipher;
			cipher = Cipher.getInstance("AES");
			
			//criptografar
			cipher.init(cipher.ENCRYPT_MODE, secretKey);
			byte[] criptografado = cipher.doFinal(texto.getBytes());
			System.out.println("senha criptografada com sucesso: " + criptografado);

			//descriptografar
			cipher.init(cipher.DECRYPT_MODE, secretKey);
			byte[] descriptografado = cipher.doFinal(criptografado);
			System.out.println("senha descriptografada com sucesso: " + new String(descriptografado));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
