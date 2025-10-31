package com.edogawa.apiClients.configurations;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        OpenAPI info;
        info = new OpenAPI()
                .info(new Info()
                        .title("Edogawa Client Management API / エドガワクライアント管理API")
                        .version("1.0.0")
                        .description(
                                """
                                        Public API for client management, including creation, update, deletion, and listing of clients.
                                        This API is intended for testing, learning, and demonstration purposes.
                                        
                                        クライアントの登録、更新、削除、一覧取得を行うための公開APIです。
                                        このAPIは、学習、テスト、およびデモンストレーション目的で使用されます。
                                        """
                        )
                        .contact(new Contact()
                                .name("Edogawa Developer Team / 江戸川開発チーム")
                                .url("https://github.com/EdogawaCoder")
                                .email("edev.coderx@gmail.com")
                        )
                        .license(new License()
                                .name("Open License / オープンライセンス")
                                .url("https://opensource.org/licenses/MIT")
                        )
                );
        return info;
    }
}




