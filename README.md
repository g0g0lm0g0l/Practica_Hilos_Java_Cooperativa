# Practica_Hilos_Java_Cooperativa

Problema: 
  Queremos simular el comportamiento de la cooperativa de productores de melocotón de la
cuenca del río Segura.
Tenemos:
• Agricultores, que cultivan los melocotones y los llevan a la cooperativa.
• Clientes, que compran los melocotones.
Simular, utilizando un modelo productor-consumidor, el funcionamiento de la cooperativa
siguiendo las siguientes indicaciones:
• La cooperativa guarda los melocotones en un almacén, en el que caben sólo 200
cajas de melocotones.
• Respecto a los agricultores:
o Entregan las cajas de melocotones en el almacén. Cada vez llevan una
cantidad diferente de cajas, entre 10 y 20 (generar aleatoriamente).
o Si cuando va a entregar las cajas no puede entregarlas todas (no hay
suficiente espacio en el almacén), espera hasta que haya espacio. No entregan parte. O
todas o ninguna.
o Tras entregar un envío, el agricultor vuelve a su huerta para recoger el
siguiente envío. Esto le lleva entre 1000 y 2000 milisegundos (generar aleatoriamente).
o Cada vez que un agricultor deje cajas, o no pueda dejarlas, hay que mostrar
un mensaje que informe de lo que está pasando.
• Respecto a los clientes:
o Compran cajas de melocotones completas (no se puede comprar media
caja), y normalmente compran entre 5 y 10 cajas.
o Si cuando van a comprar no hay suficientes cajas para llevarse las que
quieren (todas) esperan a que las haya. No se llevan parte de lo que querían. O todo o
nada.
o Tras hacer una compra, el cliente la lleva a casa antes de volver a comprar.
Esto le lleva entre 1000 y 2000 milisegundos (generar aleatoriamente).
o Cada vez que un cliente compre cajas, o no pueda comprarlas, hay que
mostrar un mensaje que informe de lo que está pasando.
• El programa principal creará 3 agricultores y 3 clientes, cada uno identificado con un
nombre o un número, que se usará
Pistas:
• Lo más fácil es implementar el almacén como un monitor que hace esperar a los
agricultores/ clientes cuando no puede atenderlos.
• El programa se ejecuta indefinidamente. No parará nunca.



Esto es solo una practica realizada por un estudiante
No la utilize por favor!!!
El código propenso a errores!!!
