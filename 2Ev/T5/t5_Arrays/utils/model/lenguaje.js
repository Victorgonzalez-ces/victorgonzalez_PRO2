class Lenguaje{
    nombre;
    version;
    tecnologia;
    usos;
    dificultad;
    novedoso;

    constructor(nombre, version, tecnologia, usos, dificultad, novedoso){
        this.nombre = nombre
        this.version = version
        this.tecnologia = tecnologia
        this.usos = usos
        this.dificultad = dificultad
        this.novedoso = novedoso
    }
    mostrarDatos(){
        console.log(`Nombre: ${nombre}`)
        console.log(`Version: ${this.version}`)
        console.log(`tecnologia: ${this.tecnologia}`)
        console.log(`dificultad: ${this.dificultad}`)
        console.log(`novedoso: ${this.novedoso}`)
        this.usos.forEach(element => {
            
        });
    }

    get getNombre(){
        return this.nombre
    }
    set setNombre(nombre){
        this.nombre = this.nombre
    }
}