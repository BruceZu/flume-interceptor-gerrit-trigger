package jp.glassmoon.flume.interceptor.gerrit;

import org.apache.flume.interceptor.Interceptor;
import org.apache.flume.Event;
import org.apache.flume.Context;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import static jp.glassmoon.flume.interceptor.gerrit.GerritTrigger.Constants.*;

public class GerritTrigger implements Interceptor {

  private final Map<String, String> headers;

  private GerritTrigger(String name, String host, String scheme, int port, String frontUrl, String version) {
    Map<String, String> m = new HashMap<String, String>();
    m.put(HEADER_NAME, name);
    m.put(HEADER_HOST, host);
    m.put(HEADER_SCHEME, scheme);
    m.put(HEADER_PORT, String.valueOf(port));
    m.put(HEADER_FRONTURL, frontUrl);
    m.put(HEADER_VERSION, version);
    this.headers = m;
  }

  @Override
  public void initialize() {
    // no-op
  }

  @Override
  public void close() {
    // no-op
  }

  @Override
  public Event intercept(Event event) {
    event.getHeaders().putAll(headers);
    return event;
  }

  @Override
  public List<Event> intercept(List<Event> events) {
    for (Event event : events) {
      intercept(event);
    }
    return events;
  }

  public static class Builder implements Interceptor.Builder {

    private String name = DEFAULT_NAME;
    private String host = DEFAULT_HOST;
    private String scheme = DEFAULT_SCHEME;
    private int port = DEFAULT_PORT;
    private String frontUrl = DEFAULT_FRONTURL;
    private String version = DEFAULT_VERSION;

    @Override
    public Interceptor build() {
      return new GerritTrigger(name, host, scheme, port, frontUrl, version);
    }

    @Override
    public void configure(Context context) {
      name = context.getString(NAME, DEFAULT_NAME);
      host = context.getString(HOST, DEFAULT_HOST);
      scheme = context.getString(SCHEME, DEFAULT_SCHEME);
      port = context.getInteger(PORT, DEFAULT_PORT);
      frontUrl = context.getString(FRONTURL, DEFAULT_FRONTURL);
      version = context.getString(VERSION, DEFAULT_VERSION);
    }
  }

  public static class Constants {
    public static final String NAME = "name";
    public static final String HOST = "host";
    public static final String SCHEME = "scheme";
    public static final String PORT = "port";
    public static final String FRONTURL = "fronturl";
    public static final String VERSION = "version";

    public static final String DEFAULT_NAME = "gerrit";
    public static final String DEFAULT_HOST = "localhost";
    public static final String DEFAULT_SCHEME = "ssh";
    public static final int DEFAULT_PORT = 29418;
    public static final String DEFAULT_FRONTURL = "http://localhost/";
    public static final String DEFAULT_VERSION = "2.8";

    public static final String HEADER_NAME = "geerit-name";
    public static final String HEADER_HOST = "gerrit-host";
    public static final String HEADER_SCHEME = "gerrit-scheme";
    public static final String HEADER_PORT = "gerrit-port";
    public static final String HEADER_FRONTURL = "gerrit-front-url";
    public static final String HEADER_VERSION = "gerrit-version";
  }
}
