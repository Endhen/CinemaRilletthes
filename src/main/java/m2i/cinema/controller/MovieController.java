package m2i.cinema.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.cinema.controller.generic.CrudController;
import m2i.cinema.entity.service.Movie;

@RestController @RequestMapping("/movie")
public class MovieController extends CrudController<Movie> {}