package m2i.cinema.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import m2i.cinema.bo.service.LanguageVersion;
import m2i.cinema.controller.generic.CrudController;

@RestController @RequestMapping("/language")
public class LanguageVersionController extends CrudController<LanguageVersion> {}