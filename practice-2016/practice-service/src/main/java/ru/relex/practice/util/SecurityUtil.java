package ru.relex.practice.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.relex.practice.dto.UserDTO;
import ru.relex.practice.security.PracticeUser;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Утилита для получения текущего пользователя и шифрования данных.
 */
public class SecurityUtil {

    private static final String ENCRYPT_METHOD = "PBKDF2WithHmacSHA256";
    private static final int ITERATIONS = 28665;
    private static final int KEY_LENGTH = 256;
    private static final Base64.Encoder BASE64_ENCODER = Base64.getEncoder();

    private SecurityUtil() {
    }

    /**
     * Получает текущего пользователя системы
     *
     * @return текущий пользователь системы
     */
    public static UserDTO getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object principal = authentication.getPrincipal();
        if (principal == null) {
            return null;
        }
        return ((PracticeUser) principal).getCurrentUser();
    }

    private static byte[] generateSalt() {
        SecureRandom scr = new SecureRandom();
        byte[] salt = new byte[32];
        scr.nextBytes(salt);
        return salt;
    }

    /**
     * Генерирует хешированный пароль использую заданную соль
     * @param rawPassword пароль для хеширования
     * @param salt соль. Если параметр равен {@code null}, то соль буде сгенерирована автоматически
     * @return захешированный пароль
     */
    public static String encodePassword(char[] rawPassword, byte[] salt) {
        byte[] slt = salt == null ? generateSalt() : salt;
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(ENCRYPT_METHOD);
            PBEKeySpec spec = new PBEKeySpec(rawPassword, slt, ITERATIONS, KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            byte[] encoded = key.getEncoded();
            byte[] passAndSalt = new byte[encoded.length + slt.length];
            System.arraycopy(encoded, 0, passAndSalt, 0, encoded.length);
            System.arraycopy(slt, 0, passAndSalt, encoded.length, slt.length);
            return BASE64_ENCODER.encodeToString(passAndSalt);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Генерирует хешированный пароль использую заданную соль
     * @param rawPassword пароль для хеширования
     * @param salt соль. Если параметр равен {@code null}, то соль буде сгенерирована автоматически
     * @return захешированный пароль
     */
    public static String encodePassword(CharSequence rawPassword, byte[] salt) {
        return encodePassword(rawPassword.toString().toCharArray(), salt);
    }
}
