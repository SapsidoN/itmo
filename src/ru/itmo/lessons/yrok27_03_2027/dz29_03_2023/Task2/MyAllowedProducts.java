package ru.itmo.lessons.yrok27_03_2027.dz29_03_2023.Task2;

import ru.itmo.lessons.yrok27_03_2027.dz29_03_2023.Climber;

public class MyAllowedProducts {
 private double MaxSquirrels;
 private double MaxFats;
 private double MaxCarbohydrates;
 private double MaxCalories;
 private Product[] arr=new Product[0];

  public MyAllowedProducts(double MaxSquirrels,double MaxFats, double MaxCarbohydrates,double MaxCalories){
      if ( MaxSquirrels >= 0 && MaxFats>=0 && MaxCarbohydrates>=0 && MaxCalories>=0) {
          this.MaxSquirrels=MaxSquirrels;
          this.MaxFats=MaxFats;
          this.MaxCarbohydrates=MaxCarbohydrates;
          this.MaxCalories=MaxCalories;
      }
      else throw new IllegalArgumentException("ошибка введеных данных");
  }

public void AddProduct(Product ar){
      if(proverka(ar)) {
          if (arr.length == 0) {
              arr = new Product[1];
              arr[0] = ar;
          } else {
              Product[] arr2 = new Product[arr.length + 1];
              for (int i = 0; i < arr.length; i++) {
                  arr2[i] = arr[i];
              }
              arr2[arr.length] = ar;
              arr = arr2;
          }
      }
      else System.out.println("ошибка");
    }



    private boolean proverka(Product pr){
     if(pr==null){
          throw new IllegalArgumentException("продукт null");
     }
      else if(pr.getCarbohydrates()>MaxCarbohydrates) {
          System.out.println("перебор Углеводов");
          return false;
      }
        else if(pr.getCalories()>MaxCalories) {
            System.out.println("перебор каллорий");
            return false;
        }
      else if (pr.getSquirrels()>MaxSquirrels) {
            System.out.println("перебор белков");
            return false;
        }
        else if  (pr.getFats()>MaxFats) {
            System.out.println("перебор жиров");
            return false;
        }
    else return true;

    }

    public void PrintProduct(){
      if(arr.length==0) System.out.println("продуктов нет");
      else
      for(var a: arr){
          a.print();
      }
    }
}
