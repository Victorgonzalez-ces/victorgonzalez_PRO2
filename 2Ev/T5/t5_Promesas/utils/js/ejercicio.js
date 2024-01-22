let categories = document.querySelector("#categorias");
let cartas = document.querySelector("#cartas")
let botonSearch = document.querySelector("#search")
let inputProductos = document.querySelector("#numeroProductos")
let urlCategories = "https://dummyjson.com/products/categories"; 
let lista = document.querySelector("#lista")
let listaDetalle = document.querySelector("#listaDetalle")
let numeroCarrito = document.querySelector("#numeroCarrito")
let vaciarCarrito = document.querySelector("#botonVaciarCarrito")
let carrito = 0
let contador = 0
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
                id="comprar-${element.id}">comprar</Button>
                <button class="col btn btn-primary"
                id=verDetalle-${element.id}
                style="background-color: green"
                >ver detalle</Button>
            </div>
            </div>
            </div>`
            pulsacionComprarDetalle(element.id)
        });
    })
}

function pulsacionComprarDetalle(id){
    let url = "https://dummyjson.com/products"
    fetch(url)
    .then((res)=>{
        return res.json()
    })
    .then((res1)=>{
        res1.products.forEach(element => {
            if(element.id == id){
                let botonComprar = document.querySelector(`#comprar-${id}`)
                let botonDetalle = document.querySelector(`#verDetalle-${id}`)
                botonComprar.addEventListener("click",()=>{
                    lista.innerHTML += `<li class='list-group-item' style='text-align=center'>
                    ${element.title} ${element.price}$ </li>`
                    contador++
                    numeroCarrito.innerHTML = contador
                    carrito += element.price
                })
                
                botonDetalle.addEventListener("click",()=>{
                    listaDetalle.innerHTML = ""
                    listaDetalle.innerHTML += `<div class='card' style='width: 18rem;'>
                    <img src=${element.images[0]} class='card-img-top' alt='...'>
                    <div class='card-body'>
                    <h5 class='card-title'>${element.title}</h5>
                    <p class='card-text'>${element.description}</p> 
                    <div class="row">
                    </div>
                    </div>
                    </div>`
                })
                
            }        
        });
    })
}
vaciarCarrito.addEventListener("click",()=>{
    vaciarCarritos()
})
function vaciarCarritos(){
    lista.innerHTML = ""
    numeroCarrito.innerHTML = 0
    alert(`Ha comprado usted en la web por valor de: ${carrito}`)
}


