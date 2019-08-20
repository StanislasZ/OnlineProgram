package com.stan.design_pattern.builder;


/*
    建造者模式：

        使用场景： 类的构造器或静态工厂中具有多个参数

        好处： 模拟了具名的可选参数

        缺点：比重叠构造器模式更加冗长， 也有性能问题

 */
public class NutritionFacts {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {
        //必须的参数
        private final int servingSize;
        private final int servings;

        //可选参数
        private int calories;
        private int fat;
        private int sodium;
        private int carbohydrate;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        //这4个方法返回类型都是Builder， 便于得到一个流式的api
        public Builder calories(int val) {
            calories = val;
            return this;
        }
        public Builder fat(int val) {
            fat = val;
            return this;
        }
        public Builder sodium(int val) {
            sodium = val;
            return this;
        }
        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    //私有构造器
    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }



    public static void main(String[] args) {
        //链式
        NutritionFacts cocaCola = new Builder(240, 8)
                                    .calories(100)
                                    .sodium(35)
                                    .carbohydrate(27)
                                    .build();
    }
}
