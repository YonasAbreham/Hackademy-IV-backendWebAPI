package io.orten.nano.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.orten.nano.impl.SwishImplementation;
import io.orten.nano.model.SwishPaymentRequestObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Map;

@Path("/nanoSwishAPI")
public class NanoSwishAPI {

    SwishImplementation api=new SwishImplementation();

    @POST
    @Path("/paymentRequest")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response paymentRequest(@QueryParam("payeePaymentReference")String payeePaymentReference,
                                   @QueryParam("amount")String amount

    ) throws IOException {
        String callbackUrl;// = "https://mss.swicpc.bankgirot.se/swish-cpcapi/api/v1/paymentrequests";
        callbackUrl = "https://mss.swicpc.bankgirot.se/swish-cpcapi/api/v1/paymentrequests";//"https://10.0.201.167:4200/home";
        String payeeAlies = "1231181189";
        String message="for donation";
        SwishPaymentRequestObject paymentRequestObject = new SwishPaymentRequestObject(payeePaymentReference, callbackUrl, payeeAlies, amount, message);
        Map swishResponse = api.sendPOST(paymentRequestObject);
        ObjectMapper objectMapper = new ObjectMapper();
        return Response.ok(swishResponse).build();
    }
}
