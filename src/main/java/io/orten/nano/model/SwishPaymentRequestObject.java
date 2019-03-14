package io.orten.nano.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SwishPaymentRequestObject {
    private static final Integer MIN_AMOUNT = 1;
    private static final Integer MAX_AMOUNT = 999999999;
    private static final String  Fixed_Currency="SEK";

    private String payeePaymentReference;
    private String callbackUrl;

    private String payeeAlias;
    private String amount;

    private String message;

    public SwishPaymentRequestObject(String payeePaymentReference, String callbackUrl, String payeeAlias, String amount, String message) {
        this.payeePaymentReference = payeePaymentReference;
        this.callbackUrl = callbackUrl;
        this.payeeAlias = payeeAlias;

        Integer iAmount = Integer.parseInt(amount);
        if (iAmount < MIN_AMOUNT.intValue()) {
            this.amount = MIN_AMOUNT.toString();
        } else if(iAmount > MAX_AMOUNT.intValue()) {
            this.amount = MAX_AMOUNT.toString();
        } else{
            this.amount = iAmount.toString();
        }

        this.message = message;
    }

    @JsonProperty("payeePaymentReference")
    public String getPayeePaymentReference() {
        return payeePaymentReference;
    }
    public void setPayeePaymentReference(String payeePaymentReference) { this.payeePaymentReference = payeePaymentReference; }

    @JsonProperty("callbackUrl")
    public String getCallbackUrl() {
        return callbackUrl;
    }


    @JsonProperty("payeeAlias")
    public String getPayeeAlias() {
        return payeeAlias;
    }


    @JsonProperty("amount")
    public String getAmount() {
        return amount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return Fixed_Currency;
    }


    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

}
