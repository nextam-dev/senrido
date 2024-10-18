$(function() {
	// ボタンクリック
	$('#LoginBT').click(
			function(e) {
				errorClear();
				var formData = $('#mainForm').serializeArray();
				var data = {};

				$.each(formData, function(bean) {
					data[this.name] = this.value;
				});

				console.log(data);

				$.ajax({
					type : "POST",
					url : "login",
					data : data,
					dataType : "html",
					async : false,
					success : function(data, status, xhr) {
						var baseUrl = $('#baseUrl').val();
						if (data == "AUTH_NG") {
							console.log(data);
							errorDisp("ログインに失敗しました。入力に誤りがあります。");
							return;
						}
						if (data == "AUTH_OK") {
							 location.href = baseUrl + "list";
							return;
						}
						if (data == "LOCK") {
							errorDisp("アカウントがロック中です。社員マスタからロックを解除してください。");
							return;
						}

						errorDisp("パスワードに誤りがあります。現在ログイン失敗回数"
								+ data + "回。");
						errorDisp("4回失敗するとアカウントがロックされます。");
						return;

					},
					error : function(xhr, status, error) {
						if (status == 403) {
							alert("不正なアクセスです");
							return;
						}
						$('#error').show();
					},
					complete : function() {
					}
				});
			});
});
