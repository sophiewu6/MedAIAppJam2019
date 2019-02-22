package com.example.medaiappjam2019;

class RandomForestClassifeer{
private static int findMax(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
        index = nums[i] > nums[index] ? i : index;
        }
        return index;
        }

public static int predict(double[] features) {
        int[] classes = new int[2];

        if (features[2] <= 100.40277862548828) {
        classes[0] = 20;
        classes[1] = 0;
        } else {
        classes[0] = 0;
        classes[1] = 30;
        }
        return findMax(classes);
        }

public static void main(String[] args) {
        if (args.length == 5) {

        // Features:
        double[] features = new double[args.length];
        for (int i = 0, l = args.length; i < l; i++) {
        features[i] = Double.parseDouble(args[i]);
        }

        // Prediction:
        int prediction = DecisionTreeClassifier.predict(features);
        System.out.println(prediction);

        }
        }
}