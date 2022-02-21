package com.expertsoft.services.impl;

import com.expertsoft.daos.QuestionDAO;
import com.expertsoft.model.QuestionModel;
import com.expertsoft.services.QuestionService;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;

public class DefaultQuestionService implements QuestionService
{
    private QuestionDAO questionDAO;

    public QuestionDAO getQuestionDAO()
    {
        return questionDAO;
    }

    @Required
    public void setQuestionDAO(QuestionDAO questionDAO)
    {
        this.questionDAO = questionDAO;
    }

    @Override
    public List<QuestionModel> getAllQuestions()
    {
        return questionDAO.findAll();
    }

    @Override
    public List<QuestionModel> getAllQuestions(Date date)
    {
        if (date == null) {
            return getAllQuestions();
        }

        return questionDAO.findAllFilteredByDate(date);
    }
}
