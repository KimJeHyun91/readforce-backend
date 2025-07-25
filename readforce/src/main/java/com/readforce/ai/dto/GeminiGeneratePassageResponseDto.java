package com.readforce.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GeminiGeneratePassageResponseDto {

	private String title;
	
	private String content;
	
}
