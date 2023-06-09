export class Worker {
    id: number;
    name: string;
    surname: string;
    secondName: string;
    login: string;
    postId: number;
    positionId: number;
    age: number;
    phone: string;
    balance: number;
    password: string;
    role: string;
    gender: string;
  
    constructor(
      id: number,
      name: string,
      surname: string,
      secondName: string,
      login: string,
      postId: number,
      positionId: number,
      age: number,
      phone: string,
      balance: number,
      password: string,
      role: string,
      gender: string
    ) {
      this.id = id;
      this.name = name;
      this.surname = surname;
      this.secondName = secondName;
      this.login = login;
      this.postId = postId;
      this.positionId = positionId;
      this.age = age;
      this.phone = phone;
      this.balance = balance;
      this.password = password;
      this.role = role;
      this.gender = gender;
    }
  }