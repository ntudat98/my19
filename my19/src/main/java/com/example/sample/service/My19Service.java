package myapp.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor
@Slf4j
public class My19Service {

  public String buildMessage(String name) {
    return "Hello " + name + ". This is a sample spring boot template project.";
  }


}
