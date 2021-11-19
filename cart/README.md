# 這是一個簡單購物車範例

以 Axon 實作 DDD 設計

## 外部資源

需啟動 reference/docker/docker-compose.yml

``` bash
docker-compose -f reference/docker/docker-compose.yml up -d
```

[AxonDashboard](http://localhost:8024/)  

add .openapi-generator-ignore


./gradlew openApiGenerate

Controller 要加 @Api(tags = { "Cart" })

## 資料庫
