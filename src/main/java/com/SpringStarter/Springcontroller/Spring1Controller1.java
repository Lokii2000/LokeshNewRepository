package com.SpringStarter.Springcontroller;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/nextpath")
public class Spring1Controller1 {
	@GetMapping(value="/Stringpath")
	public String getStringvalue() {
		return "loki";
	}
	@GetMapping(value = "/HeathReturn")
	public Builder health1() {
		return(Health.up());
	}

}
