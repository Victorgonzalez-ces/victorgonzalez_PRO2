let boton = document.querySelector("button")
let lista = document.querySelector("#lista-tareas")
boton.addEventListener('click',(ev)=> {
    /*let inputs = document.querySelectorAll("input")
    console.log(inputs);*/
    lista.innerHTML += "<li class='list-group-item'>Elemento</li>"
    let nodoLi = document.createElement("li")
    nodoLi.classList.add("list-group-item")
    nodoLi.textContent = "Elemento"
    lista.appendChild = nodoLi
})