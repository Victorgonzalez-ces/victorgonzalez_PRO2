let categories = document.querySelector("#categorias");
let cartas = document.querySelector("#cartas")
let botonSearch = document.querySelector("#search")
let inputProductos = document.querySelector("#numeroProductos")
let listaProductos = document.querySelector("#listaProductos")
let botonDetalle = document.querySelector("#verDetalle")
let urlCategories = "https://dummyjson.com/products/categories"; 
cargarCategorias()

botonSearch.addEventListener("click", ()=>{
    cargarProductos(categories.value,inputProductos.value)
})


function cargarCategorias(){
    fetch(urlCategories)
    .then((res)=>{
        return res.json();
    })
    .then((res1)=>{
        res1.forEach(element => {
            categories.innerHTML += `<option>${element}</option>`
        });
    })
}

function cargarProductos(categori,num){
    cartas.innerHTML = ""
    let url = `https://dummyjson.com/products/category/${categori}?limit=${num}`;
    fetch(url)
    .then((res)=>{
        return res.json();
    })
    .then((res1)=>{
        res1.products.forEach(element => {
            cartas.innerHTML += `<div class='card' style='width: 18rem;'>
            <img src=${element.images[0]} class='card-img-top' alt='...'>
            <div class='card-body'>
            <h5 class='card-title'>${element.title}</h5>
            <p class='card-text'>${element.stock}</p> 
            <div class="row">
                <button class="col btn btn-primary"
                id="comprar">comprar</Button>
                <button class="col btn btn-primary"
                id=verDetalle
                style="background-color: green"
                >ver detalle</Button>
            </div>
            </div>
            </div>`
            let botonComprar = document.querySelector(`#comprar`)
            botonComprar.addEventListener("click",()=>{
                anadirCarrito(element.id)
            })
        });
    })
    anadirCarrito();
}

function anadirCarrito(id){
    url = "https://dummyjson.com/products";
    fetch(url)
    .then((res)=>{
        return res.json();
    })
    .then((res1)=>{
        res1.products.forEach(element => {
            if(element.id == id){
                listaProductos.innerHTML += `<li class='list-group-item' style='text-align: center'>
                ${element.title}</li>`;
            }
        });
    })
}


