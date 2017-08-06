package com.camellia.rest.stub;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.google.common.base.Optional;
import com.google.common.collect.Iterators;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URI;
/**
 * Created by satish on 05/08/2017.
 */
public class JsonNodeUniSourceTest {

    @Test
    public void test() throws MalformedURLException {
        final WireMockServer server = new WireMockServer(0);
        server.start();
        final WireMock wireMock = new WireMock(server.port());


        wireMock.register(WireMock.get(WireMock.urlEqualTo("/configuration"))
                .willReturn(WireMock.aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json; charset=utf-8")
                        .withBody("{\"values\":[\"foo\",\"bar\"]}")));



        server.stop();
    }

}
