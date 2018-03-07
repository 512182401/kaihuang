package com.kaihuang.nansui.module.entry;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * 用户实体类
 * @author admin
 *方式一：Code-->Generate

方式二：通过快捷键Alt+Insert
 */
public class User implements Serializable {


	/**
	 * position : 0
	 * sex : 1
	 * phone : 18899776590
	 * shim :
	 * remark :
	 * todayFkNum : 0
	 * score :
	 * enableScore :
	 * qrcodeUrl : http://test.app.srv.quchangkeji.com:8083/tsAPI/pages/share/shareMyHome.html?params=ff8081815953f6b101596204d6e00002
	 * gznum : 4
	 * birthd : 2011-04-03
	 * loginType : 1
	 * id : ff8081815953f6b101596204d6e00002
	 * bankNo :
	 * level : 1
	 * fkBfb : 0%
	 * homeImgUrl : http://test.app.srv.quchangkeji.com:8083/tsAPI/files/home/ff8081815953f6b101596204d6e00002/2017-04-15/ff8080815b6bcc47015b6f3aeccd0011_20170415092944_image.png
	 * imgHeadUrl : http://test.app.srv.quchangkeji.com:8083/tsAPI/files/vip/ff8081815953f6b101596204d6e00002/2017-04-12/ff8081815b5b0d94015b61389c570066_20170412161231_iamge.png
	 * name : 盗人
	 * money : 0
	 * levelName : 草根歌手
	 * createDate : 2017-01-03 09:50:01
	 * qq : 3C469F6DC642063E13297E066A26E215
	 * allScore :
	 * platform : 2
	 * idCard :
	 * gyqImgUrl : http://test.app.srv.quchangkeji.com:8083/tsAPI/files/(NULL)
	 * yaoqm :
	 * xhsum : 10
	 * isqd : 1
	 * jfsum : 320
	 * levelImg : http://test.app.srv.quchangkeji.com:8083/tsAPI/files/dj/home/caogen.png
	 * myId : 2014391054
	 * url : http://test.app.srv.quchangkeji.com:8083/tsAPI/pages/share/shareMyHome.html?params=ff8081815953f6b101596204d6e00002
	 * shebh : 325cced6936b1e1
	 * weix :
	 * qcbsum : 2211
	 * allFkNum : 3
	 * realName :
	 * fsnum : 3
	 * weibo :
	 */

	private String position;
	private String sex;
	private String phone;
	private String shim;
	private String remark;
	private int todayFkNum;
	private String score;
	private String enableScore;
	private String qrcodeUrl;
	private int gznum;
	private String birthd;
	private String loginType;
	private String id;
	private String bankNo;
	private String level;
	private String fkBfb;
	private String homeImgUrl;
	private String imgHeadUrl;
	private String name;
	private int money;
	private String levelName;
	private String createDate;
	private String qq;
	private String allScore;
	private String platform;
	private String idCard;
	private String gyqImgUrl;
	private String yaoqm;
	private float xhsum;
	private String isqd;
	private String jfsum;
	private String levelImg;
	private String myId;
	private String url;
	private String shebh;
	private String weix;
	private float qcbsum;
	private int allFkNum;
	private String realName;
	private int fsnum;
	private String weibo;

	private String addressId;
	private String asPhone;
	private String asName;
	private String address;
	private String sheng;
	private String shi;
	private String qu;

	public static User objectFromData(String str) {

		return new Gson().fromJson(str, User.class);
	}

	public static User objectFromData(String str, String key) {

		try {
			JSONObject jsonObject = new JSONObject(str);

			return new Gson().fromJson(jsonObject.getString(key), User.class);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<User> arrayUserFromData(String str) {

		Type listType = new TypeToken<ArrayList<User>>() {
		}.getType();

		return new Gson().fromJson(str, listType);
	}

	public static List<User> arrayUserFromData(String str, String key) {

		try {
			JSONObject jsonObject = new JSONObject(str);
			Type listType = new TypeToken<ArrayList<User>>() {
			}.getType();

			return new Gson().fromJson(jsonObject.getString(key), listType);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return new ArrayList();


	}


	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getAsPhone() {
		return asPhone;
	}

	public void setAsPhone(String asPhone) {
		this.asPhone = asPhone;
	}

	public String getAsName() {
		return asName;
	}

	public void setAsName(String asName) {
		this.asName = asName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSheng() {
		return sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getQu() {
		return qu;
	}

	public void setQu(String qu) {
		this.qu = qu;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShim() {
		return shim;
	}

	public void setShim(String shim) {
		this.shim = shim;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getTodayFkNum() {
		return todayFkNum;
	}

	public void setTodayFkNum(int todayFkNum) {
		this.todayFkNum = todayFkNum;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getEnableScore() {
		return enableScore;
	}

	public void setEnableScore(String enableScore) {
		this.enableScore = enableScore;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	public int getGznum() {
		return gznum;
	}

	public void setGznum(int gznum) {
		this.gznum = gznum;
	}

	public String getBirthd() {
		return birthd;
	}

	public void setBirthd(String birthd) {
		this.birthd = birthd;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getFkBfb() {
		return fkBfb;
	}

	public void setFkBfb(String fkBfb) {
		this.fkBfb = fkBfb;
	}

	public String getHomeImgUrl() {
		return homeImgUrl;
	}

	public void setHomeImgUrl(String homeImgUrl) {
		this.homeImgUrl = homeImgUrl;
	}

	public String getImgHeadUrl() {
		return imgHeadUrl;
	}

	public void setImgHeadUrl(String imgHeadUrl) {
		this.imgHeadUrl = imgHeadUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getAllScore() {
		return allScore;
	}

	public void setAllScore(String allScore) {
		this.allScore = allScore;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getGyqImgUrl() {
		return gyqImgUrl;
	}

	public void setGyqImgUrl(String gyqImgUrl) {
		this.gyqImgUrl = gyqImgUrl;
	}

	public String getYaoqm() {
		return yaoqm;
	}

	public void setYaoqm(String yaoqm) {
		this.yaoqm = yaoqm;
	}

	public float getXhsum() {
		return xhsum;
	}

	public void setXhsum(float xhsum) {
		this.xhsum = xhsum;
	}

	public String getIsqd() {
		return isqd;
	}

	public void setIsqd(String isqd) {
		this.isqd = isqd;
	}

	public String getJfsum() {
		return jfsum;
	}

	public void setJfsum(String jfsum) {
		this.jfsum = jfsum;
	}

	public String getLevelImg() {
		return levelImg;
	}

	public void setLevelImg(String levelImg) {
		this.levelImg = levelImg;
	}

	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getShebh() {
		return shebh;
	}

	public void setShebh(String shebh) {
		this.shebh = shebh;
	}

	public String getWeix() {
		return weix;
	}

	public void setWeix(String weix) {
		this.weix = weix;
	}

	public float getQcbsum() {
		return qcbsum;
	}

	public void setQcbsum(float qcbsum) {
		this.qcbsum = qcbsum;
	}

	public int getAllFkNum() {
		return allFkNum;
	}

	public void setAllFkNum(int allFkNum) {
		this.allFkNum = allFkNum;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getFsnum() {
		return fsnum;
	}

	public void setFsnum(int fsnum) {
		this.fsnum = fsnum;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
}
