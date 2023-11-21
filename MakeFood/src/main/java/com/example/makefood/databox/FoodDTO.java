package com.example.makefood.databox;

public class FoodDTO {
    private String foodName;               /* 음식명 */
    private String foodRecipe;             /* 조리방법 */
    private String foodIngredient;         /* 음식재료 */
    private String foodImage;              /* 음식사진 */
    private String infoWgt;                /* 중량(1인분) */
    private String infoEng;                /* 열량 */
    private String infoCar;                /* 탄수화물 */
    private String infoPro;                /* 단백질 */
    private String infoFat;                /* 지방 */
    private String infoNa;                 /* 나트륨 */

    public FoodDTO() {
    }

    @Override
    public String toString() {
        return "FoodDTO{" +
                "foodName='" + foodName + '\'' +
                ", foodRecipe='" + foodRecipe + '\'' +
                ", foodIngredient='" + foodIngredient + '\'' +
                ", foodImage='" + foodImage + '\'' +
                ", infoWgt='" + infoWgt + '\'' +
                ", infoEng='" + infoEng + '\'' +
                ", infoCar='" + infoCar + '\'' +
                ", infoPro='" + infoPro + '\'' +
                ", infoFat='" + infoFat + '\'' +
                ", infoNa='" + infoNa + '\'' +
                '}';
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodRecipe() {
        return foodRecipe;
    }

    public void setFoodRecipe(String foodRecipe) {
        this.foodRecipe = foodRecipe;
    }

    public String getFoodIngredient() {
        return foodIngredient;
    }

    public void setFoodIngredient(String foodIngredient) {
        this.foodIngredient = foodIngredient;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(String foodImage) {
        this.foodImage = foodImage;
    }

    public String getInfoWgt() {
        return infoWgt;
    }

    public void setInfoWgt(String infoWgt) {
        this.infoWgt = infoWgt;
    }

    public String getInfoEng() {
        return infoEng;
    }

    public void setInfoEng(String infoEng) {
        this.infoEng = infoEng;
    }

    public String getInfoCar() {
        return infoCar;
    }

    public void setInfoCar(String infoCar) {
        this.infoCar = infoCar;
    }

    public String getInfoPro() {
        return infoPro;
    }

    public void setInfoPro(String infoPro) {
        this.infoPro = infoPro;
    }

    public String getInfoFat() {
        return infoFat;
    }

    public void setInfoFat(String infoFat) {
        this.infoFat = infoFat;
    }

    public String getInfoNa() {
        return infoNa;
    }

    public void setInfoNa(String infoNa) {
        this.infoNa = infoNa;
    }

    public FoodDTO(String foodName, String foodRecipe, String foodIngredient, String foodImage, String infoWgt, String infoEng, String infoCar, String infoPro, String infoFat, String infoNa) {
        this.foodName = foodName;
        this.foodRecipe = foodRecipe;
        this.foodIngredient = foodIngredient;
        this.foodImage = foodImage;
        this.infoWgt = infoWgt;
        this.infoEng = infoEng;
        this.infoCar = infoCar;
        this.infoPro = infoPro;
        this.infoFat = infoFat;
        this.infoNa = infoNa;




    }
}
