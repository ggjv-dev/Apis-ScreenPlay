# Apis-ScreenPlay
Framework basado en el patron ScreenPlay desarrollado con java 8 y gradle, diseñado para la prueba de servicios tipo rest.
## Comandos de ejecucion:
* Para ejecutar todo el proyecto:

  ```gradle clean test aggregate```
    
* Para ejecutar por nombre de escenario:

  ```gradle clean test -Dcucumber.options="--name nombre.escenario" aggregate```
  
  > Se debe reemplzar 'nombre.escenario' por el nombre del escenario que se requiere ejecutar, los espacios deben ser reemplazados por '.'

* Para ejecutar por tags:

  ```gradle clean test -Dcucumber.options="--tag @NombreTag" aggregate```
  
  > Se debe reemplzar 'NombreTag' por el nombre del tag que desee ejecutar

* * *
<div style="text-align: right"> Gabriel Gabriel Jiménez Vergara </div>
