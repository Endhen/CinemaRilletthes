package m2i.cinema.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.cinema.controller.generic.CrudController;
import m2i.cinema.entity.service.LanguageVersion;

@RestController() @RequestMapping("/language")
public class LanguageVersionController extends CrudController<LanguageVersion> {}