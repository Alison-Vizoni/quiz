package br.com.quiz.controle;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	public static String criptografar(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(StandardCharsets.UTF_8.encode(senha));
			return String.format("%032x", new BigInteger(1, md.digest()));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("Erro ao critografar senha " + e.getMessage());
		}
		return null;
	}
}
