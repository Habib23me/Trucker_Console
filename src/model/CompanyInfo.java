package model;

import java.util.Calendar;

public class CompanyInfo {
    public enum Options{
        Slow,
        Regular,
        Urgent,
    }
    private PricingOption[] pricingOptions;
    private String companyName;
    private int companyId;
    private String description;
    private Calendar deliveryDate;
    private float pricing;
    private float customerSatisfaction;
    private int numberOfDeliveries;

    public CompanyInfo(String companyName, int companyId, String description, Calendar deliveryDate, float pricing, float customerSatisfaction, int numberOfDeliveries) {
        this.companyName = companyName;
        this.companyId = companyId;
        this.description = description;
        this.deliveryDate = deliveryDate;
        this.pricing = pricing;
        this.customerSatisfaction = customerSatisfaction;
        this.numberOfDeliveries = numberOfDeliveries;
    }

    public void setPricingOptions(PricingOption[] pricingOptions) {
        if(pricingOptions.length==Options.values().length)
        this.pricingOptions = pricingOptions;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public String getDescription() {
        return description;
    }

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public float getPricing() {
        return pricing;
    }

    public float getCustomerSatisfaction() {
        return customerSatisfaction;
    }

    public int getNumberOfDeliveries() {
        return numberOfDeliveries;
    }


    public static class PricingOption{
        private Options option;
        private float price;
        private Calendar arrivalDate;

        public PricingOption(Options option, float price, Calendar arrivalDate) {
            this.option = option;
            this.price = price;
            this.arrivalDate = arrivalDate;
        }

        public Options getOption() {
            return option;
        }

        public float getPrice() {
            return price;
        }

        public Calendar getArrivalDate() {
            return arrivalDate;
        }
    }
}
