package com.example.scheduledevelop.controller;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody ScheduleRequestDto dto){
        return new ResponseEntity<>(scheduleService.save(dto), HttpStatus.CREATED);
    }

    @GetMapping("/schedules/{userId}")
    public ResponseEntity<List<ScheduleResponseDto>> findAll(@PathVariable Long userId){
        return new ResponseEntity<>(scheduleService.findAll(userId), HttpStatus.OK);
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> findOne(@PathVariable Long id){
        return new ResponseEntity<>(scheduleService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponseDto> update(@PathVariable Long id, @RequestBody ScheduleRequestDto dto){
        return new ResponseEntity<>(scheduleService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/schedules/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
