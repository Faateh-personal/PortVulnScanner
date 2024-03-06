package com.portvulnscanner.util;

import java.util.HashMap;
import java.util.Map;

public class NetworkUtil {
    public static Map<Integer, String> loadVulnerabilities() {
        // In a real application, you might read from a file, database, or external service.
        Map<Integer, String> vulnerabilities = new HashMap<>();
        vulnerabilities.put(22, "SSH - Possible vulnerabilities include weak encryption algorithms.");
        vulnerabilities.put(80, "HTTP - Check for insecure HTTP methods enabled.");
        vulnerabilities.put(443, "HTTPS - Check for outdated TLS versions.");
        // Add more known vulnerabilities here
        return vulnerabilities;
    }
}
