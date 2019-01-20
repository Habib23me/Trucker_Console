package model;

import java.util.Calendar;

public class DeliveryInfo {
   public enum WeightClass{
        class_1("100-200"),
        class_2("200-500"),
        class_3("500-1000");
       private  final String name;

       WeightClass(String s) {
           this.name = s;
       }

        @Override
        public String toString() {
            return this.name;
        }
    }
    private String productName;
    private int amount;
    private WeightClass weightClass;
    private ContactInfo.City from;
    private ContactInfo.City to;
    private Calendar departureDate;
    private int selectedCompanyId;
    private CompanyInfo.Options selectedPricingOptions;

    public DeliveryInfo(String productName, int amount, WeightClass weightClass, ContactInfo.City from, ContactInfo.City to, Calendar deparutureDate) {
        this.productName = productName;
        this.amount = amount;
        this.weightClass = weightClass;
        this.from = from;
        this.to = to;
        this.departureDate = deparutureDate;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmount() {
        return amount;
    }

    public WeightClass getWeightClass() {
        return weightClass;
    }

    public ContactInfo.City getInitalLocation() {
        return from;
    }

    public ContactInfo.City getFinalLocation() {
        return to;
    }

    public Calendar getDepartureDate() {
        return departureDate;
    }

    public int getSelectedCompanyId() {
        return selectedCompanyId;
    }

    public void setSelectedCompanyId(int selectedCompanyId) {
        this.selectedCompanyId = selectedCompanyId;
    }

    public CompanyInfo.Options getSelectedPricingOptions() {
        return selectedPricingOptions;
    }

    public void setSelectedPricingOptions(CompanyInfo.Options selectedPricingOptions) {
        this.selectedPricingOptions = selectedPricingOptions;
    }
}
