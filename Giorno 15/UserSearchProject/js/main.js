//Dichiaro una funzione asincrona, quindi dico al file html "non aspettarmi, fai altro nel mentre io aspetto i dati da inserire" e quindi non blocca il flusso di esecuzione dell'app nel caso ci sia un problema col ricevere dati lato BE
async function dati() {
const response = await fetch("https://jsonplaceholder.typicode.com/users"); //Prendi i dati dall'URL 
const dati = await response.json(); // li memorizzi in una constante

const listDivs = document.querySelectorAll('div.card'); // Seleziono tramite query tutti i div che hanno come classe card

const listLinks = document.querySelectorAll('a');

// effettuo l'operazione di inserire i dati nei p di ogni div tramite un arrow function for each che ha come argomenti in ingresso, il singolo div su cui lavorare e un elemento i che indica il "contatore" una variabile int che aumenta ad ogni esecuzione della funzione foreach (quindi il ++ per aumentare vi viene omesso, accade sotto banco)
listDivs.forEach((div, i) => {
    const p = div.querySelectorAll('p');
    p[0].textContent = dati[i].name;
    p[1].textContent = dati[i].email;

    listLinks[i].href = `./detailsUser.html?id=${dati[i].id}`
})
}

//Alla fine vado a creare un listener di eventi, ma qui sembra quasi non esserci alcun evento, perche il fattore che farà eseguire la funzione dati() sarà semplicemente aprire la pagina html, niente click o passare col cursore sopra, vengono visti come dati che devono essere caricati di default
document.addEventListener('DOMContentLoaded', dati);


function filterUsers(username) {
    const ricerca = username.toLowerCase(); // Non importa come viene fatta la ricerca, impongo che l'input utente debba essere minuscolo per matchare il filtro
    const listLi = document.querySelectorAll('ul.flex-container > li'); //Faccio una query per recuperare l'insieme degli elementi lista di tutta la pagina

    // Per ogni elemento faccio una query sugli elementi dove devo accedere alle proprieta css, in questo caso i paragrafi e i link <a>, creop una condizione nella quale confronto l'input utente col testo della card, se matcha lo mostra altrimenti lo nasconde, di conseguenza per non lasciare link inutili nascondo anche i link insieme alla card
    listLi.forEach((li) => {
        const firstP = li.querySelector('p');
        const detailsLink = li.querySelector('a')
        if(!firstP.textContent.toLowerCase().includes(ricerca)) {
            li.style.display = 'none';
        }
        else {
            li.style.display = 'block';
            detailsLink.style.display = 'inline';
        }
    })
}

const inputSearch = document.querySelector('input');

inputSearch.addEventListener('input', (username) => {
    const testo = username.target.value;
    filterUsers(testo);
})




