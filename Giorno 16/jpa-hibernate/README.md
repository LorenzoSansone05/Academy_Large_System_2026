Ho testato tutti gli 8 endpoint di questa web app JPA/Hibernate (GET all, GET by ID, GET by cognome, GET by corso, GET corso by ID, POST, PATCH, DELETE) creando prima di tutto una collection in cui andavo a fare le richieste.

Prima ho creato lo studente, fornendo all'interno della richiesta POST tutte le informazioni necessarie per la creazione del record nel db.
Poi l'ho cercato facendo una richiesta GET su /api/studenti così da vederli tutti e, per conferma, l'ho fatto anche con l'id, per controllare che entrambi gli endpoint GET funzionassero a dovere.
Poi ho modificato il record cambiando corso di laurea tramite PATCH ed ha funzionato perfettamente; per conferma ho anche rieseguito la richiesta GET per vedere i record.
Alla fine di tutto ho usato l'ultimo endpoint DELETE e cancellato il record tramite l'id: funziona tutto perfettamente.


Tabella che mostra Metodo http, URL e chi può accedere in base al ruolo


Metodo     URL                                Accesso
GET        /api/studenti                      Tutti
GET        /api/studenti/{id}                 USER / ADMIN
GET        /api/studenti/cognome/{cognome}    USER / ADMIN
GET        /api/studenti/corso/{corso}        USER / ADMIN
GET        /api/studenti/{id}/corso           USER / ADMIN
POST       /api/studenti                      ADMIN
PATCH      /api/studenti/{id}                 ADMIN
DELETE     /api/studenti/{id}                 ADMIN

Ecco un esempio del body della response in formato JSON sull'endpoint "http://localhost:8080/api/studenti?page=0&size=5&sort=cognome,desc"

{
"content": [
{
"nome": "Carlo",
"cognome": "Prestigiacomo",
"email": "carlo.prestigiacomo@gmail.com",
"corsoLaurea": "Informatica",
"dataNascita": "2005-11-17",
"id": 1
}
],
"empty": false,
"first": true,
"last": true,
"number": 0,
"numberOfElements": 1,
"pageable": {
"offset": 0,
"pageNumber": 0,
"pageSize": 5,
"paged": true,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"unpaged": false
},
"size": 5,
"sort": {
"empty": false,
"sorted": true,
"unsorted": false
},
"totalElements": 1,
"totalPages": 1
}

Ho tolto le credenziali hardcoded dal mio codice java e le ho migrate in un db con tabelle personalizate usando bcrypt per renderle sicure e non leggibili.

Per quanto riguarda la creazione delle tabelle ho creato 2 script sql diversi, uno per le tabelle e uno per i dati iniziali, oltre al lato sql c'è il lato config che richiede le query adatte per trovare le 2 tabelle custom che sostituiscono quelle di default.

Nel primo script definisco le tabelle "account" e "permessi", i campi di account sono le credenziali e un boolean per sapere se è attivo l'utente, invece i campi di permessi sono la foreign key email della tabella account e il ruolo che gli spetta, oltre naturalmente all'id per distinguere i record nella tabella permessi, che ometto nella tabella account poiche l'username cioe l'email deve essere gia essa univoca, quindi non avrebbe senso creare un altro identificatore