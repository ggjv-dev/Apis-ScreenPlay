Feature: Prueba de Apis

  Scenario Outline: GET with URL Params

    Given quiero ejecutar el API <API> con la peticion <Peticion>
    When consumo el api <API> con la data data de prueba
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PathFile> | <NameKeys> |
    Then verifico el status code <StatusCode>
    And las respuestas esperadas <RespuestasEsperadas> en las rutas <PATHS> del response

    Examples:
      | API                  | Peticion | Enviroment | EndPoint                                      | METODO     | HEADERS                                                                                                                                                                                          | BODY                                | StatusCode | PATHS                                                                                                                                                                                                                                                                                                                                                                    | RespuestasEsperadas                                                                             | PathFile | NameKeys |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Get
|GET|Success|BASE|/get?lol=true|GET|Content-Type:application/json||200|args.lol|true|||

  Scenario Outline: POST with JSON body

    Given quiero ejecutar el API <API> con la peticion <Peticion>
    When consumo el api <API> con la data data de prueba
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PathFile> | <NameKeys> |
    Then verifico el status code <StatusCode>
    And las respuestas esperadas <RespuestasEsperadas> en las rutas <PATHS> del response

    Examples:
      | API                  | Peticion | Enviroment | EndPoint                                      | METODO     | HEADERS                                                                                                                                                                                          | BODY                                | StatusCode | PATHS                                                                                                                                                                                                                                                                                                                                                                    | RespuestasEsperadas                                                                             | PathFile | NameKeys |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Post
|POST|Success|BASE|/post|POST|Content-Type:application/json|{ "something": "cool"}|200|json.something|cool|||

  Scenario Outline: DELETE request

    Given quiero ejecutar el API <API> con la peticion <Peticion>
    When consumo el api <API> con la data data de prueba
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PathFile> | <NameKeys> |
    Then verifico el status code <StatusCode>
    And las respuestas esperadas <RespuestasEsperadas> en las rutas <PATHS> del response

    Examples:
      | API                  | Peticion | Enviroment | EndPoint                                      | METODO     | HEADERS                                                                                                                                                                                          | BODY                                | StatusCode | PATHS                                                                                                                                                                                                                                                                                                                                                                    | RespuestasEsperadas                                                                             | PathFile | NameKeys |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Delete
|DELETE|Success|BASE|/delete|DELETE|Content-Type:application/json||200|url|http://httpbin.org/delete|||

  Scenario Outline: PUT with form data

    Given quiero ejecutar el API <API> con la peticion <Peticion>
    When consumo el api <API> con la data data de prueba
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PathFile> | <NameKeys> |
    Then verifico el status code <StatusCode>
    And las respuestas esperadas <RespuestasEsperadas> en las rutas <PATHS> del response

    Examples:
      | API                  | Peticion | Enviroment | EndPoint                                      | METODO     | HEADERS                                                                                                                                                                                          | BODY                                | StatusCode | PATHS                                                                                                                                                                                                                                                                                                                                                                    | RespuestasEsperadas                                                                             | PathFile | NameKeys |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Put
|PUT|Success|BASE|/put|PUT|Content-Type:application/json|{ "quotient": "224" }|200|json.quotient|224|||
