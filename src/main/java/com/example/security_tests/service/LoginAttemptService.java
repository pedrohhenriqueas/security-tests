package com.example.security_tests.service;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Service
public class LoginAttemptService {

    private static final int MAX_ATTEMPTS = 5;
    private static final int MAX_IP_ATTEMPTS = 10;
    private static final int BLOCK_TIME_MINUTES = 3;
    private static final int BLOCK_TIME_DAYS = 1;

    private final Map<String, LoginAttempt> attempts = new ConcurrentHashMap<>();

    public void loginSucceeded(String username) {
        attempts.remove(username);
    }

    public void loginFailed(String username) {
        LoginAttempt attempt = attempts.getOrDefault(username, new LoginAttempt(0, null));
        attempt.count++;
        attempt.lastAttempt = LocalDateTime.now();
        attempts.put(username, attempt);
    }

    public void loginFailedByIp(String ip) {
        LoginAttempt attempt = attempts.getOrDefault(ip, new LoginAttempt(0, null));
        attempt.count++;
        attempt.lastAttempt = LocalDateTime.now();
        attempts.put(ip, attempt);
    }

    public void loginSucceededByIp(String ip) {
        attempts.remove(ip);
    }

    public boolean isIpBlocked(String ip) {
        LoginAttempt attempt = attempts.get(ip);
        if (attempt == null) return false;

        if (attempt.count >= MAX_IP_ATTEMPTS) {
            LocalDateTime unblockTime = attempt.lastAttempt.plusDays(BLOCK_TIME_DAYS);
            if (LocalDateTime.now().isBefore(unblockTime)) {
                return true;
            } else {
                attempts.remove(ip);
                return false;
            }
        }
        return false;
    }

    public boolean isBlocked(String username) {
        LoginAttempt attempt = attempts.get(username);
        if (attempt == null) return false;

        if (attempt.count >= MAX_ATTEMPTS) {
            LocalDateTime unblockTime = attempt.lastAttempt.plusMinutes(BLOCK_TIME_MINUTES);
            if (LocalDateTime.now().isBefore(unblockTime)) {
                return true;
            } else {
                attempts.remove(username);
                return false;
            }
        }
        return false;
    }

    private static class LoginAttempt {
        int count;
        LocalDateTime lastAttempt;

        LoginAttempt(int count, LocalDateTime lastAttempt) {
            this.count = count;
            this.lastAttempt = lastAttempt;
        }
    }

}
