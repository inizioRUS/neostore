export class Good {
  id: number;
  title: string;
  category: string;
  price: number;
  discount: number;
  description: string;
  imageURL: string;
  amount: number;

  constructor(
    id: number,
    title: string,
    category: string,
    price: number,
    discount: number,
    description: string,
    imageURL: string,
    amount: number,
  ){
    this.id = id;
    this.title = title;
    this.category = category;
    this.price = price;
    this.discount = discount;
    this.description = description;
    this.imageURL = imageURL;
    this.amount = amount;
  }
}