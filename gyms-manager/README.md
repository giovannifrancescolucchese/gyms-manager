# GYMS MANAGER
Questa è un progetto **INCOMPLETO** che ha l'obiettivo di gestire un'anagrafica delle strutture sportive con tutto ciò che ne consegue.
E' volutamente incompleto al fine di permettere al team di sviluppo di implemetare nuove funzionalità richieste.
Al momento gestisce unicamanente le operazioni CRUD (CREATE, READ, UPDATE & DELETE) di una singola entità (Gym).

# STRUTTURA GENERALE
Il progetto si divide in una parte Back End (questa) e una Front End. In particolare compito della parte di Back End è quello di esporre degli endpoint (REST API) tramite i quali il Front End interagirà con le entità, creandole, aggiornandole, leggendole o cancellandole. E' la tipica struttura *SERVER-CLIENT*

# IL BACK END
Abbiamo detto che il compito del BE è quello di esporre degli endpoint al FE (client) in maniera tale da operare (operazioni CRUD) sulle entità. Si è implementata quindi un'applicazione JAVA in Spring Boot. Per conoscenza, Spring Boot è un framework che permette il rilascio di applicazioni WEB "STAND ALONE" senza dover gestire un application server (come ad esempio Tomcat). Il codice è strutturato secondo i principi SOLID della programmazione ad oggetti. In particolare:
- il client farà le chiamate agli endpoint esposti nel package controller
- il controller si appoggerà ai metodi forniti dal "Bean" Service
- il Service interagirà con l'Entity attraverso un repository ad hoc

