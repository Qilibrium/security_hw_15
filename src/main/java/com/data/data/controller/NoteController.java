package com.data.data.controller;

import com.data.data.note.Note;
import com.data.data.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@RequestMapping("/note")
@RestController
public class NoteController {

  private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getListOfNotes(){
        ModelAndView result = new ModelAndView("notes");
        result.addObject("noteList", noteService.listAll());
        return result;
    }
    @PostMapping("/delete")
    public RedirectView deleteNote(@RequestParam long id){
        noteService.deleteById(id);
        return new RedirectView("/note/list");
    }
    @GetMapping("/edit")
    public ModelAndView editNote(@RequestParam Long id){
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", noteService.getById(id));
        return result;
    }
    @PostMapping("/edit")
    public RedirectView editNote(@RequestParam long id, @RequestParam String title, @RequestParam String content){
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.update(note);
        return new RedirectView("/note/list");
    }
    @GetMapping("/add")
    public ModelAndView addNote(){
        ModelAndView result = new ModelAndView("edit");
        result.addObject("note", null);
        return result;
    }
    @PostMapping("/add")
    public RedirectView addNote( @RequestParam String title, @RequestParam String content){
        Note note = new Note();
        note.setId(uniId());
        note.setTitle(title);
        note.setContent(content);
        noteService.add(note);
        return new RedirectView("/note/list");
    }
    public static long uniId() {
        long a =  ( long ) (Math.random() * Math.abs(90000000099999999L));
        long b = 1;
        return a*b;

    }

}
