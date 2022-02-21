package com.expertsoft.daos.impl;

import com.expertsoft.daos.QuestionDAO;
import com.expertsoft.model.QuestionModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "questionDAO")
public class DefaultQuestionDAO implements QuestionDAO
{
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<QuestionModel> findAll()
    {
        final String queryString =
                "SELECT {p:" + QuestionModel.PK + "} " +
                "FROM {" + QuestionModel._TYPECODE + " AS p} ";

        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<QuestionModel> search(query).getResult();
    }

    @Override
    public List<QuestionModel> findAllFilteredByDate(Date date)
    {
        final Map<String, Object> params = new HashMap<>();

        String query =
                "SELECT {" + QuestionModel.PK + "} " +
                "FROM {" + QuestionModel._TYPECODE + " AS q} " +
                "WHERE {q." + QuestionModel.CREATIONTIME + "} > ?date";

        params.put("date", date);

        final SearchResult<QuestionModel> result = flexibleSearchService.search(query, params);
        return result.getResult();
    }
}
