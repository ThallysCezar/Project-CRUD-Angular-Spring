import { Course } from "./course";


export interface CoursePage {
  courses: Coursese[];
  totalElements: number;
  totalPages?: number;
}
