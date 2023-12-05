// variable de bloque
let nombre = "Borja"; // String
let edad = 39; // number
let experiencia = false; // boolean
let carnet = null; // null
let portatil; //undefield
let hobbies = [];
console.log(typeof portatil)
//variable constante
const nombres = ["Borja","Juan","Celia"]
const DNI = "1231231";

//console.log("Mensaje sacado por consola")
console.log(`El nombre del usuario es ${nombre}`)
//alert("Estas seguro de que esto es un aviso") -> alerta simple 
/*const respuesta = confirm("Estas seguro de que quieres borrar los datos") -> cuadro de dialogo de confirmacion con aceptar y cancelar
if (respuesta){
    console.log("el usuario a contestado ok")
}else{
    console.log("el usuario a contestado no ok")
}*/ 

/*const nombreUsu = prompt("Por favor introduce tu nombre: ")
if (nombreUsu){
    console.log(`El nombre es ${nombre}`)
}else{
    alert("Faltan datos")
}*/

let num = Number(prompt("Introduce un número: "))

if (isNaN(num)){
    alert("No se ha introducido un número real, cerrando programa")
}else{
    let num2 = Number(prompt("Introduce un segundo número: "))
    if (isNaN(num2)){
        alert("El segundo valor introducido no ha sido un número")
    }else{
        alert(`${num} + ${num2} = ${num + num2}\n${num} - ${num2} = ${num - num2}\n${num} * ${num2} = ${num * num2}\n${num} / ${num2} = ${num / num2}\n${num} % ${num2} = ${num % num2}`)
    }
}