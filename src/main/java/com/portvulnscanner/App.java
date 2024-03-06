package com.portvulnscanner;

import com.portvulnscanner.scanner.PortScanner;
import com.portvulnscanner.scanner.VulnerabilityChecker;

import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for target IP address and port range
        System.out.print("Enter target IP address: ");
        String targetIp = scanner.nextLine();

        System.out.print("Enter starting port: ");
        int startPort = scanner.nextInt();

        System.out.print("Enter ending port: ");
        int endPort = scanner.nextInt();

        // Scan ports
        PortScanner portScanner = new PortScanner();
        Set<Integer> openPorts = portScanner.scan(targetIp, startPort, endPort);

        // Check vulnerabilities
        VulnerabilityChecker vulnerabilityChecker = new VulnerabilityChecker();
        var vulnerabilities = vulnerabilityChecker.check(openPorts);

        // Print results
        System.out.println("\nOpen ports and vulnerabilities:");
        if (vulnerabilities.isEmpty()) {
            System.out.println("No open ports or known vulnerabilities found.");
        } else {
            vulnerabilities.forEach((port, info) -> {
                System.out.println("Port: " + port + " - " + info);
            });
        }

        scanner.close();
    }
}
