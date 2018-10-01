package robot;

/**
 * 
 * @author Administrator
 *
 */
public class House {
	private String houseName;
	private String houseType; // 房屋类型
	private String blockType; // 建筑类型
	private String blockAge; // 建筑年代
	private String FAR; // 容积率
	private String fee; // 物业费
	private String pManage; // 物业
	private String company; // 开发商
	private String imgUrl; // 图片url

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getBlockType() {
		return blockType;
	}

	public void setBlockType(String blockType) {
		this.blockType = blockType;
	}

	public String getBlockAge() {
		return blockAge;
	}

	public void setBlockAge(String blockAge) {
		this.blockAge = blockAge;
	}

	public String getFAR() {
		return FAR;
	}

	public void setFAR(String fAR) {
		FAR = fAR;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getpManage() {
		return pManage;
	}

	public void setpManage(String pManage) {
		this.pManage = pManage;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
