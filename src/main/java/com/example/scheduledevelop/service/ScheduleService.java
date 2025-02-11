package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto){
        Schedule schedule = new Schedule(dto.getUserId(),dto.getTitle(), dto.getTodo());
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule.getId(), saveSchedule.getUserId(),saveSchedule.getTitle(), saveSchedule.getTodo(), saveSchedule.getCreatedAt(), saveSchedule.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll(Long userId){
        List<Schedule> schedules = scheduleRepository.findByUserId(userId);

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getTodo(), schedule.getCreatedAt(), schedule.getUpdatedAt());
            dtos.add(dto);
        }
        // 빠른 for문 생성 schedules.for + tab키
        return dtos;
    }

    @Transactional(readOnly = true)
    public ScheduleResponseDto findById(Long id){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("작성된 일정이 없습니다!")
        );
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getTodo(), schedule.getUpdatedAt());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("작성된 일정이 없습니다!")
        );
        schedule.update(dto.getUserId(), dto.getTitle(),dto.getTodo(), dto.getUpdatedAt());
        return new ScheduleResponseDto(schedule.getId(), schedule.getUserId(), schedule.getTitle(), schedule.getTodo(), schedule.getUpdatedAt());
    }

    @Transactional
    public void deleteById(Long id){
        if(!scheduleRepository.existsById(id)){
            throw new IllegalArgumentException("작성된 일정이 없습니다!");
        }
        scheduleRepository.deleteById(id);
    }
}
