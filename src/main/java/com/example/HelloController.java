package com.example;

import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.Map;

@RestController
public class HelloController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello from Spring!";
  }

  @PostMapping("/hello")
  public String hello() {
    return "Posted!";
  }

  @PatchMapping("/hello")
  public String helloPatch() {
    return "Patched!";
  }

  @DeleteMapping("/hello")
  public String helloDelete() {
    return "Deleted!";
  }

  @GetMapping("/tv-shows")
  public String tvShow(@RequestParam String genre, @RequestParam String length) {
    return String.format("genre is %s and length is %s", genre, length);
  }

  @GetMapping("/pokemon")
  public String pokemon(@RequestParam Map queryString) {
    return String.format("type is %s and id is %s", queryString.get("type"), queryString.get("id"));
  }

  @GetMapping("/tasks")
  public String tasks(Tasks tasks) {
    return String.format("sort by %s, done is %s", tasks.getSortBy(), tasks.getDone().toString());
  }

  @PostMapping("/tv-shows/genre/{gen}/length/{len}")
  public String tvShowPath(@PathVariable("gen") String genre, @PathVariable("len") String length) {
    return String.format("genre is %s and length is %s", genre, length);
  }

  @PostMapping("/pokemon/type/{type}/id/{id}")
  public String pokemonPath(@PathVariable Map<String, String> pathString) {
    return String.format("type is %s and id is %s", pathString.get("type"), pathString.get("id"));
  }

  @PostMapping("/tasks/sortBy/{sortBy}/done/{done}")
  public String tasksPath(Tasks tasks) {
    return String.format("sort by %s, done is %s", tasks.getSortBy(), tasks.getDone().toString());
  }
}
