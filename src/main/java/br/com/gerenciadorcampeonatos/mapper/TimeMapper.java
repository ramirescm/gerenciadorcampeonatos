package br.com.gerenciadorcampeonatos.mapper;

import java.util.LinkedList;
import java.util.List;

import br.com.gerenciadorcampeonatos.dto.TimeDTO;
import br.com.gerenciadorcampeonatos.modelo.Time;

public class TimeMapper {
	public static List<TimeDTO> toDTO(List<Time> Times) {
		List<TimeDTO> dtos = new LinkedList<>();
		for (Time Time : Times) {
			dtos.add(toDTO(Time));
		}
		return dtos;
	}

	public static TimeDTO toDTO(Time time) {
		TimeDTO dto = new TimeDTO();
		dto.setId(time.getId());
		dto.setNome(time.getNome());
		return dto;
	}

	public static Time fromDTO(TimeDTO dto) {
		Time time = new Time();
		time.setId(dto.getId());
		time.setNome(dto.getNome());
		return time;
	}
	
	public static Time toEntity(Time time, TimeDTO dto) {
		time.setId(dto.getId());
		time.setNome(dto.getNome());
		return time;
	}
}
