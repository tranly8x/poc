/* 
* Use and distribution of this code is subject to applicable 
* licenses and the permission of the code owner. This notice 
* does not indicate the actual or intended publication of 
* this source code.
* 
* Portions developed for 101Digital by Software Development team
* LLC and are the property of 101Digital Inc.
* 
* ===== RP Modification ===========================================
* Req/Bug/Task ID#         MMddYYY    Author(s)    Description
* POC                      03282024   Ly Tran      Microservices Engineer Assessment Project v1.0
* ==================================================================
*/
package com.digital101.assessment.orderapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Orders API")
                .description("API to control clients, products and their orders.")
                .contact(new Contact()
                        .name("101Digital")
                        .email("digital101@gmail.com")
                        .url("https://www.101digital.io/"))
                .license(new License()
                        .name("101Digital All Right Reserved.")
                        .url("https://example.io/EXAMPLE"))
                .version("1.0");
    }

}