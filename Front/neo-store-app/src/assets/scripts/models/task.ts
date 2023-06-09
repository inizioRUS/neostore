import { Worker } from './worker';

export class Task {
  id: number;
  name: string;
  description: string;
  difficulty: number;
  isDone: boolean;
  postId: number;
  worker: Worker;

  constructor(
    id: number,
    name: string,
    description: string,
    difficulty: number,
    isDone: boolean,
    postId: number,
    worker: Worker
  ) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.difficulty = difficulty;
    this.isDone = isDone;
    this.postId = postId;
    this.worker = worker;
  }
}