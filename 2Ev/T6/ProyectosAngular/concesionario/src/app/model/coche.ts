export interface Coche {
    marca: string;
    modelo: string;
    cv: number;
    cc: number;
    matricula: string;
    motor: string
}

export class CocheClase{
    constructor(private marca: string, private modelo: string, private cv:number, private cc: number, private matricula: string,private motor: string ){
        
    }
    
  mostrarDatos() {}

  public get getMatricula(): string {
    return this.matricula;
  }

  public get getMotor(): string {
    return this.motor;
  }
}