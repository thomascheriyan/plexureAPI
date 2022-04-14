# plexureAPI

Test scenarios for Plexure interview test
The tests were created with Java, cucumber and RestAssured.
Only login scenario created as unable to connect to API and error response returned

Error:
POST https://qatestapi.azurewebsites.net/api
404
1496 ms
POST /api HTTP/1.1
Content-Type: application/JSON
POST: /login
Authorization: Basic VGVzdGVyOlBsZXh1cmUxMjM=
Cache-Control: no-cache
Postman-Token: 2139711c-3e58-4f4e-aa8c-2cb5970b4adc
Accept-Encoding: gzip, deflate, br
Connection: keep-alive
Cookie: ARRAffinity=d82e90fa019d931a9239945412fe73a651e11822a7a9255d507ecc658507a60f; ARRAffinitySameSite=d82e90fa019d931a9239945412fe73a651e11822a7a9255d507ecc658507a60f
 
{
"username": "String",
"password": "String"
}
 
HTTP/1.1 404 Not Found
Content-Length: 103
Content-Type: text/html
Server: Microsoft-IIS/10.0
X-Powered-By: ASP.NET
Date: Thu, 14 Apr 2022 00:11:58 GMT
 
The resource you are looking for has been removed, had its name changed, or is temporarily unavailable.
