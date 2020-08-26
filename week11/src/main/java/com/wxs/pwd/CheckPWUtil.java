package com.wxs.pwd;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.concurrent.ConcurrentHashMap;

public class CheckPWUtil {

    private final static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    private final static CustomizedPasswordEncoder customizedPasswordEncoder = new CustomizedPasswordEncoder();
    private final static ConcurrentHashMap<String, String> saltMap = new ConcurrentHashMap<>();

    //模拟数据库存储
    static {
        saltMap.put("12", "Asd");
    }

    /**
     * Spring security
     * <p>
     * bCryptPasswordEncoder
     *
     * @param userId             用户ID
     * @param passwordPlaintext  密码明文
     * @param passwordCiphertext 密码密文
     * @return
     */
    public static boolean checkPW1(String userId, String passwordPlaintext, String passwordCiphertext) {
        //获取加密盐值
        String salt = saltMap.get(userId);
        return bCryptPasswordEncoder.matches(salt + passwordPlaintext, passwordCiphertext);
    }

    /**
     * Spring security
     * customizedPasswordEncoder
     *
     * @param userId             用户ID
     * @param passwordPlaintext  密码明文
     * @param passwordCiphertext 密码密文
     * @return
     */
    public static boolean checkPW2(String userId, String passwordPlaintext, String passwordCiphertext) {
        //获取加密盐值
        String salt = saltMap.get(userId);
        return customizedPasswordEncoder.matches(salt + passwordPlaintext, passwordCiphertext);
    }

    public static void main(String[] args) {
        String userId = "12";
        String passwordPlaintext = "gkbbbb123";
        //bCryptPasswordEncoder
        String passwordCiphertext = "$2a$10$oiBY44m3HsE/K9eY.NlHwujMDavaV8JIuMqqOy5v7kLsVeQSE6umW";
        //customizedPasswordEncoder
        String passwordCiphertext2 = "ef23d52d33dca4788b4d92f00c50dbdd";

        System.out.println(checkPW1(userId, passwordPlaintext, passwordCiphertext));
        System.out.println(checkPW2(userId, passwordPlaintext, passwordCiphertext2));
    }
}
