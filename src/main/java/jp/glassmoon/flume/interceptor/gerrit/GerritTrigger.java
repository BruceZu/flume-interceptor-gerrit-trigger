package jp.glassmoon.flume.interceptor.gerrit;

import org.apache.flume.interceptor.Interceptor;
import org.apache.flume.conf.Configurable;
import org.apache.flume.Event;
import org.apache.flume.Context;
import java.util.List;


public class GerritTrigger implements Interceptor {

  public void initialize() {
    return;
  }

  public void close() {
    return;
  }

  public Event intercept(Event event) {
    return event;
  }

  public List<Event> intercept(List<Event> events) {
    return events;
  }

  public static class Builder implements Interceptor.Builder, Configurable {

    public Interceptor build() {
      return null;
    }

    public void configure(Context context) {
      return;
    }
  }

  public static class Constants {
  }
}
