
$(onload);

function onload() {
	setPresender('category');
	
	if ($('#parent').val() == "null")
		$('#parent').removeAttr("name");
	$('#parent').change(function () {
		var e = $(this);
		if (e.val() == "null")
			e.removeAttr("name");
		else
			e.attr("name", "parent.id");
	});
	
	$('#perpage').on('change', function () {
		document.location.href='?perpage=' + $(this).val();
	});
}

function initCheck() {
	var param = {'nameRu' : 'iffilled',
			'nameEn' : 'iffilled',
			};
	return check(param);
}
