/*     */ package nencer.app.Utils;
/*     */ 
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Collections;
/*     */ import javax.net.ssl.HostnameVerifier;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.http.client.HttpClient;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.config.Registry;
/*     */ import org.apache.http.config.RegistryBuilder;
/*     */ import org.apache.http.conn.HttpClientConnectionManager;
/*     */ import org.apache.http.conn.socket.ConnectionSocketFactory;
/*     */ import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
/*     */ import org.apache.http.conn.socket.PlainConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.NoopHostnameVerifier;
/*     */ import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
/*     */ import org.apache.http.conn.ssl.TrustStrategy;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClients;
/*     */ import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
/*     */ import org.apache.http.ssl.SSLContexts;
/*     */ import org.apache.http.ssl.TrustStrategy;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpEntity;
/*     */ import org.springframework.http.HttpHeaders;
/*     */ import org.springframework.http.MediaType;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.http.client.ClientHttpRequestFactory;
/*     */ import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
/*     */ import org.springframework.stereotype.Component;
/*     */ import org.springframework.util.MultiValueMap;
/*     */ import org.springframework.web.client.RestClientException;
/*     */ import org.springframework.web.client.RestTemplate;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class MSClientUtil
/*     */ {
/*  65 */   private final Logger logger = LoggerFactory.getLogger(MSClientUtil.class);
/*     */ 
/*     */   
/*     */   @Autowired
/*     */   LogUtils logUtils;
/*     */ 
/*     */   
/*     */   public String callRestAPISync(String prefixLog, String apiReq, String uri) throws EISException {
/*  73 */     int apiTimeout = 60;
/*  74 */     RestTemplate restTemplate = new RestTemplate();
/*  75 */     SSLContext sslContext = null;
/*     */     try {
/*  77 */       TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
/*  78 */       sslContext = SSLContexts.custom().loadTrustMaterial(null, (TrustStrategy)acceptingTrustStrategy).build();
/*  79 */     } catch (Exception exception) {
/*  80 */       this.logger.error("{}[{}]SSLContexts:{}", new Object[] { prefixLog, uri, exception });
/*     */     } 
/*  82 */     SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, (HostnameVerifier)NoopHostnameVerifier.INSTANCE);
/*     */ 
/*     */     
/*  85 */     Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.create().register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
/*     */     
/*  87 */     BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager((Lookup)socketFactoryRegistry);
/*     */ 
/*     */     
/*  90 */     CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory((LayeredConnectionSocketFactory)sslsf).setConnectionManager((HttpClientConnectionManager)connectionManager).build();
/*     */     
/*  92 */     HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory((HttpClient)httpClient);
/*     */     
/*  94 */     clientHttpRequestFactory.setConnectTimeout(apiTimeout * 1000);
/*  95 */     clientHttpRequestFactory.setReadTimeout(apiTimeout * 1000);
/*  96 */     restTemplate.setRequestFactory((ClientHttpRequestFactory)clientHttpRequestFactory);
/*  97 */     HttpHeaders headers = new HttpHeaders();
/*  98 */     headers.setContentType(MediaType.APPLICATION_JSON);
/*  99 */     headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
/* 100 */     this.logger.info("{}[{}]{}", new Object[] { prefixLog, uri, this.logUtils.logRequest(apiReq) });
/*     */     
/* 102 */     HttpEntity<String> e = new HttpEntity(apiReq, (MultiValueMap)headers);
/* 103 */     ResponseEntity<String> result = null;
/*     */     try {
/* 105 */       result = restTemplate.postForEntity(uri, e, String.class, new Object[0]);
/* 106 */     } catch (RestClientException restEx) {
/* 107 */       throw new EISException("callRestAPISync_" + prefixLog, restEx);
/*     */     } 
/* 109 */     String responseGetReqID = (String)result.getBody();
/* 110 */     this.logger.info("{}[{}]{}", new Object[] { prefixLog, uri, this.logUtils.logRequest(responseGetReqID) });
/*     */     
/* 112 */     return responseGetReqID;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String callSOAPAPISync(String prefixLog, String req, String uri) throws EISException {
/* 118 */     int apiTimeout = 60;
/* 119 */     RestTemplate restTemplate = new RestTemplate();
/* 120 */     SSLContext sslContext = null;
/*     */     try {
/* 122 */       TrustStrategy acceptingTrustStrategy = (cert, authType) -> true;
/* 123 */       sslContext = SSLContexts.custom().loadTrustMaterial(null, (TrustStrategy)acceptingTrustStrategy).build();
/* 124 */     } catch (Exception exception) {
/* 125 */       this.logger.error("{}[{}]SSLContexts:{}", new Object[] { prefixLog, uri, exception });
/*     */     } 
/* 127 */     SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, (HostnameVerifier)NoopHostnameVerifier.INSTANCE);
/*     */ 
/*     */     
/* 130 */     Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.create().register("https", sslsf).register("http", new PlainConnectionSocketFactory()).build();
/*     */     
/* 132 */     BasicHttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager((Lookup)socketFactoryRegistry);
/*     */ 
/*     */     
/* 135 */     CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory((LayeredConnectionSocketFactory)sslsf).setConnectionManager((HttpClientConnectionManager)connectionManager).build();
/*     */     
/* 137 */     HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory((HttpClient)httpClient);
/*     */     
/* 139 */     clientHttpRequestFactory.setConnectTimeout(apiTimeout * 1000);
/* 140 */     clientHttpRequestFactory.setReadTimeout(apiTimeout * 1000);
/* 141 */     restTemplate.setRequestFactory((ClientHttpRequestFactory)clientHttpRequestFactory);
/*     */     
/* 143 */     HttpHeaders headers = new HttpHeaders();
/* 144 */     headers.setContentType(MediaType.APPLICATION_XML);
/* 145 */     headers.setAccept(Collections.singletonList(MediaType.APPLICATION_XML));
/*     */     
/* 147 */     this.logger.info("{}[{}]{}", new Object[] { prefixLog, uri, this.logUtils.logRequest(req) });
/*     */     
/* 149 */     HttpEntity<String> e = new HttpEntity(req, (MultiValueMap)headers);
/* 150 */     ResponseEntity<String> result = null;
/*     */     try {
/* 152 */       result = restTemplate.postForEntity(uri, e, String.class, new Object[0]);
/* 153 */     } catch (RestClientException restEx) {
/* 154 */       throw new EISException("callSOAPAPISync" + uri, restEx);
/*     */     } 
/* 156 */     String responseGetReqID = (String)result.getBody();
/* 157 */     this.logger.info("{}[{}]{}", new Object[] { prefixLog, uri, responseGetReqID });
/*     */     
/* 159 */     return responseGetReqID;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Desktop\!\nencer\app\Utils\MSClientUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */