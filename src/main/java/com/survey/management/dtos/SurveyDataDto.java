package com.survey.management.dtos;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SurveyDataDto {

    private int age;
    private String gender;
    private String region;
    private String surveyID;
    private int score;
}
