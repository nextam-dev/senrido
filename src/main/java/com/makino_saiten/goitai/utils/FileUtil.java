package com.makino_saiten.goitai.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 * ファイルに関するユーティリティークラス
 * </pre>
 *
 * @author Y.Kawatani
 * @version 1.0.0
 */
public final class FileUtil {

	/**
	 * Base64デコードします。
	 *
	 * <pre>
	 * 引数に「QmFzZTY044OH44Kz44O844OJ」（に対するバイト配列）をセットすると、「Base64デコード」（に対するバイト配列）を返却します。
	 * </pre>
	 *
	 * @param base64Data Base64エンコード文字列
	 * @return デコードした文字列
	 */
	public static byte[] decodeBase64(byte[] base64Data) {
		return Base64.decodeBase64(base64Data);
	}

	/**
	 * ファイル、ディレクトリ存在チェック.
	 *
	 * @param path
	 * @return boolean
	 */
	public static boolean isExists(String path) {
		if (StringUtil.isBlank(path)) {
			return false;
		}
		File file = new File(path);
		return file.exists();
	}

	/**
	 * ディレクトリを作成します.
	 *
	 * @param path
	 * @return boolean
	 */
	public static boolean mkDir(String path) {
		File file = new File(path);
		return file.mkdir();
	}

	/**
	 * ディレクトリを作成します(親ディレクトリも作成).
	 *
	 * @param path
	 * @return boolean
	 */
	public static boolean mkDirs(String path) {
		File file = new File(path);
		return file.mkdirs();
	}

	/**
	 * 指定されたパスの下を全削除する.
	 *
	 * @param path
	 */
	public static void delete(String path) {
		File file = new File(path);
		delete(file);
	}

	/**
	 * 指定されたパスの下を全削除する.
	 *
	 * @param path
	 */
	public static void delete(File file) {
		if (file.isFile()) {
			// ファイルの場合は削除する
			file.delete();

		} else if (file.isDirectory()) {
			// ディレクトリの場合は、すべてのファイルを削除する

			// 対象ディレクトリ内のファイルおよびディレクトリの一覧を取得
			File[] files = file.listFiles();

			// ファイルおよびディレクトリをすべて削除
			for (int i = 0; i < files.length; i++) {
				// 自身をコールし、再帰的に削除する
				delete(files[i]);
			}
			// 自ディレクトリを削除する
			file.delete();
		}
	}

	/**
	 * パスからファイル名を取得する処理.
	 *
	 * @param path
	 * @return String
	 */
	public static String getFileName(String path) {
		if (StringUtil.isBlank(path)) {
			return null;
		}
		path = path.replace("\\", getSeparator());

		int pos = path.lastIndexOf(getSeparator());
		if (pos == -1) {
			return path;
		}

		return path.substring(pos + 1);
	}

	/**
	 * separatorを返す
	 *
	 * @return String
	 */
	public static String getSeparator() {
		return FileSystems.getDefault().getSeparator();
	}

	/**
	 * マルチをファイルに変換
	 *
	 * @throws IOException
	 *
	 */
	public static File convert(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(file.getBytes());
		fos.close();
		return convFile;
	}
}
