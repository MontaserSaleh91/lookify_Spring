package com.project.lookify.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.lookify.models.Song;
import com.project.lookify.services.LookifyService;

@Controller
@RequestMapping("/")
public class LookifyController {
	private final LookifyService lookifyService;
	public LookifyController(LookifyService lookifyService) {
		this.lookifyService = lookifyService;
	}

	
	@RequestMapping("")
	public String home(HttpSession session) {
		session.setAttribute("searchitem", null);
		return "index.jsp";
	}

	
	@RequestMapping("/dashboard")
	public String displayDash(Model model, HttpSession session) {
		List<Song> songs = lookifyService.getAll();
		if(session.getAttribute("searchitem") != null) {
			List<Song> searchsongs = new ArrayList<Song>();
			for(int i = 0; i< songs.size(); i++) {
				Song song = songs.get(i);
				if(song.getArtist().toLowerCase().contains((String) session.getAttribute("searchitem"))){
					searchsongs.add(song);
				}
			}
			model.addAttribute("songs", searchsongs);
			return "dashboard.jsp";
		} else {
			model.addAttribute("songs", songs);
			return "dashboard.jsp";
		}
	}

	
	@RequestMapping("/create")
	public String showForm(@ModelAttribute("song") Song song) {
		return "create.jsp";
	}
	
	@PostMapping("/create")
	public String addSong(@Valid @ModelAttribute("song") Song song, BindingResult result, RedirectAttributes flash) {
		if(result.hasErrors()) {
			flash.addFlashAttribute("errs",result.getAllErrors());
			return "redirect:/create";
		}
		lookifyService.addSong(song);
		return "redirect:/dashboard";
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteSong(@PathVariable Long id) {
		lookifyService.deleteSong(id);
		return "redirect:/dashboard";
	}
	
	@RequestMapping(path="/search", method=RequestMethod.POST)
	public String search(@RequestParam(value="search") String search, HttpSession session) {
		session.setAttribute("searchitem", search);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("/reset")
	public String resetSearch(HttpSession session) {
		session.setAttribute("searchitem", null);
		return "redirect:/dashboard";
	}
	
	@RequestMapping("songs/{id}")
	public String showSong(@PathVariable Long id, Model model) {
		Optional<Song> song = lookifyService.getOne(id);
		model.addAttribute("song", song);
		return "song.jsp";
	}
	
	@RequestMapping("/top")
	public String displayTop(Model model) {
		model.addAttribute("songs", lookifyService.topTen());
		return "topTen.jsp";
	}
}
