package com.example.web.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User {

	/**
	 * ID
	 */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * 名前
	 */
	@NotBlank(message = "名前を入力してください")
	@Size(max = 50, message = "名前は50文字以内で入力してください")
	@Column(name = "name")
	private String name;

	/**
	 * 住所
	 */
	@Size(max = 100, message = "住所は100文字以内で入力してください")
	@Column(name = "address")
	private String address;

	/**
	 * 電話番号
	 */
	@Pattern(regexp = "|\\d{1,4}-\\d{1,4}-\\d{4}", message = "電話番号の形式（xxxx-xxxx-xxxx）で入力してください")
	@Column(name = "phone")
	private String phone;

	/**
	 * 更新日時
	 */
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "update_date")
	private Date updateDate;

	/**
	 * 登録日時
	 */
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "create_date")
	private Date createDate;

	/**
	 * 削除日時
	 */
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Column(name = "delete_date")
	private Date deleteDate;

}