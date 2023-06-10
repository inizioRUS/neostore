export class Worker {
    id: number;
    name: string;
    surname: string;
    secondName: string;
    login: string;
    post: number;
    position: number;
    age: number;
    phone: string;
    balance: number;
    password: string;
    role: string;
    gender: string;
    imageURL : string;
  
    constructor(
      id: number,
      name: string,
      surname: string,
      secondName: string,
      login: string,
      post: number,
      position: number,
      age: number,
      phone: string,
      balance: number,
      password: string,
      role: string,
      gender: string,
      imageURL : string
    ) {
      this.id = id;
      this.name = name;
      this.surname = surname;
      this.secondName = secondName;
      this.login = login;
      this.post = post;
      this.position = position;
      this.age = age;
      this.phone = phone;
      this.balance = balance;
      this.password = password;
      this.role = role;
      this.gender = gender;
      this.imageURL = imageURL
    }
  }