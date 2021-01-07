package com.backbase.ct.bbfuel.client.accountstatement;

import com.backbase.ct.bbfuel.client.common.RestClient;
import com.backbase.ct.bbfuel.config.BbFuelConfiguration;
import com.backbase.ct.bbfuel.dto.accountStatement.EstatementPostRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AccountStatementsIntegrationMockServiceApiClient extends RestClient {

    private final BbFuelConfiguration config;


    private static final String SERVICE_VERSION ="v2";
    private static final String ENDPOINT_ACCOUNT_STATEMENT = "/account/statements/mock";

    @PostConstruct
    public void init() {
        setBaseUri(config.getDbs().getAccountStatement());
        setVersion(SERVICE_VERSION);
    }

    public Response createAccountStatements(List<EstatementPostRequestBody> requestBody) {
        return requestSpec()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(getPath(ENDPOINT_ACCOUNT_STATEMENT));
    }
}

