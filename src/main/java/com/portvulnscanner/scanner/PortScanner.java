package com.portvulnscanner.scanner;

package com.portvulnscanner.scanner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PortScanner {
    private static final int TIMEOUT = 200; // Milliseconds

    public Set<Integer> scan(String ipAddress, int startPort, int endPort) {
        final ExecutorService es = Executors.newFixedThreadPool(20);
        final Set<Integer> openPorts = Collections.synchronizedSet(new HashSet<>());

        for (int port = startPort; port <= endPort; port++) {
            final int currentPort = port;
            es.submit(() -> {
                try (Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(ipAddress, currentPort), TIMEOUT);
                    openPorts.add(currentPort);
                } catch (IOException ignored) {
                    // Port is not open, ignore exception
                }
            });
        }

        es.shutdown();
        try {
            es.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return openPorts;
    }
}


