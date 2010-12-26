package org.onebusaway.presentation.tags;

import javax.servlet.ServletContext;

import org.apache.struts2.dispatcher.Dispatcher;
import org.onebusaway.presentation.services.resources.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.inject.Container;
import com.opensymphony.xwork2.inject.Inject;

public class ResourceUrlFunction {

  private ResourceService _resourceService;

  @Inject(required = true)
  public void setServletContext(ServletContext servletContext) {

    WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
    context.getAutowireCapableBeanFactory().autowireBean(this);
  }

  @Autowired
  public void setResourceService(ResourceService resourceService) {
    _resourceService = resourceService;
  }

  public String getExternalUrlForResource(String resourcePath) {
    return _resourceService.getExternalUrlForResource(resourcePath);
  }

  public static String resource(String resourcePath) {
    Container container = Dispatcher.getInstance().getContainer();
    ResourceUrlFunction function = new ResourceUrlFunction();
    container.inject(function);
    return function.getExternalUrlForResource(resourcePath);
  }
}
