export interface Coche {
    marca: string;
    modelo: string;
    cv: number;
    cc: number;
    matricula: string;
}

export class CocheClase{
    constructor(private marca: string, private modelo: string, private cv:number, private cc: number, private matricula: string){
        
    }
}