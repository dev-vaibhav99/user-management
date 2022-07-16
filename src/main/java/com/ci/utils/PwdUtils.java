package com.ci.utils;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class PwdUtils {

	private static Logger logger = LoggerFactory.getLogger(PwdUtils.class);
	private static final String SECRET_KEY = "abc123xyz123abcd";
	private static final String INIT_VECTOR = "abc123xyz123abcd";

	private PwdUtils() {
	}

	public static String encryptMsg(String msg) {
		String encodedToStrig = null;

		try {
			IvParameterSpec ivParamSpec = new IvParameterSpec(INIT_VECTOR.getBytes());

			SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParamSpec);

			byte[] encrypted = cipher.doFinal(msg.getBytes());
			encodedToStrig = Base64.getEncoder().encodeToString(encrypted);
		} catch (Exception e) {
			logger.error("Exception Occured" + e.getMessage(), e);
		}

		return encodedToStrig;
	}

	public static String decryptMsg(String msg) {
		String decryptedMsg = null;
		try {
			IvParameterSpec ivParamSpec = new IvParameterSpec(INIT_VECTOR.getBytes());

			SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");

			cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParamSpec);

			byte[] decodedMsg = Base64.getDecoder().decode(msg);

			byte[] decrypted = cipher.doFinal(decodedMsg);
			decryptedMsg = new String(decrypted);
		} catch (Exception e) {
			logger.error("Exception Occured" + e.getMessage(), e);
		}
		return decryptedMsg;

	}
}
