package com.readforce.passage.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.readforce.common.enums.LanguageEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long languageNo;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, columnDefinition = "varchar(255)")
	private LanguageEnum languageName;
	
	@CreatedDate
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;
	
	public void chageLanguageName(LanguageEnum languageName){
		
		this.languageName = languageName;
		
	}
}
