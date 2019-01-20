package view;

import controller.StateNavigator;
import model.CompanyInfo;
import model.DeliveryInfo;
import util.Display;
import util.Input;

public class NewDeliveryRequestScreen implements Screen{
    int stateIndex=0;
    private StateNavigator stateNavigator= new StateNavigator();
    private DeliveryInfo deliveryInfo;



    @Override
    public void build() {
        stateNavigator.init(this::getDeliveryRequestInfo);
        getDeliveryRequestInfo();
    }

    public void getDeliveryRequestInfo(){
        deliveryInfo= Input.getDeliveryInfo();
        stateIndex++;
        stateNavigator.to(this::selectFreightForwardingCompany);
    }
    public void selectFreightForwardingCompany(){
        deliveryInfo.setSelectedCompanyId(Input.getCompanyId());
        stateIndex++;
        stateNavigator.to(this::selectPricingPoint);
    }

    public void selectPricingPoint(){
        deliveryInfo.setSelectedPricingOptions(Input.getPricing());
        stateIndex++;
        stateNavigator.to(this::confirmRequest);
    }

    public void confirmRequest(){
        boolean confirm=Input.confirmDeliveryInfo(deliveryInfo);

    }




}
