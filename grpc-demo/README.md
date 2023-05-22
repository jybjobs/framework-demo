# grpc-demo

## 1. grpc基本步骤：
* 使用 protobuf 定义 grpc service、request 和 response type。
* 使用 protobuf compiler 生成 server 和 client 相关代码。
* 创建 server 应用，实现 service 接口，创建 grpc server。
* 创建 client 应用，使用生成的 stub 进行 rpc 调用。
