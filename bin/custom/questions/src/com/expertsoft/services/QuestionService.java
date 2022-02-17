package com.expertsoft.services;

import com.expertsoft.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionService
{
    List<QuestionModel> getAllQuestions();
    List<QuestionModel> getAllQuestions(Date date);
}
