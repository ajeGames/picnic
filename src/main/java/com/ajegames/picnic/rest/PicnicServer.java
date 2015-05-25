package com.ajegames.picnic.rest;


import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import org.glassfish.grizzly.http.server.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;

/**
 * Starts a Jersey-based server for RESTful interactions with the Picnic Game.
 */
public class PicnicServer {

  private static URI getBaseURI() {
    return UriBuilder.fromUri("http://localhost/").port(8888).build();
  }

  public static final URI BASE_URI = getBaseURI();

  protected static HttpServer startServer() throws IOException {
    System.out.println("Starting Picnic server...");
    ResourceConfig rc = new PackagesResourceConfig("com.ajegames.picnic.rest.resources");
    return GrizzlyServerFactory.createHttpServer(BASE_URI, rc);
  }

  public static void main(String[] args) throws IOException {
    HttpServer httpServer = startServer();
    System.in.read();
    System.out.println("Packing up...");
    httpServer.stop();
    System.out.println("Good-bye.");
  }
}
