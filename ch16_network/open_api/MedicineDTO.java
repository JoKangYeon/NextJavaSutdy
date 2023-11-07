package ch16_network.open_api;

public class MedicineDTO {
    private String entpName;    /* 회사명 */
    private String itemName;            /* 약품명 */
    private String efcyQesitm;           /* 설명 */

    public MedicineDTO() {
    }

    public MedicineDTO(String entpName, String itemName, String efcyQesitm) {
        this.entpName = entpName;
        this.itemName = itemName;
        this.efcyQesitm = efcyQesitm;
    }

    @Override
    public String toString() {
        return "MedicineDTO{" +
                "entpName='" + entpName + '\'' +
                ", itemName='" + itemName + '\'' +
                ", efcyQesitm='" + efcyQesitm + '\'' +
                '}';
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEfcyQesitm() {
        return efcyQesitm;
    }

    public void setEfcyQesitm(String efcyQesitm) {
        this.efcyQesitm = efcyQesitm;
    }
}
