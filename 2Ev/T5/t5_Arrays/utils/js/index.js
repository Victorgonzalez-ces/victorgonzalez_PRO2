let lenguajeJson = {
    nombre: "JavaJSON",
    version: 21,
    usos: ["back","media"],
    dificultad: "Media",
    mostrarDatos: function(param){
        console.log(`Parametro: ${param}`)
        console.log(`Nombre: ${this.nombre}`)
        console.log(`Version: ${this.version}`)
        console.log(`tecnologia: ${this.tecnologia}`)
        console.log(`dificultad: ${this.dificultad}`)
        console.log(`novedoso: ${this.novedoso}`)
    },
};
lenguajeJson.mostrarDatos()

const lenguajes = [
    new Lenguaje("Java",21,"back",["Front","Bacj","owfak"],"media",false),
    new Lenguaje("Kotlin",15,"movil",["movil","web","Interface"],"baja",true),
    new Lenguaje("Phyton",23,"datos",["IA","EA","UA"],"muy baja",true),
    new Lenguaje("Powershell",4,"sistemas",["automatizacion","script","Federico"],true),
];
// lenguajes.length
/*console.log(lenguajes.length)
lenguajes.forEach((element, index)=>{
    if (index % 2 == 0){
        console.log(`${index + 1} , ${element}`)
    }
});*/

/*lenguajes
    .filter((element) =>element.length >= 6)
    .forEach((element) => {
        console.log(element)
    });*/

// agregar cosas
//lenguajes.push("TypeScript","C#","C++")

//agregar en el inicio
//lenguajes.unshift("ObjectiveC","PHP")
//console.log(lenguajes)

// eliminar elementos
//pop lo devuelve y elimina el ultimo
//lenguajes.pop()
//shift elimina el primero
//lenguajes.shift()
//console.log(lenguajes)

//sacar lenguajes novedosos

lenguajes.filter((element)=> element.novedoso).forEach((e1) =>{
    console.log(`Estos son los usos del lenguaje ${e1.nombre}`)
    e1.usos.forEach((e2) => {
        console.log(e2);
    })
})