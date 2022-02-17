package com.expertsoft.jobs;

import com.expertsoft.model.QuestionModel;
import com.expertsoft.model.SendQuestionsEmailCronJobModel;
import com.expertsoft.model.SendQuestionsEmailProcessModel;
import com.expertsoft.services.QuestionService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.processengine.BusinessProcessService;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;

import java.util.Date;
import java.util.List;

public class SendQuestionsEmailJobPerformable extends AbstractJobPerformable<SendQuestionsEmailCronJobModel>
{
    private static final Logger LOG = Logger.getLogger(SendQuestionsEmailJobPerformable.class.getName());
    private static final String BUSINESS_PROCESS_NAME = "sendQuestionsEmailProcess";

    private QuestionService questionService;
    private ModelService modelService;
    private BusinessProcessService businessProcessService;

    public QuestionService getQuestionService()
    {
        return questionService;
    }

    @Required
    public void setQuestionService(QuestionService questionService)
    {
        this.questionService = questionService;
    }

    public ModelService getModelService()
    {
        return modelService;
    }

    @Override
    public PerformResult perform(SendQuestionsEmailCronJobModel cronJobModel)
    {
        List<QuestionModel> questions = questionService.getAllQuestions(cronJobModel.getLastExecution());
        LOG.info(String.format("%d questions found\n", questions.size()));

        if (questions.size() > 0) {
            generateBusinessProcess(questions);
        } else {
            LOG.info("No new questions added");
        }

        cronJobModel.setLastExecution(new Date());
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private void generateBusinessProcess(List<QuestionModel> questions) {
        LOG.info(String.format("Creating %s ...\n", BUSINESS_PROCESS_NAME));

        SendQuestionsEmailProcessModel process = getBusinessProcessService()
                .createProcess("sendQuestionsEmailProcess-" + System.currentTimeMillis(), BUSINESS_PROCESS_NAME);

        LOG.info(String.format("Initializing %s ...\n", BUSINESS_PROCESS_NAME));
        process.setQuestionList(questions);

        LOG.info(String.format("Saving %s ...\n", BUSINESS_PROCESS_NAME));
        getModelService().save(process);

        LOG.info(String.format("Staring %s ...\n", BUSINESS_PROCESS_NAME));
        getBusinessProcessService().startProcess(process);
    }

    @Required
    @Override
    public void setModelService(ModelService modelService)
    {
        this.modelService = modelService;
    }

    public BusinessProcessService getBusinessProcessService()
    {
        return businessProcessService;
    }

    @Required
    public void setBusinessProcessService(BusinessProcessService businessProcessService)
    {
        this.businessProcessService = businessProcessService;
    }

}