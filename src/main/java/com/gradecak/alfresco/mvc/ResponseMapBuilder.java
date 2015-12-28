package com.gradecak.alfresco.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class ResponseMapBuilder extends HashMap<String, Object> {

  public ResponseMapBuilder withData(final Object data) {

    int size = 1;
    if (data != null) {
      if (data instanceof List<?>) {
        size = ((List<?>) data).size();
      }
    }
    
    return withEntry("data", data).withEntry("total", size);
  }

  public ResponseMapBuilder withSuccess(final boolean success) {
    return withEntry("success", success);    
  }

  public ResponseMapBuilder withConfig(final Map<String, Object> config) {
    return withEntry("config", config);
  }

  public ResponseMapBuilder withEntry(final String key, final Object value) {
    put(key, value);
    return this;
  }

  static public ResponseMapBuilder createSuccessResponseMap() {
    return createResponseMap(null, true);
  }

  static public ResponseMapBuilder createFailResponseMap() {
    return createResponseMap(null, false);
  }

  static public ResponseMapBuilder createResponseMap(final Object data, final boolean success) {
    return new ResponseMapBuilder().withData(data).withSuccess(success);
  }
}