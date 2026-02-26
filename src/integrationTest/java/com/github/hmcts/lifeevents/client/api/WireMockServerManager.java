package com.github.hmcts.lifeevents.client.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;

public class WireMockServerManager {

    private static final int PORT = 8089;
    private static WireMockServer wireMockServer;

    // Initialize the WireMock server (singleton)
    public static WireMockServer getServer() {
        if (wireMockServer == null) {
            wireMockServer = new WireMockServer(
                    WireMockConfiguration.options()
                            .port(PORT)
                            .disableRequestJournal() // optional
            );
        }
        return wireMockServer;
    }

    // Start the server
    public static void start() {
        WireMockServer server = getServer();
        if (!server.isRunning()) {
            server.start();
        }
    }

    // Stop the server
    public static void stop() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }

    // Get the base URL for clients
    public static String baseUrl() {
        return "http://localhost:" + PORT;
    }
}