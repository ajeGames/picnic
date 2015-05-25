package com.ajegames.picnic.service;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * Created by AJE Games by bigdaddy on 4/28/13 at 9:02 AM.
 */
public class PicnicService extends Service<PicnicConfiguration> {
  public static void main(String[] args) throws Exception {
    new PicnicService().run(args);
  }

  @Override
  public void initialize(Bootstrap<PicnicConfiguration> bootstrap) {
    bootstrap.setName("picnic");
  }

  @Override
  public void run(PicnicConfiguration configuration, Environment environment) {

  }
}
