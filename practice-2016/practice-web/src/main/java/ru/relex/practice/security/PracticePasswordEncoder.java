package ru.relex.practice.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import ru.relex.practice.util.SecurityUtil;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

/**
 * Позволяет шифровать пароли и проверять из валидность
 */
public class PracticePasswordEncoder implements PasswordEncoder {

    private static final Base64.Decoder BASE64_DECODER = Base64.getDecoder();

    /**
     * Шифрует пароль пользователя
     *
     * @param rawPassword последовательность символов представляющая незашифрованый пароль пользователя
     * @return зашифрованый пароль закодированный в Base64
     */
    @Override
    public String encode(CharSequence rawPassword) {
        return encode(rawPassword, null);
    }

    /**
     * Шифрует пароль пользователя c заданной солью
     *
     * @param rawPassword последовательность символов представляющая незашифрованый пароль пользователя
     * @param salt        соль, с которой шифруется пароль
     * @return зашифрованый пароль закодированный в Base64
     */
    private String encode(CharSequence rawPassword, byte[] salt) {
        return SecurityUtil.encodePassword(rawPassword, salt);
    }


    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        byte[] decodedPassword = BASE64_DECODER.decode(encodedPassword);
        byte[] salt = new byte[decodedPassword.length / 2];
        System.arraycopy(decodedPassword, decodedPassword.length / 2, salt, 0, salt.length);
        return encodedPassword.equals(encode(rawPassword, salt));
    }
}
