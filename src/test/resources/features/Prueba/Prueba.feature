Feature: Prueba de Apis

  Scenario Outline: GET

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API | Peticion | Enviroment | EndPoint      | METODO | HEADERS                       | BODY | StatusCode | ValoresEsperados | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Get
|GET|Happy path|BASE|/employees|Get|Content-Type:application/json||200|message~Successfully! All records has been fetched.#data[7].id~8#data[7].employee_name~Rhona Davidson|N/A|

  Scenario Outline: POST

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API  | Peticion | Enviroment | EndPoint | METODO       | HEADERS                       | BODY                   | StatusCode | ValoresEsperados    | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Post
|POST|Happy Path|BASE|/create|PostBodyJson|Content-Type:application/json|{"name":"Gabriel","salary":"8000000","age":"23"}|200|data.name~Gabriel#data.salary~8000000|N/A|

  Scenario Outline: GET 2

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API    | Peticion | Enviroment | EndPoint | METODO | HEADERS                       | BODY | StatusCode | ValoresEsperados              | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@GET2
|Get 2|Happy Path|BASE|/employee/1|Get|Content-Type:application/json||200|data.id~1#data.employee_name~Tiger Nixon#data.employee_salary~320800#data.employee_age~61|N/A|

  Scenario Outline: DELETE

    Given consumo el api <API> para verificar la peticion <Peticion>, con la siguiente data de prueba:
      | <Enviroment> | <EndPoint> | <METODO> | <HEADERS> | <BODY> | <PARAMS> |
    When verifico el status code <StatusCode>
    Then Verifico los valores esperados en el response <ValoresEsperados>

    Examples:
      | API | Peticion | Enviroment | EndPoint | METODO      | HEADERS                       | BODY                  | StatusCode | ValoresEsperados  | PARAMS |
    ##@externaldata@src/test/resources/Datadriven/Prueba.xlsx@Delete
|DELETE|Happy Path|BASE|/delete/2|Delete|Content-Type:application/json||200|message~Successfully! Record has been deleted|N/A|
