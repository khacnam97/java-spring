/**
 * 
 */

/*var x = document.getElementById("btnDelete");
			x.addEventListener("click", (event) => {
				alert("Hello World!");
			});*/

(function($) {

	var user_id;
	$(document).on('click', '.delete', function() {
		user_id = $(this).attr('data-id')

	});
	$(document).on('click', '#btnDelete', function() {
		$.ajax({
			headers: {
				'X-CSRF-TOKEN': $('meta[name="csrf-token"]').attr('content')
			},
			url: "delete/" + user_id,
			type: 'DELETE',
			contentType: 'application/json',
			data: {
				"id": user_id,
				'_token': '{{csrf_token()}}'
			},
			success: function(data) {
				console.log("susscess")

				$('#deleteModal').modal('hide');
				$('body').removeClass('modal-open');
				$('.modal-backdrop').remove();
				window.location.reload();
			},
			error: function(data) {
				console.log("error")
				$('#deleteModal').modal('toggle');
			}
		})
	});
})(jQuery);