package myapp.security;

public interface Sanitizer<T> {
  T sanitize(T t);
}
