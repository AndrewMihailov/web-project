
$(onload);

function onload() {
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}
