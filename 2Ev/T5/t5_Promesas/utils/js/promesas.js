let boton = document.querySelector("button");
let span = document.querySelector("span");
let listaMasculina = document.querySelector("#lista-masculino")
let listaFemenina = document.querySelector("#lista-femenino")
/*let contador = 0;
setTimeout(() => {
    console.log("Ejecucion postergada");
},5000);

boton.addEventListener("click", (e) => {
    setInterval(()=> {
      contador++
      span   
    },1000);
});
//temporizador
//0
//cuando le de al boton de iniciar tarea, el contador empieza a funcionar
setInterval(() => {
    console.log("Ejecucion recurrente");
},1000);

let promesa = new Promise((res,rej)=> {
    setTimeout(()=>{
        let aleatorio = Math.random * 11;
        if (aleatorio>=5){
            //correcta
            res(aleatorio);
        }else{
            //incorrecta
            rej("Fallo en la promesa, número pequeño");
        }
    }, 4000);
});

promesa
.then((res)=>{
    console.log("El aleatorio generado es: " + res);
    return res
})
.then((res1)=>{
    console.log(res1 * 2);
})
.catch((err)=>{
    console.log(err);
});*/

//https://randomuser.me/api/?results=50

function consultarUsuarios(){
    fetch("https://randomuser.me/api/?results=50")
    .then((res)=>{
        console.log(res)
        if(res.ok){
            //pasar a json
            return res.json();
        }
    })
    .then((res1)=>{
        //sacar nombre y apellido de todos los usuarios (nombre - apellido)
        res1.results.forEach(element => {
            if (element.gender == "female"){
                listaFemenina.innerHTML += 
                `<li class='list-group-item' style='text-align: center'>
                ${element.name.first} - ${element.name.last}</li>`;
            }else{
                listaMasculina.innerHTML +=
                 `<li class='list-group-item' style='text-align: center'>
                 ${element.name.first} - ${element.name.last}</li>`;
            }
        });
    })
    .catch(()=>{
        console.log("URL desconocida");
    });
}
consultarUsuarios();

//animate.css