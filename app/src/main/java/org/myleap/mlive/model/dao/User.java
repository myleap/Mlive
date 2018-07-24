package org.myleap.mlive.model.dao;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
	private String userId = "";
	private String nickname = "";
	private String phoneNum = "";
	private String urlPic = "";

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getUrlPic() {
		return urlPic;
	}

	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}

	public static final Creator<User> CREATOR = new Creator<User>() {
		public User createFromParcel(Parcel in) {
			return new User(in);
		}

		public User[] newArray(int size) {
			return new User[size];
		}
	};

	public User() {
	}

	private User(Parcel in) {
		userId = in.readString();
		nickname = in.readString();
		phoneNum = in.readString();
		urlPic = in.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(userId);
		dest.writeString(nickname);
		dest.writeString(phoneNum);
		dest.writeString(urlPic);

	}
}
