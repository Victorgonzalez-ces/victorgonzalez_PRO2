let inputNombre = document.querySelector("#inputNombre");
let inputApellido = document.querySelector("#inputApellido");
let botonAcceder = document.querySelector("#botonAcceder");
let selectAlumnos = document.querySelector("#selectAlumnos");
let botonBuscar = document.querySelector("#botonBuscar");
let listaAlumnos = document.querySelector("#listaAlumnos");
let nombreProfesor = document.querySelector("#nombreProfesor");
let siglasAsignatura = document.querySelector("#siglasAsignatura");
let nombreAsignatura = document.querySelector("#nombreAsignatura");
let horasAsignatura = document.querySelector("#horasAsignatura");
let numAprobados = document.querySelector("#numAprobados");
let numSuspensos = document.querySelector("#numSuspensos");
let url = "https://run.mocky.io/v3/e85e13eb-10e5-436f-9a5f-c5cbaac4eea9"
selectAlumnos.disabled = true;
botonBuscar.disabled = true;
let contadorAprobados = 0;
let contadorSuspensos = 0;
llenarSelect()

botonAcceder.addEventListener("click",()=>{
    login();
})

botonBuscar.addEventListener("click",()=>{
    listarAlumnos();
})

function login(){
    if(inputNombre.value == "admin" && inputApellido.value == "admin"){
        alert("inicio de sesión correcto...");
        selectAlumnos.disabled = false;
        botonBuscar.disabled = false;
    }else{
        alert("fallo al iniciar sesión, usuario o password incorrectos...");
    }
}

function llenarSelect(){
    fetch(url)
    .then((res)=>{
        return res.json()
    })
    .then((res1)=>{
        res1.asignaturas.forEach(element => {
            selectAlumnos.innerHTML += `<option>${element.nombre}</option>`
        });
    })
}

function listarAlumnos(){
    contadorAprobados = 0
    contadorSuspensos = 0
    listaAlumnos.innerHTML = ""
    fetch(url)
    .then((res)=>{
        return res.json()
    })
    .then((res1)=>{
        res1.asignaturas.forEach(element => {
            if(element.nombre == selectAlumnos.value){
                element.alumnos.forEach(element => {
                    listaAlumnos.innerHTML += `<li class=list-group-item 
                    style= text-align: center>${element.name} - ${element.surname} - ${element.age}</li>`
                    if(element.estado == "aprobado"){
                        contadorAprobados++;
                    }else{
                        contadorSuspensos++;
                    }
                });
                nombreProfesor.innerHTML = element.profesor;
                siglasAsignatura.innerHTML = element.siglas;
                nombreAsignatura.innerHTML = element.nombre;
                horasAsignatura.innerHTML = element.horas;
                numAprobados.innerHTML = contadorAprobados;
                numSuspensos.innerHTML = contadorSuspensos;
            }
        });
    })
}