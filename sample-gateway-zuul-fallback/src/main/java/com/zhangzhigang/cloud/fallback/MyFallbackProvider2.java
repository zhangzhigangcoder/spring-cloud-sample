package com.zhangzhigang.cloud.fallback;

/**
 * 高版本中ZuulFallbackProvider被弃用，用FallbackProvider代替
 * @author zhangzhigang
 *
 */
public class MyFallbackProvider2 
//implements ZuulFallbackProvider 
{
//	
//	@Override
//    public String getRoute() {
//		//此处配置代理的服务application name,如果要为所有的服务配置默认的的fallback，此处用"*"
//        return "microservice-consumer-user";
//    }
//	
//    @Override
//    public ClientHttpResponse fallbackResponse() {
//        return new ClientHttpResponse() {
//            @Override
//            public HttpStatus getStatusCode() throws IOException {
//                return HttpStatus.BAD_REQUEST;
//            }
//
//            @Override
//            public int getRawStatusCode() throws IOException {
//                return HttpStatus.BAD_REQUEST.value();
//            }
//
//            @Override
//            public String getStatusText() throws IOException {
//                return HttpStatus.BAD_REQUEST.getReasonPhrase();
//            }
//
//            @Override
//            public void close() {
//
//            }
//
//            /**
//             * 调用异常时，默认返回数据
//             */
//            @Override
//            public InputStream getBody() throws IOException {
//                return new ByteArrayInputStream("fallback".getBytes());
//            }
//
//            @Override
//            public HttpHeaders getHeaders() {
//                HttpHeaders headers = new HttpHeaders();
//                headers.setContentType(MediaType.APPLICATION_JSON);
//                return headers;
//            }
//        };
//    }

}