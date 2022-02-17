package com.expertsoft.facades.process.email.context;

import com.expertsoft.model.QuestionModel;
import com.expertsoft.model.SendQuestionsEmailProcessModel;
import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;

import java.util.List;

public class SendQuestionsEmailContext extends CustomerEmailContext
{
    private List<QuestionModel> questions;

    @Override
    public void init(final StoreFrontCustomerProcessModel processModel, final EmailPageModel emailPageModel)
    {
        super.init(processModel, emailPageModel);
        if (processModel instanceof SendQuestionsEmailProcessModel)
        {
            setQuestions(((SendQuestionsEmailProcessModel) processModel).getQuestionList());
        }
    }

    public List<QuestionModel> getQuestions()
    {
        return questions;
    }

    public void setQuestions(List<QuestionModel> questions)
    {
        this.questions = questions;
    }
}