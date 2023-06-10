export default class Achievement {
    id: number;
    name: string;
    description: string;
    imageURL: string;
    date: string;
  
    constructor(
      id: number,
      name: string,
      description: string,
      imageURL: string,
      date: string
    ) {
      this.id = id;
      this.name = name;
      this.description = description;
      this.imageURL = imageURL;
      this.date = date;
    }
  }