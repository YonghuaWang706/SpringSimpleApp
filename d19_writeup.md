1. Representational State Transfer (REST) is an architectural style that specifies constraints, such as the uniform interface, that if applied to a web service induce desirable properties, such as performance, scalability, and modifiability, that enable services to work best on the Web.
2. The client-server design pattern enforces the separation of concerns, which helps the client and the server components evolve independently. 
Statelessness mandates that each request from the client to the server must contain all of the information necessary to understand and complete the request.
The cacheable constraint requires that a response should implicitly or explicitly label itself as cacheable or non-cacheable.
The layered system style allows an architecture to be composed of hierarchical layers by constraining component behavior.
REST also allows client functionality to extend by downloading and executing code in the form of applets or scripts.
3. REST is a set of guidelines that offers flexible implementation, whereas SOAP is a protocol with specific requirements like XML messaging.

REST APIs are lightweight, making them ideal for newer contexts like the Internet of Things (IoT), mobile application development, and serverless computing. SOAP web services offer built-in security and transaction compliance that align with many enterprise needs, but that also makes them heavier. Additionally, many public APIs, like the Google Maps API, follow the REST guidelines.
4. It combines @controller and @responsebody. This enforce the handler to return serialized json as response.
5. By using @RequestBody annotation you will get your values mapped with the model you created in your system for handling any specific call. While by using @ResponseBody you can send anything back to the place from where the request was generated
6. With RestTemplate or WebClient 