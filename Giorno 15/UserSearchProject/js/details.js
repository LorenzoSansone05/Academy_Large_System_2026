async function popolaDettaglio() {
    const id = new URLSearchParams(window.location.search).get('id');

    const res = await fetch(`https://jsonplaceholder.typicode.com/users/${id}`);
    const u = await res.json();

    const s = document.querySelectorAll('.details-user-ul span');

    s[0].innerText = u.name;
    s[1].innerText = u.username;
    s[2].innerText = u.email;
    s[3].innerText = u.address.street;
    s[4].innerText = u.address.suite;
    s[5].innerText = u.address.city;
}

document.addEventListener("DOMContentLoaded", popolaDettaglio);