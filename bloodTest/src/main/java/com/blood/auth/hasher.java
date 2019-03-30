package com.blood.auth;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/***
 * @author Jeff Jiang
 * This class will provide the encryption function for the web session
 */
public class hasher {
    public static void main(String[] args) {
        System.out.print(encryption("password"));
    }

    /**
     * @param password to encrypt
     * @return hased password
     */
    public static String encryption(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashed = passwordEncoder.encode(password);
        return hashed;
    }
}