package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value = "/gb")

public class GuestbookController {
	
	@Autowired
	private GuestbookDao guestbookDao;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("리스트");

		List<GuestbookVo> guestbookList = guestbookDao.getgdList();

		model.addAttribute("gbList", guestbookList);

		return "list";
	}

	@RequestMapping("add")
	public String add(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("등록");
		System.out.println(guestbookVo);

		guestbookDao.gbInsert(guestbookVo);

		return "redirect:/gb/list";
	}
	
	
	@RequestMapping("deleteForm")
	public String deleteForm() {
		System.out.println("삭제 폼");
		
		return "deleteForm";
	}
	
	@RequestMapping("delete")
	public String delete(@RequestParam("no") int no, @RequestParam("password") String pw) {
		System.out.println("삭제");

		int ex = guestbookDao.gbDelete(no, pw);

		if (ex == 1) { // 삭제 성공
			return "redirect:/gb/list";
		} else { // 삭제 실패
			return "passwordcheck";
		}

	}
	
	
	
	
}
