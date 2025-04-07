export interface Usuario {
        id: number;
        nome: string;
        email: string;
        cpf: string;
        cargo: string;
        status: boolean;
      }
      
      export interface Aluno {
        id: number;
        matricula: string;
        usuario: Usuario;
      }