// ✅ Simple, Medium, Complex Examples using String, Date, Enum methods

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MasterExamples {

    enum Role {
        ADMIN, USER, GUEST
    }

    public static void main(String[] args) {

        // ------------------- STRING METHODS -------------------
        System.out.println("--- STRING METHODS ---");

        // ✅ Simple: Normalize username input
        String rawUsername = "  JavaDev ";
        String cleanUsername = rawUsername.trim().toLowerCase();
        System.out.println("Clean username: " + cleanUsername);

        // ✅ Medium: Parse CSV string to individual values
        String csv = "101,John,john@example.com";
        String[] values = csv.split(",");
        System.out.println("ID: " + values[0] + ", Name: " + values[1]);

        // ✅ Complex: Search, replace, and validate
        String bio = "I love Java and java is cool!";
        String replaced = bio.replace("java", "Java");
        if (replaced.toLowerCase().contains("java")) {
            System.out.println("Cleaned Bio: " + replaced);
        }

        // ------------------- DATE METHODS -------------------
        System.out.println("\n--- DATE METHODS ---");

        // ✅ Simple: Display today's date in dd-MM-yyyy
        LocalDate today = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("Today: " + today.format(fmt));

        // ✅ Medium: Calculate age
        LocalDate dob = LocalDate.of(2001, 9, 15);
        Period age = Period.between(dob, today);
        System.out.println("Age: " + age.getYears() + " years");

        // ✅ Complex: Validate expiry (e.g., subscription)
        LocalDate expiry = LocalDate.parse("2025-04-09");
        if (today.isAfter(expiry)) {
            System.out.println("Subscription expired!");
        } else {
            System.out.println("Valid until: " + expiry.format(fmt));
        }

        // ------------------- ENUM METHODS -------------------
        System.out.println("\n--- ENUM METHODS ---");

        // ✅ Simple: Convert string to enum
        String inputRole = "admin";
        Role role = Role.valueOf(inputRole.trim().toUpperCase());
        System.out.println("Role: " + role);

        // ✅ Medium: Use enum in switch-case
        switch (role) {
            case ADMIN:
                System.out.println("Access: Full control");
                break;
            case USER:
                System.out.println("Access: Limited control");
                break;
            default:
                System.out.println("Access: Guest only");
        }

        // ✅ Complex: Store permissions with EnumMap
        EnumMap<Role, List<String>> permissions = new EnumMap<>(Role.class);
        permissions.put(Role.ADMIN, Arrays.asList("READ", "WRITE", "DELETE"));
        permissions.put(Role.USER, Arrays.asList("READ", "WRITE"));
        permissions.put(Role.GUEST, Collections.singletonList("READ"));

        System.out.println("Admin Permissions: " + permissions.get(Role.ADMIN));
    }
}
