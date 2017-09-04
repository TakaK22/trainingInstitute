package jin.edu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

import jin.edu.common.DBConnectCommon;
import jin.edu.dto.ShainInfoDto;

public class ShainInfoDao extends DBConnectCommon {

    // SQLを定義する。
    private final static String SELECT_SHAININFO = ""
            + "SELECT "
            + "SHAIN_NO, "
            + "SHAIN_NAME_KJ, "
            + "SHAIN_NAME_KN "
            + "FROM SHAIN_INFO "
            + "WHERE "
            + "SHAIN_NO = ? ";

    private final static String SELECT_SHAININFO_BUSHOINFO = ""
            + "SELECT "
            + "  si.SHAIN_NO "
            + "  ,si.SHAIN_NAME_KJ "
            + "  ,si.SHAIN_NAME_KN "
            + "  ,bi.BUSHO_NO "
            + "  ,bi.BUSHO_NAME_KJ "
            + "  ,bi.BUSHO_NAME_KN "
            + "FROM "
            + "  SHAIN_INFO si "
            + "INNER JOIN "
            + "  BUSHO_INFO bi "
            + "ON bi.SHAIN_NO=si.SHAIN_NO "
            + "WHERE "
            + "  si.SHAIN_NO = ? ";

    /**
     * 社員情報取得処理 概要：社員情報を取得します。
     *
     * @param 社員番号
     * @return 社員情報
     */
    public ShainInfoDto select(String shainNo) {

        // PreparedStatementを定義する。
        PreparedStatement statement = null;

        // StringBuilderを定義する。
        StringBuilder sql = new StringBuilder();

        // ResultSetを定義する。
        ResultSet rs = null;

        // 社員情報取得領域を生成する。
        ShainInfoDto shainInfoDto = new ShainInfoDto();

        try {

            // DB接続
            super.connect();

            // SQLをStringBuilderに設定する。
            sql.append(SELECT_SHAININFO_BUSHOINFO);

            // 初期のSQLをPreparedStatementに設定する。
            statement = con.prepareStatement(sql.toString());

            // SQLに番号を設定する。
            statement.setString(1, shainNo);

            // SQLを実行する。
            rs = statement.executeQuery();

            if (rs.next()) {
                // 社員番号を設定する。
                shainInfoDto.setShainNo(rs.getString("SHAIN_NO"));

                // 社員名(漢字)を設定する。
                shainInfoDto.setShainNameKj(rs.getString("SHAIN_NAME_KJ"));

                // 社員名(カナ)を設定する。
                shainInfoDto.setShainNameKn(rs.getString("SHAIN_NAME_KN"));

                // 部署番号を設定する。
                shainInfoDto.setBushoNo(rs.getString("BUSHO_NO"));

                // 部署名(漢字)を設定する。
                shainInfoDto.setBushoNameKj(rs.getString("BUSHO_NAME_KJ"));

                // 部署名(カナ)を設定する。
                shainInfoDto.setBushoNameKn(rs.getString("BUSHO_NAME_KN"));

            }
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // DBをクローズする。
                super.disConnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return shainInfoDto;
    }
}
