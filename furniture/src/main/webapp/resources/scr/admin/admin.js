
function load(id) {
	$.getJSON("get-admin", { id: id }, function(admin) {
		$('#login').val(admin.login);
		$('#password').val(admin.password);
	});
}