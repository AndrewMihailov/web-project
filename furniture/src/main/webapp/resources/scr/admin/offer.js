
$(onload);

function onload() {
	setPresender('offer');
	
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}

function initCheck() {
	var param = {'size' : 'isNumber'};
	return check(param);
}
