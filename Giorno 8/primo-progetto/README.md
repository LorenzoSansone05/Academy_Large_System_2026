I passaggi per creare un app springboot funzionante sono stati facili, ho creato la struttura di dipendenze e di nome del progetto,
successivamente ho generato il file .zip da spring initializr, ho estratto tutti i file e aperto il progetto, poi sono andato a creare la struttura dei package(controller, config) ed ho esposto alcuni endpoint GET. 

Gli endpoint GET che ho esposto sono:

/saluto = endpoint che torna un messaggio di prova per verificare se l'app stesse correttamente funzionando

/info = endpoint che torna a schermo un JSON col mio nome come valore e come chiave alunno

/app-info = endpoint che torna a schermo un JSON con informazionio riguardante l'app: nome, versione e messaggio di benvenuto. Trattate come variabili iniettate dal file di properties principale

/messaggio-file-prop = endpoint che mostra un messaggio iniettato da 2 file di properties diversi, ma springboot sceglie quale prendere in base al profilo attivo (dev o prod)

/configurazione-server = endpoint che mostra a schermo un JSON che indica la porta sulla quale Tomcat è in ascolto

