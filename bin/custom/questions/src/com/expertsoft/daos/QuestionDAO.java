package com.expertsoft.daos;

import com.expertsoft.model.QuestionModel;

import java.util.Date;
import java.util.List;

public interface QuestionDAO
{
    List<QuestionModel> findAll();
    List<QuestionModel> findAllFilteredByDate(Date date);
}
