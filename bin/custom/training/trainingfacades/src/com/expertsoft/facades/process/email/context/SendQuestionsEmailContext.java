package com.expertsoft.facades.process.email.context;

import de.hybris.platform.acceleratorservices.model.cms2.pages.EmailPageModel;
import de.hybris.platform.commerceservices.model.process.StoreFrontCustomerProcessModel;

//TODO: fix it
public class SendQuestionsEmailContext extends CustomerEmailContext
{
    private String firstName;

//    @Override
//    public void init(final StoreFrontCustomerProcessModel processModel, final EmailPageModel emailPageModel)
//    {
//        super.init(processModel, emailPageModel);
//        if (processModel instanceof SendQuestionsEmailProcessModel)
//        {
//            setFirstName(((HelloWorldEmailProcessModel) processModel).getFirstName());
//        }
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}