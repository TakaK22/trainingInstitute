package jin.edu.dto;

public class ShainInfoDto {
	 /** 社員番号 */
	public String shainNo;

	 /** 社員名(漢字) */
	public String shainNameKj;

	 /** 社員名(カナ) */
	public String shainNameKn;

	 /**
	 * 社員番号を設定します。
	 * @param 社員番号 shainNo
	 */
	public void setShainNo(String shainNo) {
	    this.shainNo = shainNo;
	}

	/**
	 * 社員番号を取得します。
	 * @return 社員番号 shainNo
	 */
	public String getShainNo() {
	    return shainNo;
	}

	/**
	 * 社員名(漢字)を設定します。
	 * @param 社員名(漢字) shainNameKj
	 */
	public void setShainNameKj(String shainNameKj) {
	    this.shainNameKj = shainNameKj;
	}

	/**
	 * 社員名(漢字)を取得します。
	 * @return 社員名(漢字) shainNameKj
	 */
	public String getShainNameKj() {
	    return shainNameKj;
	}

	/**
	 * 社員名(カナ)を設定します。
	 * @param 社員名(カナ) shainNameKn
	 */
	public void setShainNameKn(String shainNameKn) {
	    this.shainNameKn = shainNameKn;
	}

	/**
	 * 社員名(カナ)を取得します。
	 * @return 社員名(カナ) shainNameKn
	 */
	public String getShainNameKn() {
	    return shainNameKn;
	}
}

