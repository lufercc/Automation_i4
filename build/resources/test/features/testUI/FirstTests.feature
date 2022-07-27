Feature: Open PAges

  Scenario: Como Usuario quiero abrir las pagina de Trello
    Given I Open The Browser
    When I go to "https://www.google.com"
    Then Verifico que la URL sea "https://www.google.com/"

  Scenario: Como Usuario quiero abrir las pagina de Trello
    Given I Open The Browser
    When I go to "https://www.youtube.com"
    Then Verifico que la URL sea "https://www.youtube.com/"


  Scenario: Como Usuario quiero abrir las pagina de Trello
    Given I Open The Browser
    When I go to "https://www.trello.com"
    Then Verifico que la URL sea "https://www.trello.com/"


#  Feature:  === > Caracteristica
#
#    Scenario:  === > Escenario/Caso de Uso/ Prueva de usuario
#
#      Given ==> dado (denotar Requerimineto, previo al scenario)
#
#      When == > Cuando (donota el inicio del caso de uso)
#
#      Then ==> Entonces (denota el paso de verificacion)
#
#
#      Caso De Uso: Como usuarion yo quiero iniciar session en la pagina de trello
#
#        Dado que abro el navegador (Chrome)
#        Y tengo un uuario creado
#        Cuando voy a la pagina "www.trello.com"
#        Entonces puedo ver la pagina de trello