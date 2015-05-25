package com.ajegames.picnic.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/picnic")
public class PicnicResource {

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String welcomeText() {
    return "Let's have a picnic!\n";
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public String welcomeHtml() {
    return "<html><body><h1>Let's have a picnic!</h1></body></html>";
  }
}
