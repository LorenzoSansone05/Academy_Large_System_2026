Ho testato tutti gli endpoint di questa web app jpa/hibernate creando prima di tutto una collection in cui andavo a fare 5 richieste (2 get, 1 post, 1 put, 1 delete)
Prima ho creato lo studente, fornendo all'interno della richiesta POST tutte le informazioni necessarie per l acreazione del record nel db
Poi l'ho cercato facendo una richiesta GET su api/studenti cosi da vederli tutti e per conferma l'ho fattoa cnhe con l'id, per controllare che entrambi gli endpoint GET funzionassero a dovere
Poi ho modificato il record cambiando corso di laurea ed ha funzionato perfettamente, per conferma ho anche rieseguito la richiesta GET per vedere i record
Alla fine di tutto rimane l'ultimo endpoint DELETE e cancello il record tramite l'id, quindi funziona tutto perfettamente.

Tabella che mostra Metodo http, URL e chi puo accedere


Metodo    URL                          Accesso
GET       /api/studenti                Tutti
GET       /api/studenti/{id}           USER / ADMIN
GET       /api/studenti/cerca          USER / ADMIN
GET       /api/studenti/{id}/corso     USER / ADMIN
POST      /api/studenti                ADMIN
PUT       /api/studenti/{id}           ADMIN
DELETE    /api/studenti/{id}           ADMIN
