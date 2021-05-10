package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Report;

public class ReportValidator {
    public static List<String> validate(Report r) {
        //// 入力項目チェック
        List<String> errors = new ArrayList<String>();

        String title_error = _validateTitle(r.getTitle());
        if (!title_error.equals("")) {
            errors.add(title_error);
        }

        String content_error = _validateContent(r.getContent());
        if (!content_error.equals("")) {
            errors.add(content_error);
        }

        String syukkin_error = _validateSyukkin(r.getSyukkin());
        if (!syukkin_error.equals("")) {
            errors.add(syukkin_error);

        }

        String taikin_error = _validateTaikin(r.getTaikin());
        if (!taikin_error.equals("")) {
            errors.add(taikin_error);

        }
        return errors;

    }

    private static String _validateTitle(String title) {
        if (title == null || title.equals("")) {
            return "タイトルを入力してください。";
        }

        return "";

    }

    private static String _validateContent(String content) {
        if (content == null || content.equals("")) {
            return "内容を入力してください。";
        }

        return "";

    }

    private static String _validateSyukkin(String syukkin) {
        if (syukkin == null || syukkin.equals("")) {
            return "出勤時間を入力してください";
        }

        return "";
    }

    private static String _validateTaikin(String taikin) {
        if (taikin == null || taikin.equals("")) {
            return "退勤時間を入力してください";
        }

        return "";
    }
}
