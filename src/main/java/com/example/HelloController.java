package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaPrintableArea;
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

  @GetMapping("/tv-shows/genre/{gen}/length/{len}")
  public String tvShowPath(@PathVariable("gen") String genre, @PathVariable("len") String length) {
    return String.format("genre is %s and length is %s", genre, length);
  }

  @GetMapping("/pokemon/type/{type}/id/{id}")
  public String pokemonPath(@PathVariable Map<String, String> pathString) {
    return String.format("type is %s and id is %s", pathString.get("type"), pathString.get("id"));
  }

  @GetMapping("/tasks/sortBy/{sortBy}/done/{done}")
  public String tasksPath(Tasks tasks) {
    return String.format("sort by %s, done is %s", tasks.getSortBy(), tasks.getDone().toString());
  }

  @PostMapping(path = "/tv-shows")
  public String tvShowForm(@RequestBody String rawbody) {
    return rawbody;
  }

  @PostMapping(value = "/pokemon", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String pokemonForm(@RequestParam Map<String, String> body) {
    return String.format("type is %s and id is %s", body.get("type"), body.get("id"));
  }

  @PostMapping(value = "/tasks", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  public String tasksForm(Tasks tasks) {
    return String.format("sort by %s, done is %s", tasks.getSortBy(), tasks.getDone().toString());
  }

  @PostMapping(path = "/js/object")
  public String pokemonParse(@RequestBody Pokemon pokemon) {
    return String.format("My name is %s, with id of %d, weight of %d, and types of %s and %s",
            pokemon.getName(), pokemon.getId(), pokemon.getWeight(),
            pokemon.getTypes()[0].getType().getName(),
            pokemon.getTypes()[1].getType().getName());
  }
}
