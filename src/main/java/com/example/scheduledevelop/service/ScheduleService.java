package com.example.scheduledevelop.service;

import com.example.scheduledevelop.dto.ScheduleRequestDto;
import com.example.scheduledevelop.dto.ScheduleResponseDto;
import com.example.scheduledevelop.dto.UserResponseDto;
import com.example.scheduledevelop.entity.Schedule;
import com.example.scheduledevelop.entity.User;
import com.example.scheduledevelop.repository.ScheduleRepository;
import com.example.scheduledevelop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto dto){
        User user = userRepository.findById(dto.getUserId()).orElseThrow(()-> new IllegalArgumentException("유저를 찾을 수 없습니다"));

        Schedule schedule = new Schedule(user, dto.getTitle(), dto.getTodo());
        Schedule saveSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(saveSchedule.getId(), new UserResponseDto(user.getId()), saveSchedule.getTitle(), saveSchedule.getTodo());
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll(){
        List<Schedule> schedules = scheduleRepository.findAll();

        List<ScheduleResponseDto> dtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            ScheduleResponseDto dto = new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getTodo());
            UserResponseDto userDto = new UserResponseDto(schedule.getUser().getId());
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
        return new ScheduleResponseDto(schedule.getId(), new UserResponseDto(schedule.getUser().getId()), schedule.getTitle(), schedule.getTodo());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, ScheduleRequestDto dto){
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("작성된 일정이 없습니다!")
        );
        schedule.update(dto.getTitle(),dto.getTodo());
        return new ScheduleResponseDto(schedule.getId(), new UserResponseDto(schedule.getUser().getId()), schedule.getTitle(), schedule.getTodo());
    }

    @Transactional
    public void deleteById(Long id){
        if(!scheduleRepository.existsById(id)){
            throw new IllegalArgumentException("작성된 일정이 없습니다!");
        }
        scheduleRepository.deleteById(id);
    }
}
