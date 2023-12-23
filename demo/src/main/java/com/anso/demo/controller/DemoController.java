package com.anso.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anso.demo.dto.StreamResponse;
import com.anso.demo.service.DemoService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class DemoController {

	private final DemoService demoService;

	@GetMapping("/demo/stream")
	public StreamResponse getListByStream() {
		return demoService.getListByStream();
	}

	@GetMapping("/demo/for-loop")
	public StreamResponse getListByForLoop() {
		return demoService.getListByForLoop();
	}

	@GetMapping("/demo/query")
	public StreamResponse getListByQuery() {
		return demoService.getListByQuery();
	}
}