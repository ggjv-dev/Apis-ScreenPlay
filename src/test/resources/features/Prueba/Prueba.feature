Feature: Prueba de Apis

  Scenario Outline: GET with URL Params

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API | Peticion | Enviroment | EndPoint      | METODO | HEADERS                       | BODY | StatusCode | ValoresEsperados | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Get
|GET|Success|BASE|/get?lol=true|Get|Content-Type:application/json||200|args.lol~true|N/A|

  Scenario Outline: POST with JSON body

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API  | Peticion | Enviroment | EndPoint | METODO       | HEADERS                       | BODY                   | StatusCode | ValoresEsperados    | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Post
|POST|Success|BASE|/post|PostBodyJson|Content-Type:application/json|{ "something": "cool"}|200|json.something~cool|N/A|

  Scenario Outline: DELETE request

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API    | Peticion | Enviroment | EndPoint | METODO | HEADERS                       | BODY | StatusCode | ValoresEsperados              | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Delete
|DELETE|Success|BASE|/delete|Delete|Content-Type:application/json||200|url~http://httpbin.org/delete|N/A|

  Scenario Outline: PUT with form data

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API | Peticion | Enviroment | EndPoint | METODO      | HEADERS                       | BODY                  | StatusCode | ValoresEsperados  | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Put
|PUT|Success|BASE|/put|PutBodyJson|Content-Type:application/json|{ "quotient": "224" }|200|json.quotient~224|N/A|
