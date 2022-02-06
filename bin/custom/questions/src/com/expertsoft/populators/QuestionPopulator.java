package com.expertsoft.populators;

import com.expertsoft.data.QuestionData;
import com.expertsoft.model.QuestionModel;
import de.hybris.platform.converters.Populator;
import de.hybris.platform.core.model.security.PrincipalModel;
import de.hybris.platform.servicelayer.dto.converter.ConversionException;

import java.util.Optional;

public class QuestionPopulator implements Populator<QuestionModel, QuestionData>
{
    @Override
    public void populate(QuestionModel source, QuestionData target) throws ConversionException
    {
        final String id = source.getCode();
        final String question = source.getQuestion();
        final String questionCustomer = source.getQuestionCustomer().getName();
        final String answer = Optional.ofNullable(source.getAnswer()).orElse(null);
        final String answerCustomer = Optional.ofNullable(source.getAnswerCustomer()).map(PrincipalModel::getName).orElse(null);

        target.setId(id);
        target.setQuestion(question);
        target.setQuestionCustomer(questionCustomer);
        target.setAnswer(answer);
        target.setAnswerCustomer(answerCustomer);
    }
}
