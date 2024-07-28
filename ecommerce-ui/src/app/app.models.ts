export interface User{
    id:string;
    name:string;
    email:string;
    role:string;
    contact?:string;
    address?:string;
}

export interface Product {
    id: number;
    name: string;
    description: string;
    price: number;
    stock: number;
    image:string;
  }