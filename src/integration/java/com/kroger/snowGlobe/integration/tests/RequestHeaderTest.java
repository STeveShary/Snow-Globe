/*
 * Nginx Snow Globe
 *
 * Copyright 2017 The Kroger Co.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kroger.snowGlobe.integration.tests;

import com.kroger.dcp.snowGlobe.AppServiceCluster;
import com.kroger.dcp.snowGlobe.NginxRpBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.kroger.dcp.snowGlobe.AppServiceCluster.makeHttpsWebService;
import static com.kroger.dcp.snowGlobe.NginxRpBuilder.startNginxRpWithCluster;
import static com.kroger.dcp.snowGlobe.call.CallUtility.make;
import static com.kroger.dcp.snowGlobe.call.TestRequest.getRequest;

/**
 * This integration test verifies that the path that was sent on the upstream path works correctly for an example setup.
 * The snow globe configuration is located at the root of the project in "snow-globe.yaml".  The yaml file references
 * the example configuration in the "src/integrationTestNginxConfig"
 */
public class RequestHeaderTest {

    public static NginxRpBuilder nginxReverseProxy;
    public static AppServiceCluster loginUpstreamApp = makeHttpsWebService("Login_Cluster", 1);

    @BeforeClass
    public static void setup() {
        nginxReverseProxy = startNginxRpWithCluster(loginUpstreamApp);
    }

    @AfterClass
    public static void teardown() {
        nginxReverseProxy.stop();
    }

    @Test
    public void should_add_x_proto_header_to_login_request() {
        make(getRequest("https://www.nginx-test.com/login")
                .to(nginxReverseProxy))
                .andExpectRequestHeaderToApplicationMatching("x-forwarded-proto", "https")
                .andExpectRequestHeaderToApplicationMatching("host", "www.nginx-test.com");
    }
}